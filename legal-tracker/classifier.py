HIGH_KEYWORDS = [
    "intime-se", "intimação", "citação", "mandado", "liminar",
    "prazo fatal", "urgente", "tutela antecipada", "antecipação de tutela",
    "embargo", "penhora", "arresto", "bloqueio",
]
MEDIUM_KEYWORDS = [
    "prazo", "diligência", "determina", "notifique", "vista",
    "manifeste", "apresente", "junte", "cumpra",
]


def classify(text: str) -> str:
    lower = text.lower()
    for kw in HIGH_KEYWORDS:
        if kw in lower:
            return "high"
    for kw in MEDIUM_KEYWORDS:
        if kw in lower:
            return "medium"
    return "none"
