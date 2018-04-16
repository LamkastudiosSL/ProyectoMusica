package com.studios.lamka.eresloqueescuchas.vista.paginasEncuestas;

import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.studios.lamka.eresloqueescuchas.R;
import com.studios.lamka.eresloqueescuchas.controlador.GestionEncuentas;
import com.studios.lamka.eresloqueescuchas.vista.PantallaCamara;

import java.io.File;

public class EncuestaPaginaCuatro extends AppCompatActivity implements View.OnClickListener{

    private boolean[] camposObligatorios = new boolean[9];
    private EditText deporte,necesario;
    private RadioGroup popular,relacionarte,problemasCasa,peleas,fumas,bebes,policia,beso;
    private Button btnsigui;
    private CheckBox chico1,chico2,chico3,chico4,chica1,chica2,chica3,chica4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta_pagina_cuatro);

        //AL PULSAR UN EDDITEXT TE ARREGLA EL FALLO QUE SE TE MUEVE EL LAYOUT
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);



        deporte = findViewById(R.id.editdeporte);
        popular = findViewById(R.id.rgpopular);
        relacionarte = findViewById(R.id.rgrelacion);
        problemasCasa = findViewById(R.id.rgproblemas);
        peleas = findViewById(R.id.rgpelea);
        fumas = findViewById(R.id.rgfumas);
        bebes = findViewById(R.id.rgbebida);
        policia = findViewById(R.id.rgpolicia);
        beso = findViewById(R.id.rgbeso);

        necesario = findViewById(R.id.editobservacion);

        chico1 = findViewById(R.id.chico1);
        chico2 = findViewById(R.id.chico2);
        chico3 = findViewById(R.id.chico3);
        chico4 = findViewById(R.id.chico4);
        chica1 = findViewById(R.id.chica1);
        chica2 = findViewById(R.id.chica2);
        chica3 = findViewById(R.id.chica3);
        chica4 = findViewById(R.id.chica4);

        btnsigui = findViewById(R.id.btnsiguiente);
        btnsigui.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.equals(btnsigui)){

            new creaCarpeta().execute();

            comprobarPreguntasObigatorias();

            if(!GestionEncuentas.validarFormulario(camposObligatorios)){
                Toast.makeText(getApplicationContext(),"DEBE DE RELLENAR TODOS LOS CAMPOPS OBLIGATORIOS",Toast.LENGTH_SHORT).show();
            }else {
                guardarRespuestas();
                GestionEncuentas.mostrarDialogo(EncuestaPaginaCuatro.this,"A continuación deberá hacerse una foto, ¿Estas de acuerdo?",new PantallaCamara().getClass());
            }
        }
    }

    public void comprobarPreguntasObigatorias(){

        camposObligatorios[0] = (!GestionEncuentas.comprobarRadiosVacios(popular))?true:false;
        camposObligatorios[1] = (!GestionEncuentas.comprobarRadiosVacios(relacionarte))?true:false;
        camposObligatorios[2] = (!GestionEncuentas.comprobarRadiosVacios(problemasCasa))?true:false;
        camposObligatorios[3] = (!GestionEncuentas.comprobarRadiosVacios(peleas))?true:false;
        camposObligatorios[4] = (!GestionEncuentas.comprobarRadiosVacios(fumas))?true:false;
        camposObligatorios[5] = (!GestionEncuentas.comprobarRadiosVacios(bebes))?true:false;
        camposObligatorios[6] = (!GestionEncuentas.comprobarRadiosVacios(policia))?true:false;
        camposObligatorios[7] = (!GestionEncuentas.comprobarEditVacio(deporte))?true:false;
        camposObligatorios[8] = (!GestionEncuentas.comprobarRadiosVacios(beso))?true:false;

    }

    //CREACION DE LA CARPETA DE LA APP
    private class creaCarpeta extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            File folder = new File(Environment.getExternalStorageDirectory(), "¿ELQE?");
            if (!folder.exists()) {
                folder.mkdirs();
            }
            return null;
        }
    }



    public void guardarRespuestas(){

        GestionEncuentas.getInstance().insertarRespuestasUsuario("¿Te consideras una persona popular?",GestionEncuentas.getvalueRadioButton(this,popular));
        GestionEncuentas.getInstance().insertarRespuestasUsuario("¿Te cuesta relacionarte? ",GestionEncuentas.getvalueRadioButton(this,relacionarte));
        GestionEncuentas.getInstance().insertarRespuestasUsuario("¿Tienes problemas en casa?  ",GestionEncuentas.getvalueRadioButton(this,problemasCasa));
        GestionEncuentas.getInstance().insertarRespuestasUsuario("¿Te has peleado de forma violenta con otras personas? ",GestionEncuentas.getvalueRadioButton(this,peleas));
        GestionEncuentas.getInstance().insertarRespuestasUsuario("¿Fumas habitualmente? ",GestionEncuentas.getvalueRadioButton(this,fumas));
        GestionEncuentas.getInstance().insertarRespuestasUsuario("¿Bebes alcohol con frecuencia?   ",GestionEncuentas.getvalueRadioButton(this,bebes));
        GestionEncuentas.getInstance().insertarRespuestasUsuario("¿Has tenido algún encuentro negativo o no deseado con la policia? ",GestionEncuentas.getvalueRadioButton(this,policia));
        GestionEncuentas.getInstance().insertarRespuestasUsuario("¿Practicas algún deporte?  ",deporte.getText().toString());
        GestionEncuentas.getInstance().insertarRespuestasUsuario("SÓLO SI ERES CHICO señala la/s opción/es con la que estés de acuerdo.  ",GestionEncuentas.getValoresCheckboxDados(chico1,chico2,chico3,chico4));
        GestionEncuentas.getInstance().insertarRespuestasUsuario("SÓLO SI ERES CHICA señala la/s opción/es con la que estés de acuerdo. ",GestionEncuentas.getValoresCheckboxDados(chica1,chica2 ,chica3,chica4));
        GestionEncuentas.getInstance().insertarRespuestasUsuario("¿Qué te parece esta foto?  ",GestionEncuentas.getvalueRadioButton(this,beso));
        GestionEncuentas.getInstance().insertarRespuestasUsuario("Si lo ves necesario, añade cualquier cosa que quieras aclarar sobre alguno de los puntos anteriores.  ",necesario.getText().toString());

    }
}
