package com.studios.lamka.eresloqueescuchas.controlador;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class GestionEncuentas implements ActivityCompat.OnRequestPermissionsResultCallback{

    private static boolean puedeCambiarActivity=true;
    private static Context mContext;
    private static final int REQUEST = 1;

    public GestionEncuentas(Context context){
        this.mContext = context;
    }

    public static boolean validarFormulario(Context context, boolean[] camposObligatorios, Class nuevaActividad,String ultimaPagina){

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

        if (ultimaPagina==null) {
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
                /*Intent intent = new Intent(context,nuevaActividad);
                context.startActivity(intent);*/

                if (Build.VERSION.SDK_INT >= 23) {
                    String[] PERMISSIONS = {Manifest.permission.CAMERA};
                    if (!hasPermissions(mContext, PERMISSIONS)) {
                        ActivityCompat.requestPermissions((Activity) mContext, PERMISSIONS, REQUEST);
                    } else if(hasPermissions(mContext, PERMISSIONS)) {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        mContext.startActivity(intent);
                    }
                }

                dialog.cancel();
            }
        });

        builder.show();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    mContext.startActivity(intent);
                } else {
                    Toast.makeText(mContext, "Debes conceder los permisos para que la app funcione correctamente", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    //Comprueba si ya hay permisos api >=23
    private static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

}
