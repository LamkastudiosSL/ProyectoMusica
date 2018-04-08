package com.studios.lamka.eresloqueescuchas.Ventanas.PaginasEncuesta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.studios.lamka.eresloqueescuchas.R;
import com.studios.lamka.eresloqueescuchas.Ventanas.Principal;
import com.studios.lamka.eresloqueescuchas.controlador.GestionEncuentas;

public class EncuestaPaginaUno extends AppCompatActivity implements View.OnClickListener {

    private Button btnSiguiente,btnAtras;

    //TODOS LOS CAMPOS OBLIGAOTORIOS IRAN AQUI, AL PULSAR O RELLENAR UN CAMPO OBLIGATORIO, SE PONDRA A TRUE, LA POSICION DE LA PREGUNTA
    //SI HAY 4 PREGUNTAS OBLIGATORIAS, EL ARRAY SERA DE 4 ELEMENTOS Y ASI
    private boolean[] camposObligatorios = new boolean[4];
    private EditText nombreyapellidos;
    private EditText ciudad;
    private RadioGroup rgSexo,rgedad;


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
        ciudad = findViewById(R.id.editciudad);
        rgSexo = findViewById(R.id.rgsexo);
        rgedad = findViewById(R.id.rgedad);


        btnSiguiente.setOnClickListener(this);
        btnAtras.setOnClickListener(this);




    }


    @Override
    public void onClick(View v) {

        if (v.equals(btnSiguiente)){

            comprobarPreguntasObigatorias();

            if(!GestionEncuentas.validarFormulario(this,camposObligatorios,new EncuestaPaginaDos().getClass())){
               Toast.makeText(getApplicationContext(),"DEBE DE RELLENAR TODOS LOS CAMPOS OBLIGATORIOS",Toast.LENGTH_SHORT).show();
            } else {
                //Intent i = new Intent(getBaseContext(), EncuestaPaginaUno.class);
                //startActivity(i);
            }
        }
        if(v.equals(btnAtras)){
            Intent i = new Intent(getBaseContext(), Principal.class);
            startActivity(i);
        }
    }

    public void comprobarPreguntasObigatorias(){
        if(!GestionEncuentas.comprobarEditVacio(nombreyapellidos)) camposObligatorios[0]=true;
        else camposObligatorios[0]=false;

        if (!GestionEncuentas.comprobarRadiosVacios(rgedad)) camposObligatorios[1]=true;
        else camposObligatorios[1] = false;

        if(!GestionEncuentas.comprobarEditVacio(ciudad)) camposObligatorios[2]=true;
        else camposObligatorios[2]=false;

        if (!GestionEncuentas.comprobarRadiosVacios(rgSexo)) camposObligatorios[3]=true;
        else camposObligatorios[3] = false;

    }


}
