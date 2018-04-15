package com.studios.lamka.eresloqueescuchas.modelo;
//Created by chillaso All rights reserved.

public class Encuesta {

    private int idusuario, idpregunta;
    private String respuesta;

    public Encuesta() {
    }

    public Encuesta(int idusuario, int idpregunta, String respuesta) {
        this.idusuario = idusuario;
        this.idpregunta = idpregunta;
        this.respuesta = respuesta;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdpregunta() {
        return idpregunta;
    }

    public void setIdpregunta(int idpregunta) {
        this.idpregunta = idpregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
