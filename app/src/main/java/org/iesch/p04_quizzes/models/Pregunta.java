package org.iesch.p04_quizzes.models;

public class Pregunta {
    String Enunciado;
    String RespuestaCorrecta;
    String RespuestaIncorrecta;
    int Numero;

    public String getEnunciado() {
        return Enunciado;
    }

    public void setEnunciado(String enunciado) {
        Enunciado = enunciado;
    }

    public String getRespuestaCorrecta() {
        return RespuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        RespuestaCorrecta = respuestaCorrecta;
    }

    public String getRespuestaIncorrecta() {
        return RespuestaIncorrecta;
    }

    public void setRespuestaIncorrecta(String respuestaIncorrecta) {
        RespuestaIncorrecta = respuestaIncorrecta;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public Pregunta(String enunciado, String respuestaCorrecta, String respuestaIncorrecta, int numero) {
        Enunciado = enunciado;
        RespuestaCorrecta = respuestaCorrecta;
        RespuestaIncorrecta = respuestaIncorrecta;
        Numero = numero;
    }
}
