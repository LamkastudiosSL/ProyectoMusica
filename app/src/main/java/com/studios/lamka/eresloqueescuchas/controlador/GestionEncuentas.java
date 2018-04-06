package com.studios.lamka.eresloqueescuchas.controlador;

import android.content.Context;
import android.content.Intent;

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
