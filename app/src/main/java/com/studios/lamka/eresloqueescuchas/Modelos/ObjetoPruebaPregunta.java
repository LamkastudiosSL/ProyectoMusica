package com.studios.lamka.eresloqueescuchas.Modelos;

import java.util.Arrays;

public class ObjetoPruebaPregunta {

    private String pregunta;
    private String[] respuestas;

    public ObjetoPruebaPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public ObjetoPruebaPregunta(String pregunta, String[] respuestas) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    @Override
    public String toString() {
        return
                "pregunta='" + pregunta + '\'' +
                ", respuestas=" + Arrays.toString(respuestas) +
                '}';
    }
}
