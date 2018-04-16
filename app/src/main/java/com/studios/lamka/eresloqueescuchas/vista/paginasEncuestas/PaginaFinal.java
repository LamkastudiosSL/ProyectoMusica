package com.studios.lamka.eresloqueescuchas.vista.paginasEncuestas;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Environment;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.studios.lamka.eresloqueescuchas.R;
import com.studios.lamka.eresloqueescuchas.controlador.GestionBaseDatos;
import com.studios.lamka.eresloqueescuchas.controlador.GestionEncuentas;
import com.studios.lamka.eresloqueescuchas.modelo.Encuesta;
import com.studios.lamka.eresloqueescuchas.util.MUtil;
import com.studios.lamka.eresloqueescuchas.vista.Principal;

import org.json.JSONException;

import java.util.ArrayList;

public class PaginaFinal extends AppCompatActivity implements View.OnClickListener {


    private WebView webView;
    private MediaPlayer player;
    private Button btnSiguiente;

    int imagen;
    int musica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_final);

        //Obtener los resources segun las respuestas
        obtenerResources();

        btnSiguiente = findViewById(R.id.btnSiguiente);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        int heightR = (int) (height * 0.3);
        int widthR = (int) (width * 0.3);

        String mPath = Environment.getExternalStorageDirectory().toString() + "/" + "¿ELQE?" + "/" + "temp" + ".jpg";

        Bitmap bitmap = BitmapFactory.decodeFile(mPath);

        BitmapDrawable bitmapDrawable = new BitmapDrawable(getBaseContext().getResources(), bitmap);

        ImageView testimage = findViewById(R.id.testimage);

        Resources r = getResources();
        Drawable[] layers = new Drawable[2];
        layers[0] = bitmapDrawable;

        // IMAGEN
        layers[1] = r.getDrawable(imagen);
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        layerDrawable.setLayerInset(0, (int) (width * 0.215), (int) -(height * 0.03), (int) (width * 0.32), (int) (height * 0.95));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            layerDrawable.setLayerSize(0, (int) (width * 1), (int) (height * 0.7));
        }
        layerDrawable.setLayerInset(1, 0, 0, 0, 0);
        testimage.setImageDrawable(layerDrawable);

        //MUSICA
        player = MediaPlayer.create(this, musica);
        player.setLooping(true); // Set looping
        player.setVolume(100, 100);
        player.start();


    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        startActivity(new Intent(getApplicationContext(), Principal.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.stop();

    }


    private void obtenerResources() {
        String sexo = MUtil.sexo.toLowerCase();
        String estilo = MUtil.estilo.toLowerCase();

        switch (estilo) {
            case "clásica":
                if (sexo.equals("hombre"))
                    imagen = R.mipmap.clasica;
                else
                    imagen = R.mipmap.clasicam;
                musica = R.raw.clasica;
                break;
            case "electrónica":
                imagen = R.mipmap.electronica;
                musica = R.raw.electronica;
                break;
            case "folk":
                imagen = R.mipmap.folk;
                musica = R.raw.folk;
                break;
            case "funk":
                if (sexo.equals("hombre"))
                    imagen = R.mipmap.funky;
                else
                    imagen = R.mipmap.funkym;
                musica = R.raw.funky;
                break;
            case "flamenco":
                imagen = R.mipmap.flamenco;
                musica = R.raw.flamenco;
                break;
            case "flamenquito (flamenco mezclado)":
                imagen = R.mipmap.flamenquito;
                musica = R.raw.flamenquito;
                break;
            case "heavy":
                imagen = R.mipmap.heavy;
                musica = R.raw.heavy;
                break;
            case "jazz":
                imagen = R.mipmap.jazz;
                musica = R.raw.jazz;
                break;
            case "músicas del mundo":
                imagen = R.mipmap.musicamundo;
                musica = R.raw.musicamundo;
                break;
            case "pop":
                if (sexo.equals("hombre"))
                    imagen = R.mipmap.pop;
                else
                    imagen = R.mipmap.popm;
                musica = R.raw.pop;
                break;
            case "punk":
                imagen = R.mipmap.punk;
                musica = R.raw.punk;
                break;
            case "rap":
                imagen = R.mipmap.rap;
                musica = R.raw.rap;
                break;
            case "reggae":
                imagen = R.mipmap.reggae;
                musica = R.raw.reggae;
                break;
            case "reggaeton":
                if (sexo.equals("hombre"))
                    imagen = R.mipmap.reggaeton;
                else
                    imagen = R.mipmap.reggaetonm;
                musica = R.raw.reggaeton;
                break;
            case "rock":
                imagen = R.mipmap.rock;
                musica = R.raw.rock;
                break;
            case "soul":
                imagen = R.mipmap.soul;
                musica = R.raw.soul;
                break;
            case "trap":
                if (sexo.equals("hombre"))
                    imagen = R.mipmap.trap;
                else
                    imagen = R.mipmap.trapm;
                musica = R.raw.trap;
                break;
        }
    }

    @Override
    public void onClick(View v) {


            /*comprobarPreguntasObigatorias();

            if(!GestionEncuentas.validarFormulario(camposObligatorios)) {
                Toast.makeText(getApplicationContext(), "Debe indicar su nombre de usuario", Toast.LENGTH_SHORT).show();
            }
            else
            {*/
            ArrayList<Encuesta> encuestas = GestionEncuentas.getRespuestas();
            try {
                GestionBaseDatos.getInstance(getApplicationContext()).insertarEncuesta(encuestas);
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(this, "Error al enviar la encuesta", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(getApplicationContext(), "¡¡Encuesta enviada!!", Toast.LENGTH_SHORT).show();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent i = new Intent(getBaseContext(), Principal.class);
            startActivity(i);
            finish();

            //}

    }

}
