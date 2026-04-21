import json
from pathlib import Path


def load_state(path: str) -> dict:
    p = Path(path)
    if not p.exists():
        return {}
    return json.loads(p.read_text(encoding="utf-8"))


def save_state(path: str, state: dict):
    p = Path(path)
    p.parent.mkdir(parents=True, exist_ok=True)
    p.write_text(json.dumps(state, ensure_ascii=False, indent=2), encoding="utf-8")


def diff_movements(stored_movements: list, current_movements: list) -> list:
    stored_texts = {m["text"] for m in stored_movements}
    return [m for m in current_movements if m["text"] not in stored_texts]
