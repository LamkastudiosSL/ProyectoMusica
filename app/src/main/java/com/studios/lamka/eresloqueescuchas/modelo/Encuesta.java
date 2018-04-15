package com.studios.lamka.eresloqueescuchas.modelo;
//Created by chillaso All rights reserved.

public class Encuesta {

    private String pregunta,respuesta;

    public Encuesta(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta=respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
