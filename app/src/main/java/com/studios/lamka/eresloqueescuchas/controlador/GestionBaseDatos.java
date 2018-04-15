package com.studios.lamka.eresloqueescuchas.controlador;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.studios.lamka.eresloqueescuchas.modelo.Pregunta;
import com.studios.lamka.eresloqueescuchas.service.VolleyApplication;
import com.studios.lamka.eresloqueescuchas.util.MUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GestionBaseDatos {

    //Esta clase va a ser un Singleton, sólo  va a tener un objeto GSON
    private static Gson gson;
    private static GestionBaseDatos gestion;
    private static RequestQueue requestQueue;


    private GestionBaseDatos(Context context){
        gson=new Gson();
        requestQueue= Volley.newRequestQueue(context);
    }

    public static GestionBaseDatos getInstance(Context context){
        //un ejemplo de un if else con ternary (solo se maneja un dato, en este caso el dato que se devuelve)

        return (gestion==null) ? gestion=new GestionBaseDatos(context) : gestion;
    }

    public void fetch(String consulta)
    {
       JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,MUtil.WEB_URL + consulta,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response)
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
        requestQueue.add(request);

    }

    public List<Pregunta> GetAllPreguntas(JSONArray response)
    {
        Log.i("Debug getallpreguntas","dentro");
        Pregunta[] preguntas;

        preguntas=gson.fromJson(response.toString(),Pregunta[].class);

        //ArrayList<Pregunta> a= (ArrayList<Pregunta>) Arrays.asList(preguntas);

        for (Pregunta p: preguntas)
        {
            Log.i("Debug pregunta",p.getDescripcion());
        }
        List<Pregunta> a = Arrays.asList(preguntas);
        return a;
    }


}
