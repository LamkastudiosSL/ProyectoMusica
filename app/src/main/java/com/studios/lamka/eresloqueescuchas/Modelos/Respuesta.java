package com.studios.lamka.eresloqueescuchas.Modelos;
//Created by chillaso All rights reserved.

public class Respuesta {

    private int idrespuesta;
    private String descripcion;

    public Respuesta() {
    }

    public Respuesta(int idrespuesta, String descripcion) {
        this.idrespuesta = idrespuesta;
        this.descripcion = descripcion;
    }

    public int getIdrespuesta() {
        return idrespuesta;
    }

    public void setIdrespuesta(int idrespuesta) {
        this.idrespuesta = idrespuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
