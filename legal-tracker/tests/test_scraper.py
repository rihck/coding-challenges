from pathlib import Path
from scraper import parse_case_list, parse_case_detail

FIXTURES = Path(__file__).parent / "fixtures"


def test_parse_case_list_returns_case_numbers():
    html = (FIXTURES / "search_results.html").read_text()
    cases = parse_case_list(html)
    numbers = [c["number"] for c in cases]
    assert "1000990-64.2024.8.26.0100" in numbers
    assert "1002350-11.2023.8.26.0010" in numbers


def test_parse_case_list_returns_detail_links():
    html = (FIXTURES / "search_results.html").read_text()
    cases = parse_case_list(html)
    for case in cases:
        assert "show.do" in case["detail_url"]
        assert "processo.codigo" in case["detail_url"]


def test_parse_case_list_count():
    html = (FIXTURES / "search_results.html").read_text()
    cases = parse_case_list(html)
    assert len(cases) == 2


def test_parse_case_detail_returns_movements():
    html = (FIXTURES / "case_detail.html").read_text()
    detail = parse_case_detail(html)
    movements = detail["movements"]
    assert len(movements) == 3
    assert movements[0]["date"] == "03/04/2024"
    assert "Intime-se" in movements[0]["text"]


def test_parse_case_detail_second_movement():
    html = (FIXTURES / "case_detail.html").read_text()
    detail = parse_case_detail(html)
    movements = detail["movements"]
    assert movements[1]["date"] == "01/04/2024"
    assert "Juntada" in movements[1]["text"]


def test_parse_case_detail_returns_metadata():
    html = (FIXTURES / "case_detail.html").read_text()
    detail = parse_case_detail(html)
    meta = detail["metadata"]
    assert meta["classe"] == "Procedimento Comum Cível"
    assert meta["juiz"] == "João Silva"
    assert meta["vara"] == "1ª Vara Cível"
    assert meta["foro"] == "Foro Central Cível"
    assert meta["assunto"] == "Indenização por Dano Moral"
