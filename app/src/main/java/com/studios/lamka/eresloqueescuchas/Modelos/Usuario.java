package com.studios.lamka.eresloqueescuchas.Modelos;
//Created by chillaso All rights reserved.

public class Usuario {

    private int idusuario;
    private String nombre,edad,ciudad,sexo,clase;

    public Usuario() {
    }

    public Usuario(int idusuario, String nombre, String edad, String ciudad, String sexo, String clase) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
        this.sexo = sexo;
        this.clase = clase;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
}
