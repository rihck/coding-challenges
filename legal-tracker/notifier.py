import requests

TELEGRAM_API = "https://api.telegram.org/bot{token}/sendMessage"
URGENCY_EMOJI = {"high": "🚨", "medium": "⚠️", "none": "ℹ️"}
URGENCY_LABEL = {"high": "URGENTE", "medium": "Atenção", "none": "Informativo"}


def format_message(case_number: str, new_movements: list, urgency: str) -> str:
    emoji = URGENCY_EMOJI[urgency]
    label = URGENCY_LABEL[urgency]
    lines = [f"{emoji} *{label}* — Processo {case_number}", ""]
    for m in new_movements:
        lines.append(f"📅 {m['date']}")
        lines.append(m["text"])
        lines.append("")
    return "\n".join(lines).strip()


def send_telegram(token: str, chat_id: str, message: str):
    url = TELEGRAM_API.format(token=token)
    resp = requests.post(
        url,
        json={"chat_id": chat_id, "text": message, "parse_mode": "Markdown"},
        timeout=15,
    )
    resp.raise_for_status()
