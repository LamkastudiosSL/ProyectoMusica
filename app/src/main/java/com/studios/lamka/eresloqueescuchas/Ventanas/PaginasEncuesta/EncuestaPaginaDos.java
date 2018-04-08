package com.studios.lamka.eresloqueescuchas.Ventanas.PaginasEncuesta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.studios.lamka.eresloqueescuchas.R;
import com.studios.lamka.eresloqueescuchas.Modelos.ObjetoPruebaPregunta;

public class EncuestaPaginaDos extends AppCompatActivity {

    private Button btnSiguiente, btnAtras;
    private TextView txtPreguntaUno, txtPreguntaDos, txtPreguntaTres, txtPreguntaCuatro;
    private Spinner spPreguntaUno;
    private EditText etRespuestaDos, etRespuestaTres;
    private CheckBox c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19;
    private ObjetoPruebaPregunta preguntaUno, preguntaDos, preguntaTres, preguntaCuatro, preguntaCinco, preguntaSeis, preguntaSiete;
    final String[] opcionesPreguntaUno = {"Elige", "Clásica", "Electrónica", "Folk", "Funk", "Flamenco", "Flamenquito (flamenco mezclado)", "Heavy",
            "Jazz", "Musicas del mundo", "Pop", "Punk", "Rap", "Reggae", "Reggaeton", "Rock", "Soul", "Trap", "Otros, escríbelos en el punto 7", "No escucho música"};
    final String[] opcionesPreguntaCuatro = {"Clásica" ,
            "Electrónica" ,
            "Folk" ,
            "Funk" ,
            "Flamenco" ,
            "Flamenquito" ,
            "Heavy" ,
            "Jazz" ,
            "Musicas del mundo" ,
            "No, no escucho otros estilos de música" ,
            "Pop" ,
            "Punk" ,
            "Rap" ,
            "Reggae" ,
            "Reggaeton" ,
            "Rock" ,
            "Soul" ,
            "Trap" ,
            "Otro (escribe en el punto 7 cuál)"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paginados);

        btnSiguiente = findViewById(R.id.btnsiguiente);
        btnAtras = findViewById(R.id.btnpaginanaterior);
        //Declaracion de preguntas
        txtPreguntaUno = findViewById(R.id.txtPreguntaUno);
        txtPreguntaDos = findViewById(R.id.txtPreguntaDos);
        txtPreguntaTres = findViewById(R.id.txtPreguntaTres);
        txtPreguntaCuatro = findViewById(R.id.txtPreguntaCuatro);
        //Declaracion de respuestas
        spPreguntaUno = findViewById(R.id.spPreguntaUno);
        etRespuestaDos = findViewById(R.id.etRespuestaDos);
        etRespuestaTres = findViewById(R.id.etRespuestaTres);
        c1 = findViewById(R.id.checkBox);
        c2 = findViewById(R.id.checkBox22);
        c3 = findViewById(R.id.checkBox21);
        c4 = findViewById(R.id.checkBox20);
        c5 = findViewById(R.id.checkBox19);
        c6 = findViewById(R.id.checkBox18);
        c7 = findViewById(R.id.checkBox17);
        c8 = findViewById(R.id.checkBox16);
        c9 = findViewById(R.id.checkBox15);
        c10 = findViewById(R.id.checkBox14);
        c11 = findViewById(R.id.checkBox13);
        c12 = findViewById(R.id.checkBox12);
        c13 = findViewById(R.id.checkBox11);
        c14 = findViewById(R.id.checkBox10);
        c15 = findViewById(R.id.checkBox9);
        c16 = findViewById(R.id.checkBox8);
        c17 = findViewById(R.id.checkBox7);
        c18 = findViewById(R.id.checkBox6);
        c19 = findViewById(R.id.checkBox5);

        //METODO QUE RELLENA LAS PREGUNTAS
        rellenaPregunta();

        txtPreguntaUno.setText(preguntaUno.getPregunta());
        txtPreguntaDos.setText((preguntaDos.getPregunta()));
        txtPreguntaTres.setText((preguntaTres.getPregunta()));
        txtPreguntaCuatro.setText((preguntaCuatro.getPregunta()));

        rellenaCheckBox();

        ArrayAdapter<String> respuestasUno = new ArrayAdapter(getBaseContext(),
                android.R.layout.simple_spinner_item, preguntaUno.getRespuestas());
        spPreguntaUno.setAdapter(respuestasUno);



        //Listener del Spinner para Pregunta Dos
        spPreguntaUno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Aquí deberá guardar las respuesta que se de en la BBDD
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    //Esto es una prueba que simula los datos que vienen de la BBDD y se incluyen en un objeto pregunta
    private void rellenaPregunta() {

        preguntaUno = new ObjetoPruebaPregunta("1 - ¿Cuál es tu estilo musical favorito? *", opcionesPreguntaUno);
        preguntaDos = new ObjetoPruebaPregunta("2- ¿ Por qué te gusta esa música? (qué te dice el estilo, qué te transmite la música, las letras, con qué te sientes identificad@, te gustan l@s cantantes...) *");
        preguntaTres = new ObjetoPruebaPregunta("3- ¿A qué edad has empezado a escucharla? *");
        preguntaCuatro = new ObjetoPruebaPregunta("4- ¿Escuchas otros estilos? Señala cuáles. *", opcionesPreguntaCuatro);


    }

    private void rellenaCheckBox(){

        c1.setText(preguntaCuatro.getRespuestas()[0]);
        c2.setText(preguntaCuatro.getRespuestas()[1]);
        c3.setText(preguntaCuatro.getRespuestas()[2]);
        c4.setText(preguntaCuatro.getRespuestas()[3]);
        c5.setText(preguntaCuatro.getRespuestas()[4]);
        c6.setText(preguntaCuatro.getRespuestas()[5]);
        c7.setText(preguntaCuatro.getRespuestas()[6]);
        c8.setText(preguntaCuatro.getRespuestas()[7]);
        c9.setText(preguntaCuatro.getRespuestas()[8]);
        c10.setText(preguntaCuatro.getRespuestas()[9]);
        c11.setText(preguntaCuatro.getRespuestas()[10]);
        c12.setText(preguntaCuatro.getRespuestas()[11]);
        c13.setText(preguntaCuatro.getRespuestas()[12]);
        c14.setText(preguntaCuatro.getRespuestas()[13]);
        c15.setText(preguntaCuatro.getRespuestas()[14]);
        c16.setText(preguntaCuatro.getRespuestas()[15]);
        c17.setText(preguntaCuatro.getRespuestas()[16]);
        c18.setText(preguntaCuatro.getRespuestas()[17]);
        c19.setText(preguntaCuatro.getRespuestas()[18]);

    }


}
