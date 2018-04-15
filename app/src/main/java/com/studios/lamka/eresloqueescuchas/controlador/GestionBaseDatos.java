package com.studios.lamka.eresloqueescuchas.controlador;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.studios.lamka.eresloqueescuchas.modelo.Pregunta;
import com.studios.lamka.eresloqueescuchas.service.VolleyApplication;
import com.studios.lamka.eresloqueescuchas.util.MUtil;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class GestionBaseDatos {

    //Esta clase va a ser un Singleton, sólo  va a tener un objeto GSON
    private static Gson gson;
    private static GestionBaseDatos gestion;

    private GestionBaseDatos(){
        gson=new Gson();
    }

    public static GestionBaseDatos getInstance(){
        //un ejemplo de un if else con ternary (solo se maneja un dato, en este caso el dato que se devuelve)
        return (gestion==null) ? gestion=new GestionBaseDatos() : gestion;
    }

    public void fetch(String consulta, final Class clase)
    {
        JsonObjectRequest request = new JsonObjectRequest(
                MUtil.WEB_URL + consulta,
                null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        Log.i("Success","Se ha conectado");
                        GetAllPreguntas(response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Log.e("Error de conexion",error.toString());
                    }
                }
        );

        VolleyApplication.getInstance().getRequestQueue().add(request);
    }

    public ArrayList<Pregunta> GetAllPreguntas(JSONObject response)
    {
        Log.i("Debug getallpreguntas","dentro");
        Pregunta[] preguntas;

        //preguntas=gson.fromJson(response.getJSONArray("0"),Pregunta[].class);

        ArrayList<Pregunta> a= (ArrayList<Pregunta>) Arrays.asList(preguntas);

        for (Pregunta p: a)
        {
            Log.i("Debug pregunta",p.getDescripcion());
        }

        return a;
    }


    private String GetPreguntasJson(){
        //LLamada a la base de datos que delvuelve un JSON
        return "";
    }
}
