package com.studios.lamka.eresloqueescuchas.vista.paginasEncuestas;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.studios.lamka.eresloqueescuchas.R;
import com.studios.lamka.eresloqueescuchas.controlador.GestionEncuentas;

public class PaginaFinal extends AppCompatActivity implements View.OnClickListener {

    private EditText telefono,usuario,email;
    private Button btnEnviar;
    private WebView webView;
    private ConstraintLayout cl;
    private MediaPlayer player;
    private boolean[] camposObligatorios = new boolean[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_final);

        btnEnviar = findViewById(R.id.btnenviar);
        telefono = findViewById(R.id.edittelefono);
        email = findViewById(R.id.editemail);
        usuario = findViewById(R.id.editusuario);

        btnEnviar.setOnClickListener(this);
        cl = findViewById(R.id.cl);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        int heightR = (int) (height * 0.3);
        int widthR = (int) (width * 0.3);

        String mPath = Environment.getExternalStorageDirectory().toString() + "/" + "¿ELQE?" + "/" + "temp" + ".jpg";

        Bitmap bitmap = BitmapFactory.decodeFile(mPath);

        BitmapDrawable bitmapDrawable = new BitmapDrawable(getBaseContext().getResources(), bitmap);

        //BitmapDrawable bitmapDrawableR = (BitmapDrawable) resize(bitmapDrawable);

        ImageView testimage = findViewById(R.id.testimage);


        Resources r = getResources();
        Drawable[] layers = new Drawable[2];
        layers[0] = bitmapDrawable;
        //Esta es la imagen que va a ir variando segun lo que elija
        layers[1] = r.getDrawable(R.mipmap.rock);
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        layerDrawable.setLayerInset(0, (int) (width * 0.215), (int) -(height * 0.03), (int) (width * 0.32), (int) (height * 0.95));
        layerDrawable.setLayerSize(0, (int) (width * 1), (int) (height * 0.7));
        layerDrawable.setLayerInset(1, 0, 0, 0, 0);
        testimage.setImageDrawable(layerDrawable);

        //Esta es la cancion que va a ir variando segun lo que elija
        player = MediaPlayer.create(this, R.raw.rock);
        player.setLooping(true); // Set looping
        player.setVolume(100, 100);
        player.start();

/*
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                player.stop();
                Intent i = new Intent(getBaseContext(), Principal.class);
                startActivity(i);
                finish();
            }

        }, 25000);
        */
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.stop();

    }

    /*private Drawable resize(Drawable image) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 50, 50, false);
        return new BitmapDrawable(getResources(), bitmapResized);
    }*/

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
