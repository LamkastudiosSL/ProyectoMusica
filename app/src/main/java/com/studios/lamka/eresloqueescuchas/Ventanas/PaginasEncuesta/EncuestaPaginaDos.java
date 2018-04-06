package com.studios.lamka.eresloqueescuchas.Ventanas.PaginasEncuesta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.studios.lamka.eresloqueescuchas.R;

public class EncuestaPaginaDos extends AppCompatActivity {

    Button btnatras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paginados);

        //AL PULSAR UN EDDITEXT TE ARREGLA EL FALLO QUE SE TE MUEVE EL LAYOUT
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        btnatras = findViewById(R.id.btnatras);

        btnatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EncuestaPaginaDos.this,EncuestaPaginaUno.class));
            }
        });

    }


}
