package com.studios.lamka.eresloqueescuchas.vista.PaginasEncuesta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.studios.lamka.eresloqueescuchas.R;
import com.studios.lamka.eresloqueescuchas.controlador.GestionEncuentas;

public class PaginaFinal extends AppCompatActivity implements View.OnClickListener {

    private EditText telefono,usuario,email;
    private Button btnEnviar;
    private WebView webView;
    private boolean[] camposObligatorios = new boolean[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_final);

        btnEnviar = findViewById(R.id.btnenviar);
        telefono = findViewById(R.id.edittelefono);
        email = findViewById(R.id.editemail);
        usuario = findViewById(R.id.editusuario);

        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("https://www.youtube.com/watch?v=byhnCQTebis");

        btnEnviar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnEnviar)){

            comprobarPreguntasObigatorias();

            if(!GestionEncuentas.validarFormulario(camposObligatorios)) {
                Toast.makeText(getApplicationContext(), "Debe indicar su nombre de usuario", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getApplicationContext(),"Encuesta enviada!!",Toast.LENGTH_SHORT).show();

            }
        }
    }

    public void comprobarPreguntasObigatorias(){
        camposObligatorios[0] =(!GestionEncuentas.comprobarEditVacio(usuario))?true:false;

    }
}
