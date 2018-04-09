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

public class EncuentaPaginaCuatro extends AppCompatActivity implements View.OnClickListener{

    private boolean[] camposObligatorios = new boolean[9];
    private EditText deporte;
    private RadioGroup popular,relacionarte,problemasCasa,peleas,fumas,bebes,policia,beso;
    private Button btnsigui;



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

        btnsigui = findViewById(R.id.btnsiguiente);
        btnsigui.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.equals(btnsigui)){

            comprobarPreguntasObigatorias();

            if(!GestionEncuentas.validarFormulario(this,camposObligatorios,new EncuestaPaginaDos().getClass(),"si")){
                Toast.makeText(getApplicationContext(),"DEBE DE RELLENAR TODOS LOS CAMPOPS OBLIGATORIOS",Toast.LENGTH_SHORT).show();
            }else GestionEncuentas.mostrarDialogo(EncuentaPaginaCuatro.this,"A continuación necesitara hacerse una foto a su cara, ¿Estas de acuerdo?",new PaginaFinal().getClass());
        }
    }

    public void comprobarPreguntasObigatorias(){

        if (!GestionEncuentas.comprobarRadiosVacios(popular)) camposObligatorios[0]=true;
        else camposObligatorios[0] = false;
        if (!GestionEncuentas.comprobarRadiosVacios(relacionarte)) camposObligatorios[1]=true;
        else camposObligatorios[1] = false;
        if (!GestionEncuentas.comprobarRadiosVacios(problemasCasa)) camposObligatorios[2]=true;
        else camposObligatorios[2] = false;
        if (!GestionEncuentas.comprobarRadiosVacios(peleas)) camposObligatorios[3]=true;
        else camposObligatorios[3] = false;
        if (!GestionEncuentas.comprobarRadiosVacios(fumas)) camposObligatorios[4]=true;
        else camposObligatorios[4] = false;
        if (!GestionEncuentas.comprobarRadiosVacios(bebes)) camposObligatorios[5]=true;
        else camposObligatorios[5] = false;
        if (!GestionEncuentas.comprobarRadiosVacios(policia)) camposObligatorios[6]=true;
        else camposObligatorios[6] = false;
        if(!GestionEncuentas.comprobarEditVacio(deporte)) camposObligatorios[7]=true;
        else camposObligatorios[7]=false;
        if (!GestionEncuentas.comprobarRadiosVacios(beso)) camposObligatorios[8]=true;
        else camposObligatorios[8] = false;

    }
}
