import tempfile
from pathlib import Path
from state import load_state, save_state, diff_movements


def test_load_state_returns_empty_dict_when_file_missing():
    assert load_state("/tmp/nonexistent_abc_legal_tracker_xyz.json") == {}


def test_save_and_load_roundtrip():
    with tempfile.NamedTemporaryFile(suffix=".json", delete=False) as f:
        path = f.name
    state = {
        "1234567-89.2024.8.26.0001": {
            "movements": [{"date": "01/04/2024", "text": "Conclusão ao juiz"}]
        }
    }
    save_state(path, state)
    loaded = load_state(path)
    assert loaded == state


def test_save_creates_parent_dirs():
    with tempfile.TemporaryDirectory() as d:
        path = f"{d}/sub/dir/state.json"
        save_state(path, {"key": "value"})
        assert Path(path).exists()


def test_new_movements_detected():
    stored = [{"date": "01/04/2024", "text": "Conclusão ao juiz"}]
    current = [
        {"date": "03/04/2024", "text": "Intime-se a parte"},
        {"date": "01/04/2024", "text": "Conclusão ao juiz"},
    ]
    new = diff_movements(stored, current)
    assert len(new) == 1
    assert new[0]["text"] == "Intime-se a parte"


def test_no_changes_when_same_state():
    movements = [{"date": "01/04/2024", "text": "Conclusão ao juiz"}]
    new = diff_movements(movements, movements)
    assert new == []


def test_all_new_when_stored_empty():
    current = [
        {"date": "03/04/2024", "text": "Intime-se"},
        {"date": "01/04/2024", "text": "Conclusão"},
    ]
    new = diff_movements([], current)
    assert len(new) == 2


def test_preserves_order_of_new_movements():
    stored = [{"date": "01/04/2024", "text": "Movimento antigo"}]
    current = [
        {"date": "05/04/2024", "text": "Terceiro movimento"},
        {"date": "03/04/2024", "text": "Segundo movimento"},
        {"date": "01/04/2024", "text": "Movimento antigo"},
    ]
    new = diff_movements(stored, current)
    assert new[0]["text"] == "Terceiro movimento"
    assert new[1]["text"] == "Segundo movimento"
