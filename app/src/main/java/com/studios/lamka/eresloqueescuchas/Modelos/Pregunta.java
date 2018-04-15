package com.studios.lamka.eresloqueescuchas.Modelos;
//Created by chillaso All rights reserved.

public class Pregunta {

    private int idpregunta;
    private String descripcion;
    private float peso;

    public Pregunta() {
    }

    public Pregunta(int idpregunta, String descripcion, float peso) {
        this.idpregunta = idpregunta;
        this.descripcion = descripcion;
        this.peso = peso;
    }

    public int getIdpregunta() {
        return idpregunta;
    }

    public void setIdpregunta(int idpregunta) {
        this.idpregunta = idpregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
