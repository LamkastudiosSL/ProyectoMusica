package com.studios.lamka.eresloqueescuchas.controlador;

import com.google.gson.Gson;
import com.studios.lamka.eresloqueescuchas.Modelos.ObjetoPruebaPregunta;

import java.util.ArrayList;
import java.util.Arrays;

public class GestionBaseDatos {

    //Esta clase va a ser un Singleton, sólo  va a tener un objeto GSON
    private static Gson gson;
    private static GestionBaseDatos gestion;

    private GestionBaseDatos(){
        gestion=new GestionBaseDatos();
        gson=new Gson();
    }

    public static GestionBaseDatos getInstance(){
        //un ejemplo de un if else con ternary (solo se maneja un dato, en este caso el dato que se devuelve)
        return (gestion==null) ? new GestionBaseDatos() : gestion;
    }

    public ArrayList<ObjetoPruebaPregunta> GetAllPreguntas(){
        ObjetoPruebaPregunta[] preguntas;
        preguntas=gson.fromJson(GetPreguntasJson(),ObjetoPruebaPregunta[].class);
        ArrayList<ObjetoPruebaPregunta> a= (ArrayList<ObjetoPruebaPregunta>) Arrays.asList(preguntas);
        return a;
    }


    private String GetPreguntasJson(){
        //LLamada a la base de datos que delvuelve un JSON
        return "";
    }
}
