package com.studios.lamka.eresloqueescuchas.controlador;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class GestionEncuentas {

    private static boolean puedeCambiarActivity=true;

    public static boolean validarFormulario(Context context,boolean[] camposObligatorios, Class nuevaActividad,String ultimaPagina){

        //VALIDAMOS EN EL FORMULARIO SI TODOS LOS CAMPOS OBLIGATORIOS ESTAN PUESTOS,
        // PONEMOS UNA VARIABLE GLOBAL, COMO CAMPOS OBLIGATORIOS A TRUE
        //observa encuesta 1 para entenderlo mejor

        for (boolean campo: camposObligatorios){
            if(!campo) {
                return false;
            }
        }

        //LA CADENA DE ULTIMA PAGINA VERA SI ES A ULTIMA PGINA DE LA ENCUESTA, PARA PASAR A UNA ACTIVIDAD NUEVA O ABRIR EL DIALOGO
        //PARA ACABAR LA ENCUESTA

        if (!ultimaPagina.equals("si")) {
            Intent intent = new Intent(context, nuevaActividad);
            context.startActivity(intent);
        }


        return true;
    }

    public static boolean comprobarEditVacio(EditText editText){
        if (editText.getText().toString().matches("")) return true;
        return false;
    }

    public static boolean comprobarRadiosVacios(RadioGroup radioGroup){

        if (radioGroup.getCheckedRadioButtonId()==-1){
            return true;
        }

        return false;

    }

    public static boolean comprobarCBVacios(CheckBox[] cBoxes){

        for (CheckBox c : cBoxes){
            if(c.isChecked())
                return false;
        }

        return true;
    }

    public static boolean comprobarSpinnerVacio(Spinner spinner){

        if(spinner.getSelectedItemPosition() == 0){
            return true;
        }

        return false;
    }

    public static void mostrarDialogo(final Context context,String mensajeInformacion,final Class nuevaActividad){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage(mensajeInformacion)
        .setTitle("Información")
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(context,nuevaActividad);
                context.startActivity(intent);
                dialog.cancel();
            }
        });

        builder.show();



    }



}
