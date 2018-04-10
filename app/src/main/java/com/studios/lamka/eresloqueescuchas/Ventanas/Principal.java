package com.studios.lamka.eresloqueescuchas.Ventanas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.studios.lamka.eresloqueescuchas.R;
import com.studios.lamka.eresloqueescuchas.Ventanas.PaginasEncuesta.EncuestaPaginaUno;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    private ImageView encuesta;
    private ImageView acerca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encuesta = findViewById(R.id.btnencuesta);
        acerca = findViewById(R.id.btnacerca);

        encuesta.setOnClickListener(this);
        acerca.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {
        if(v.equals(encuesta)) startActivity(new Intent(Principal.this,EncuestaPaginaUno.class));
        else startActivity(new Intent(Principal.this,Acercade.class));
    }
}
