package com.studios.lamka.eresloqueescuchas.controlador;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.studios.lamka.eresloqueescuchas.R;
import com.studios.lamka.eresloqueescuchas.Ventanas.PaginasEncuesta.PaginaDos;

public class GestionEncuentas {

    private static boolean puedeCambiarActivity=true;

    public static boolean validarFormulario(Context context,boolean[] camposObligatorios, Class nuevaActividad){

        //VALIDAMOS EN EL FORMULARIO SI TODOS LOS CAMPOS OBLIGATORIOS ESTAN PUESTOS,
        // PONEMOS UNA VARIABLE GLOBAL, COMO CAMPOS OBLIGATORIOS A TRUE
        //observa encuesta 1 para entenderlo mejor

        for (boolean campo: camposObligatorios){
            if(!campo)
                puedeCambiarActivity = false;
        }

        if(puedeCambiarActivity){
            Intent intent = new Intent(context,nuevaActividad);
            context.startActivity(intent);
        }
        return puedeCambiarActivity;

    }

}
