from unittest.mock import patch, MagicMock
from notifier import format_message, send_telegram


def test_message_format_high_urgency():
    movements = [{"date": "03/04/2024", "text": "Intime-se a parte autora."}]
    msg = format_message("1000990-64.2024.8.26.0100", movements, "high")
    assert "🚨" in msg
    assert "URGENTE" in msg
    assert "1000990-64.2024.8.26.0100" in msg
    assert "03/04/2024" in msg
    assert "Intime-se" in msg


def test_message_format_medium_urgency():
    movements = [{"date": "01/04/2024", "text": "Prazo de 15 dias."}]
    msg = format_message("1234567-89.2024.8.26.0001", movements, "medium")
    assert "⚠️" in msg
    assert "Atenção" in msg


def test_message_format_no_urgency():
    movements = [{"date": "01/04/2024", "text": "Certidão expedida."}]
    msg = format_message("1234567-89.2024.8.26.0001", movements, "none")
    assert "ℹ️" in msg
    assert "Informativo" in msg


def test_message_format_multiple_movements():
    movements = [
        {"date": "03/04/2024", "text": "Intime-se a parte."},
        {"date": "01/04/2024", "text": "Juntada de documentos."},
    ]
    msg = format_message("1000990-64.2024.8.26.0100", movements, "high")
    assert "03/04/2024" in msg
    assert "01/04/2024" in msg
    assert "Intime-se" in msg
    assert "Juntada" in msg


def test_send_telegram_calls_correct_url():
    with patch("notifier.requests.post") as mock_post:
        mock_resp = MagicMock()
        mock_resp.raise_for_status.return_value = None
        mock_post.return_value = mock_resp
        send_telegram("test_token", "123456", "Test message")
        call_args = mock_post.call_args
        assert "test_token" in call_args[0][0]
        assert call_args[1]["json"]["chat_id"] == "123456"
        assert call_args[1]["json"]["text"] == "Test message"


def test_send_telegram_uses_markdown():
    with patch("notifier.requests.post") as mock_post:
        mock_resp = MagicMock()
        mock_resp.raise_for_status.return_value = None
        mock_post.return_value = mock_resp
        send_telegram("tok", "999", "msg")
        assert mock_post.call_args[1]["json"]["parse_mode"] == "Markdown"
