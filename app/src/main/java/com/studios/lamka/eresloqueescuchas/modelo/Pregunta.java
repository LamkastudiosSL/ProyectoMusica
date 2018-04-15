package com.studios.lamka.eresloqueescuchas.modelo;
//Created by chillaso All rights reserved.

public class Pregunta {

    private String pregunta;
    private String[] respuestas;

    public Pregunta() {
    }

    public Pregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Pregunta(String pregunta, String[] respuestas) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String[] respuestas) {
        this.respuestas = respuestas;
    }
}
