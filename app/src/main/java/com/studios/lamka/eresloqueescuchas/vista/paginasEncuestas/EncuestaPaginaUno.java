package com.studios.lamka.eresloqueescuchas.vista.paginasEncuestas;

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
import com.studios.lamka.eresloqueescuchas.controlador.GestionEncuentas;
import com.studios.lamka.eresloqueescuchas.util.MUtil;

public class EncuestaPaginaUno extends AppCompatActivity implements View.OnClickListener {

    private Button btnSiguiente;

    //TODOS LOS CAMPOS OBLIGAOTORIOS IRAN AQUI, AL PULSAR O RELLENAR UN CAMPO OBLIGATORIO, SE PONDRA A TRUE, LA POSICION DE LA PREGUNTA
    //SI HAY 4 PREGUNTAS OBLIGATORIAS, EL ARRAY SERA DE 4 ELEMENTOS Y ASI
    private boolean[] camposObligatorios = new boolean[4];
    private EditText nombreyapellidos;
    private EditText ciudad;
    private RadioGroup rgSexo,rgedad,rgclase;
    private GestionEncuentas gestionEncuentas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paginauno);

        //AL PULSAR UN EDDITEXT TE ARREGLA EL FALLO QUE SE TE MUEVE EL LAYOUT
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        btnSiguiente = findViewById(R.id.btnsiguiente);

        //COMPONENTES
        nombreyapellidos = findViewById(R.id.editNombre);
        ciudad = findViewById(R.id.editciudad);
        rgSexo = findViewById(R.id.rgsexo);
        rgedad = findViewById(R.id.rgedad);
        rgclase = findViewById(R.id.rglase);



        btnSiguiente.setOnClickListener(this);




    }


    @Override
    public void onClick(View v) {

        if (v.equals(btnSiguiente)){

            comprobarPreguntasObigatorias();

            if(!GestionEncuentas.validarFormulario(camposObligatorios)){
               Toast.makeText(getApplicationContext(),"DEBE DE RELLENAR TODOS LOS CAMPOPS OBLIGATORIOS",Toast.LENGTH_SHORT).show();
            }else {
                guardarRespuestas();
                startActivity(new Intent(EncuestaPaginaUno.this,EncuestaPaginaDos.class));
            }
        }

    }

    public void comprobarPreguntasObigatorias(){

        camposObligatorios[0] = (!GestionEncuentas.comprobarEditVacio(nombreyapellidos)) ? true : false;
        camposObligatorios[1] = (!GestionEncuentas.comprobarRadiosVacios(rgedad)) ? true : false;
        camposObligatorios[2] = (!GestionEncuentas.comprobarEditVacio(ciudad))  ? true : false;
        camposObligatorios[3] = (!GestionEncuentas.comprobarRadiosVacios(rgSexo)) ? true : false;

    }

    public void guardarRespuestas(){

        GestionEncuentas.getInstance().insertarRespuestasUsuario("Nombre y Apellidos ",nombreyapellidos.getText().toString());
        GestionEncuentas.getInstance().insertarRespuestasUsuario("¿Qué edad tienes? ",GestionEncuentas.getvalueRadioButton(this,rgedad));
        GestionEncuentas.getInstance().insertarRespuestasUsuario("Ciudad en la que vives",ciudad.getText().toString());
        GestionEncuentas.getInstance().insertarRespuestasUsuario("Sexo",GestionEncuentas.getvalueRadioButton(this,rgSexo));
        MUtil.sexo=GestionEncuentas.getvalueRadioButton(this,rgSexo);
        //Comprobamos que nos devuelve algo y no esá vacio
        if(GestionEncuentas.getvalueRadioButton(this,rgclase) != "")
            GestionEncuentas.getInstance().insertarRespuestasUsuario("Clase social a la que crees que perteneces",GestionEncuentas.getvalueRadioButton(this,rgclase));

    }


}
