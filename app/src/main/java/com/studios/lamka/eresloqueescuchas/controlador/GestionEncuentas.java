package com.studios.lamka.eresloqueescuchas.controlador;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

public class GestionEncuentas {

    private static boolean puedeCambiarActivity=true;

    public static boolean validarFormulario(Context context,boolean[] camposObligatorios, Class nuevaActividad){

        //VALIDAMOS EN EL FORMULARIO SI TODOS LOS CAMPOS OBLIGATORIOS ESTAN PUESTOS,
        // PONEMOS UNA VARIABLE GLOBAL, COMO CAMPOS OBLIGATORIOS A TRUE
        //observa encuesta 1 para entenderlo mejor

        for (boolean campo: camposObligatorios){
            if(!campo) {
                puedeCambiarActivity = false;
                break;
            }
        }

        if(puedeCambiarActivity){
            Intent intent = new Intent(context,nuevaActividad);
            context.startActivity(intent);
        }

        return puedeCambiarActivity;
    }

    public static boolean comprobarEditVacio(EditText editText){
        if (editText.getText().toString().matches("")) return true;
        return false;
    }




}
