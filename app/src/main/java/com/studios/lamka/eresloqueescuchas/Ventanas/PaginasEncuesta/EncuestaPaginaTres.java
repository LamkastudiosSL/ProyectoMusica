package com.studios.lamka.eresloqueescuchas.Ventanas.PaginasEncuesta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.studios.lamka.eresloqueescuchas.Modelos.ObjetoPruebaPregunta;
import com.studios.lamka.eresloqueescuchas.R;
import com.studios.lamka.eresloqueescuchas.controlador.GestionEncuentas;

public class EncuestaPaginaTres extends AppCompatActivity implements View.OnClickListener{

    private Button btnSiguiente, btnAtras;
    private boolean[] camposObligatorios = new boolean[5];
    private TextView txtPreguntaUno, txtPreguntaDos, txtPreguntaTres, txtPreguntaCuatro, txtPreguntaCinco, txtPreguntaSeis;
    private RadioGroup rgEstudios, rgBEstudios, rgAsignaturas, rgCursoR;
    private RadioButton rb, rb2, rb3, rb4, rb5, rb6, rb7, rbB, rb2B, rb3B, rbA, rb1A, rb2A, rb3A, rb4A, rb5A, rb6A, rb7A, rb8A, rb9A, rbC, rb2C;
    private CheckBox cB, cB2, cB3, cB4;
    private ObjetoPruebaPregunta preguntaUno, preguntaDos, preguntaTres, preguntaCuatro, preguntaCinco, preguntaSeis;
    private EditText etRespuestaSeis;
    private String[] opcionesRespuestaUno = {"Primaria" ,
            "ESO" ,
            "FPB" ,
            "Bachillerato" ,
            "Universidad" ,
            "Ciclo Formativo" ,
            "Otros (escribe en el punto 6 cuál)"};
    private String[] opcionesRespuestaDos = {"Sí",
            "Regular",
            "No"};
    private String[] opcionesRespuestaTres = {"0" ,
            "1" ,
            "2" ,
            "3" ,
            "4" ,
            "5" ,
            "6" ,
            "7" ,
            "8" ,
            "9"};
    private String[] opcionesRespuestaCuatro = {"Sí", "No"};
    private String[] opcionesRespuestaCinco = {"Banda o grupo de música",
        "Sólo en el colegio y el instituto",
        "Conservatorio",
        "Escuela de música"};
    private CheckBox[] cBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta_pagina_tres);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        btnSiguiente = findViewById(R.id.btnsiguiente);
        btnSiguiente.setOnClickListener(this);
        //Declaracion de preguntas
        txtPreguntaUno = findViewById(R.id.txtPreguntaUno);
        txtPreguntaDos = findViewById(R.id.txtPreguntaDos);
        txtPreguntaTres = findViewById(R.id.txtPreguntaTres);
        txtPreguntaCuatro = findViewById(R.id.txtPreguntaCuatro);
        txtPreguntaCinco = findViewById(R.id.txtPreguntaCinco);
        txtPreguntaSeis = findViewById(R.id.txtPreguntaSeis);
        //Declaracion de respuestas
        rgEstudios = findViewById(R.id.rgEstudios);
        rb = findViewById(R.id.rb);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);
        rb6 = findViewById(R.id.rb6);
        rb7 = findViewById(R.id.rb7);
        rbB = findViewById(R.id.rbB);
        rgBEstudios = findViewById(R.id.rgBienEstudios);
        rb2B = findViewById(R.id.rb2B);
        rb3B = findViewById(R.id.rb3B);
        rgAsignaturas = findViewById(R.id.rgAsignaturas);
        rbA = findViewById(R.id.rbA);
        rb1A = findViewById(R.id.rb1A);
        rb2A = findViewById(R.id.rb2A);
        rb3A = findViewById(R.id.rb3A);
        rb4A = findViewById(R.id.rb4A);
        rb5A = findViewById(R.id.rb5A);
        rb6A = findViewById(R.id.rb6A);
        rb7A = findViewById(R.id.rb7A);
        rb8A = findViewById(R.id.rb8A);
        rb9A = findViewById(R.id.rb9A);
        rgCursoR = findViewById(R.id.rgCursoRep);
        rbC = findViewById(R.id.rbC);
        rb2C = findViewById(R.id.rb2C);
        cB = findViewById(R.id.cB);
        cB2 = findViewById(R.id.cB2);
        cB3 = findViewById(R.id.cB3);
        cB4 = findViewById(R.id.cB4);
        etRespuestaSeis = findViewById(R.id.etRespuestaSeis);

        cBoxes = new CheckBox[]{cB, cB2, cB3, cB4};


        //METODO QUE RELLENA LAS PREGUNTAS
        rellenaPregunta();

        txtPreguntaUno.setText(preguntaUno.getPregunta());
        txtPreguntaDos.setText(preguntaDos.getPregunta());
        txtPreguntaTres.setText(preguntaTres.getPregunta());
        txtPreguntaCuatro.setText(preguntaCuatro.getPregunta());
        txtPreguntaCinco.setText(preguntaCinco.getPregunta());
        txtPreguntaSeis.setText(preguntaSeis.getPregunta());

        rellenaRadioButton();


    }

    @Override
    public void onClick(View v) {

        if (v.equals(btnSiguiente)){

            comprobarPreguntasObigatorias();

            if(!GestionEncuentas.validarFormulario(this,camposObligatorios,new EncuestaPaginaCuatro().getClass(), false)){
                Toast.makeText(getApplicationContext(),"DEBE DE RELLENAR TODOS LOS CAMPOS OBLIGATORIOS",Toast.LENGTH_SHORT).show();
            }
        }
        /*if(v.equals(btnAtras)){
            Intent i = new Intent(getBaseContext(), EncuestaPaginaDos.class);
            startActivity(i);
        }*/
    }

    //Esto es una prueba que simula los datos que vienen de la BBDD y se incluyen en un objeto pregunta
    private void rellenaPregunta() {

        preguntaUno = new ObjetoPruebaPregunta("1- Nivel de estudios que cursas o, si ya no estudias, el máximo que has cursado. *", opcionesRespuestaUno);
        preguntaDos = new ObjetoPruebaPregunta("2- ¿Te van bien los estudios? *", opcionesRespuestaDos);
        preguntaTres = new ObjetoPruebaPregunta("3- ¿Cuántas asignaturas has suspendido? *", opcionesRespuestaTres);
        preguntaCuatro = new ObjetoPruebaPregunta("4- ¿Has repetido algún curso? *", opcionesRespuestaCuatro);
        preguntaCinco = new ObjetoPruebaPregunta("5- ¿Qué formación musical tienes? *", opcionesRespuestaCinco);
        preguntaSeis = new ObjetoPruebaPregunta("6- Si lo ves necesario, añade cualquier cosa que quieras aclarar sobre alguno de los puntos anteriores.");

    }

    private void rellenaRadioButton(){

        rb.setText(preguntaUno.getRespuestas()[0]);
        rb2.setText(preguntaUno.getRespuestas()[1]);
        rb3.setText(preguntaUno.getRespuestas()[2]);
        rb4.setText(preguntaUno.getRespuestas()[3]);
        rb5.setText(preguntaUno.getRespuestas()[4]);
        rb6.setText(preguntaUno.getRespuestas()[5]);
        rb7.setText(preguntaUno.getRespuestas()[6]);

        rbB.setText(preguntaDos.getRespuestas()[0]);
        rb2B.setText(preguntaDos.getRespuestas()[1]);
        rb3B.setText(preguntaDos.getRespuestas()[2]);


        rbA.setText(preguntaTres.getRespuestas()[0]);
        rb2A.setText(preguntaTres.getRespuestas()[1]);
        rb3A.setText(preguntaTres.getRespuestas()[2]);
        rb4A.setText(preguntaTres.getRespuestas()[3]);
        rb5A.setText(preguntaTres.getRespuestas()[4]);
        rb6A.setText(preguntaTres.getRespuestas()[5]);
        rb7A.setText(preguntaTres.getRespuestas()[6]);
        rb8A.setText(preguntaTres.getRespuestas()[7]);
        rb9A.setText(preguntaTres.getRespuestas()[8]);

        rbC.setText(preguntaCuatro.getRespuestas()[0]);
        rb2C.setText(preguntaCuatro.getRespuestas()[1]);

        cB.setText(preguntaCinco.getRespuestas()[0]);
        cB2.setText(preguntaCinco.getRespuestas()[1]);
        cB3.setText(preguntaCinco.getRespuestas()[2]);
        cB4.setText(preguntaCinco.getRespuestas()[3]);

    }

    public void comprobarPreguntasObigatorias(){


        if(!GestionEncuentas.comprobarRadiosVacios(rgEstudios)) camposObligatorios[0]=true;
        else camposObligatorios[0]=false;

        if (!GestionEncuentas.comprobarRadiosVacios(rgBEstudios)) camposObligatorios[1]=true;
        else camposObligatorios[1] = false;

        if (!GestionEncuentas.comprobarRadiosVacios(rgAsignaturas)) camposObligatorios[2]=true;
        else camposObligatorios[2] = false;

        if (!GestionEncuentas.comprobarRadiosVacios(rgCursoR)) camposObligatorios[3]=true;
        else camposObligatorios[3] = false;

        if (!GestionEncuentas.comprobarCBVacios(cBoxes)) camposObligatorios[4]=true;
        else camposObligatorios[4] = false;


    }
}
