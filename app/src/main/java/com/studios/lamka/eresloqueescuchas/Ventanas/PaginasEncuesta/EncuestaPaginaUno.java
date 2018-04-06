package com.studios.lamka.eresloqueescuchas.Ventanas.PaginasEncuesta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.studios.lamka.eresloqueescuchas.R;
import com.studios.lamka.eresloqueescuchas.controlador.GestionEncuentas;

public class EncuestaPaginaUno extends AppCompatActivity implements View.OnClickListener {

    private Button btnSiguiente,btnAtras;

    //TODOS LOS CAMPOS OBLIGAOTORIOS IRAN AQUI, AL PULSAR O RELLENAR UN CAMPO OBLIGATORIO, SE PONDRA A TRUE, LA POSICION DE LA PREGUNTA
    private boolean[] camposObligatorios={false};
    private EditText nombreyapellidos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paginauno);

        //AL PULSAR UN EDDITEXT TE ARREGLA EL FALLO QUE SE TE MUEVE EL LAYOUT
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        btnSiguiente = findViewById(R.id.btnsiguiente);
        btnAtras = findViewById(R.id.btnpaginanaterior);

        //COMPONENTES
        nombreyapellidos = findViewById(R.id.editNombre);


        btnSiguiente.setOnClickListener(this);
        btnAtras.setOnClickListener(this);




    }


    @Override
    public void onClick(View v) {

        if (v.equals(btnSiguiente)){

            if(nombreyapellidos.getText().length()!=0) camposObligatorios[0]=true;

            if(!GestionEncuentas.validarFormulario(this,camposObligatorios,new EncuestaPaginaDos().getClass()))
                Toast.makeText(getApplicationContext(),"DEBE DE RELLENAR TODOS LOS CAMPOPS OBLIGATORIOS"+camposObligatorios[0],Toast.LENGTH_SHORT).show();
        }
        if(v.equals(btnAtras)){

        }

    }
}
