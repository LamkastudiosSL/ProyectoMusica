package com.studios.lamka.eresloqueescuchas.Ventanas;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.studios.lamka.eresloqueescuchas.R;
import com.studios.lamka.eresloqueescuchas.Ventanas.PaginasEncuesta.EncuestaPaginaUno;
import com.studios.lamka.eresloqueescuchas.controlador.GestionBaseDatos;
import com.studios.lamka.eresloqueescuchas.modelo.Pregunta;

public class Principal extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback{

    private ImageView encuesta;
    private ImageView acerca;
    private static final int CODE_CAMARA = 1;
    private static final int CODE_ALMACENAMIENTO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        PRUEBA DE GESTION BASE DE DATOS
         */

        GestionBaseDatos db = GestionBaseDatos.getInstance();
        db.fetch("preguntas",Pregunta.class);

        encuesta = findViewById(R.id.btnencuesta);
        acerca = findViewById(R.id.btnacerca);

        encuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Principal.this,EncuestaPaginaUno.class));
            }
        });
        acerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Principal.this,Acercade.class));
            }
        });



        //Pedida de permisos para camara para api superior a 23
        if (Build.VERSION.SDK_INT >= 23) {
            String[] PERMISSIONS = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
            if (!hasPermissions(getBaseContext(), PERMISSIONS)) {
                ActivityCompat.requestPermissions(this, PERMISSIONS, CODE_CAMARA);
            }
        }


    }

    //Metodo que se implementa con la interface que estamos implementando
    //PROBLEMA, ESTO ES UNA CLASE JAVA NO UNA ACTIVITY ASIQUE NO SE EJECUTA EL CALL()
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case CODE_CAMARA: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toast.makeText(getBaseContext(), "Debes conceder los permisos para que la app funcione correctamente", Toast.LENGTH_LONG).show();
                }
            }
            case CODE_ALMACENAMIENTO: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toast.makeText(getBaseContext(), "Debes conceder los permisos para que la app funcione correctamente", Toast.LENGTH_LONG).show();
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

    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }
}
