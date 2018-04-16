package com.studios.lamka.eresloqueescuchas.controlador;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.studios.lamka.eresloqueescuchas.modelo.Encuesta;
import com.studios.lamka.eresloqueescuchas.vista.PantallaCamara;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GestionEncuentas {

    private static boolean puedeCambiarActivity=true;
    private static GestionEncuentas gestionEncuentas;
    private static ArrayList<Encuesta> respuestas;

    public GestionEncuentas(){
        respuestas = new ArrayList<>();
    }


    public static GestionEncuentas getInstance(){
        //un ejemplo de un if else con ternary (solo se maneja un dato, en este caso el dato que se devuelve)
        return (gestionEncuentas==null) ? gestionEncuentas = new GestionEncuentas() : gestionEncuentas;
    }


    public static boolean validarFormulario(boolean[] camposObligatorios){

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
                /*Intent intent = new Intent(context,nuevaActividad);
                context.startActivity(intent);*/
                Intent intent = new Intent(context,nuevaActividad);
                context.startActivity(intent);

                dialog.cancel();
            }
        });

        builder.show();

    }


    public static String getvalueRadioButton(Activity activity,RadioGroup radioGroup){
        int select = radioGroup.getCheckedRadioButtonId();
        //Comprobamos que tenemos algun ID
        if(select > 0)
        {
            RadioButton rb = activity.findViewById(select);
            return rb.getText().toString();
        }
        else
            return "";
    }

    public static String getValorSpinner(Spinner spinner){
        return spinner.getSelectedItem().toString();
    }

    public static String getValoresCheckboxDados(CheckBox ... checkBoxes){


        String valores="";
        for (CheckBox checkBox: checkBoxes){

            if(checkBox.isChecked())
                valores+= checkBox.getText().toString()+"    --    ";
        }

        return valores;
    }

    public void insertarRespuestasUsuario(String pregunta,String respuesta){


        respuestas.add(new Encuesta(pregunta,respuesta));

    }

    public static ArrayList<Encuesta> getRespuestas(){
        return respuestas;
    }


}
