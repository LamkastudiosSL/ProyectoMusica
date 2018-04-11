package com.studios.lamka.eresloqueescuchas.Ventanas.PaginasEncuesta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.studios.lamka.eresloqueescuchas.R;
import com.studios.lamka.eresloqueescuchas.controlador.GestionEncuentas;

public class EncuestaPaginaCuatro extends AppCompatActivity implements View.OnClickListener{

    private boolean[] camposObligatorios = new boolean[9];
    private EditText deporte;
    private RadioGroup popular,relacionarte,problemasCasa,peleas,fumas,bebes,policia,beso;
    private Button btnsigui;
    private GestionEncuentas ge;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta_pagina_cuatro);

        //AL PULSAR UN EDDITEXT TE ARREGLA EL FALLO QUE SE TE MUEVE EL LAYOUT
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        ge = new GestionEncuentas(this);


        deporte = findViewById(R.id.editdeporte);
        popular = findViewById(R.id.rgpopular);
        relacionarte = findViewById(R.id.rgrelacion);
        problemasCasa = findViewById(R.id.rgproblemas);
        peleas = findViewById(R.id.rgpelea);
        fumas = findViewById(R.id.rgfumas);
        bebes = findViewById(R.id.rgbebida);
        policia = findViewById(R.id.rgpolicia);
        beso = findViewById(R.id.rgbeso);

        btnsigui = findViewById(R.id.btnsiguiente);
        btnsigui.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.equals(btnsigui)){

            comprobarPreguntasObigatorias();

            if(!ge.validarFormulario(this,camposObligatorios,null,true)){
                Toast.makeText(getApplicationContext(),"DEBE DE RELLENAR TODOS LOS CAMPOPS OBLIGATORIOS",Toast.LENGTH_SHORT).show();
            }else GestionEncuentas.mostrarDialogo(EncuestaPaginaCuatro.this,"A continuación necesitará hacerse una foto de su cara, ¿Estas de acuerdo?",new PaginaFinal().getClass());
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
}
