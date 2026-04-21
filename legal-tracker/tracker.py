import os
import sys
from pathlib import Path

from scraper import fetch_case_list, fetch_case_detail
from classifier import classify
from notifier import format_message, send_telegram
from state import load_state, save_state, diff_movements

STATE_PATH = Path(__file__).parent / "state" / "cases.json"

URGENCY_RANK = {"high": 2, "medium": 1, "none": 0}


def main():
    cpf = os.environ.get("CPF")
    token = os.environ.get("TELEGRAM_BOT_TOKEN")
    chat_id = os.environ.get("TELEGRAM_CHAT_ID")

    if not cpf:
        print("ERROR: CPF env var not set", file=sys.stderr)
        sys.exit(1)
    if not token or not chat_id:
        print("ERROR: TELEGRAM_BOT_TOKEN and TELEGRAM_CHAT_ID must be set", file=sys.stderr)
        sys.exit(1)

    state = load_state(str(STATE_PATH))
    cases = fetch_case_list(cpf)
    print(f"Found {len(cases)} case(s)")

    updated_state = dict(state)
    for case in cases:
        number = case["number"]
        print(f"Processing {number}...")
        detail = fetch_case_detail(case["detail_url"])
        current_movements = detail["movements"]
        stored_movements = state.get(number, {}).get("movements", [])
        new_movements = diff_movements(stored_movements, current_movements)

        if new_movements:
            urgency = max(
                (classify(m["text"]) for m in new_movements),
                key=lambda x: URGENCY_RANK[x],
            )
            msg = format_message(number, new_movements, urgency)
            print(f"  {len(new_movements)} new movement(s) — urgency: {urgency}")
            send_telegram(token, chat_id, msg)
        else:
            print("  No new movements.")

        updated_state[number] = {
            "metadata": detail["metadata"],
            "movements": current_movements,
        }

    save_state(str(STATE_PATH), updated_state)
    print("State saved.")


if __name__ == "__main__":
    main()
