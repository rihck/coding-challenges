from classifier import classify


def test_high_urgency_detected_intimese():
    assert classify("Intime-se a parte autora para manifestação.") == "high"


def test_high_urgency_detected_citacao():
    assert classify("Expeça-se mandado de citação ao réu.") == "high"


def test_high_urgency_detected_liminar():
    assert classify("Defiro a liminar requerida pela parte autora.") == "high"


def test_high_urgency_detected_penhora():
    assert classify("Determino a penhora dos bens do devedor.") == "high"


def test_medium_urgency_detected_prazo():
    assert classify("Concedo prazo de 15 dias para manifestação.") == "medium"


def test_medium_urgency_detected_manifeste():
    assert classify("Manifeste-se a parte ré sobre o recurso.") == "medium"


def test_medium_urgency_detected_vista():
    assert classify("Dê-se vista dos autos ao Ministério Público.") == "medium"


def test_no_urgency_for_normal_movement():
    assert classify("Certidão expedida conforme requerimento.") == "none"


def test_no_urgency_for_conclusion():
    assert classify("Processo concluso ao Juiz(a) de Direito.") == "none"


def test_case_insensitive_high():
    assert classify("INTIME-SE a parte.") == "high"


def test_case_insensitive_medium():
    assert classify("PRAZO de 30 dias.") == "medium"


def test_high_takes_priority_over_medium():
    assert classify("prazo fatal para citação") == "high"
