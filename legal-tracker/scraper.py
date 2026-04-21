import time
import requests
from bs4 import BeautifulSoup

BASE_URL = "https://esaj.tjsp.jus.br"
SEARCH_URL = f"{BASE_URL}/cpopg/search.do"
HEADERS = {
    "User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36",
    "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
    "Accept-Language": "pt-BR,pt;q=0.9,en;q=0.8",
}


def _make_session():
    s = requests.Session()
    s.headers.update(HEADERS)
    return s


def fetch_case_list(cpf: str, session=None) -> list[dict]:
    if session is None:
        session = _make_session()
    params = {
        "cbPesquisa": "DOCPARTE",
        "dadosConsulta.valorConsulta": cpf,
        "cdForo": "-1",
        "dadosConsulta.localPesquisa.cdLocal": "-1",
        "gateway": "true",
    }
    resp = session.get(SEARCH_URL, params=params, timeout=30)
    resp.raise_for_status()
    return parse_case_list(resp.text)


def parse_case_list(html: str) -> list[dict]:
    soup = BeautifulSoup(html, "lxml")
    cases = []
    seen_numbers = set()
    for a in soup.find_all("a", href=True):
        href = a["href"]
        if "show.do" not in href or "processo.codigo" not in href:
            continue
        number = a.get_text(strip=True)
        if not number:
            number = a.get("title", "").strip()
        if not number or "-" not in number or number in seen_numbers:
            continue
        url = href if href.startswith("http") else BASE_URL + href
        cases.append({"number": number, "detail_url": url})
        seen_numbers.add(number)
    return cases


def fetch_case_detail(url: str, session=None) -> dict:
    if session is None:
        session = _make_session()
    time.sleep(2)
    resp = session.get(url, timeout=30)
    resp.raise_for_status()
    return parse_case_detail(resp.text)


def parse_case_detail(html: str) -> dict:
    soup = BeautifulSoup(html, "lxml")

    def get_field(id_):
        el = soup.find(id=id_)
        return el.get_text(strip=True) if el else ""

    metadata = {
        "classe": get_field("classeProcesso"),
        "assunto": get_field("assuntoProcesso"),
        "foro": get_field("foroProcesso"),
        "vara": get_field("varaProcesso"),
        "juiz": get_field("juizProcesso"),
    }

    movements = []
    table = soup.find(id="tabelaTodasMovimentacoes")
    if table:
        for row in table.find_all("tr"):
            date_td = row.find(class_="dataMovimentacao")
            desc_td = row.find(class_="descricaoMovimentacao")
            if date_td and desc_td:
                movements.append({
                    "date": date_td.get_text(strip=True),
                    "text": desc_td.get_text(" ", strip=True),
                })

    return {"metadata": metadata, "movements": movements}
