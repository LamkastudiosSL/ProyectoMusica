package com.studios.lamka.eresloqueescuchas.Ventanas.PaginasEncuesta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.studios.lamka.eresloqueescuchas.R;
import com.studios.lamka.eresloqueescuchas.controlador.GestionEncuentas;
import com.studios.lamka.eresloqueescuchas.modelo.Pregunta;

public class EncuestaPaginaDos extends AppCompatActivity implements View.OnClickListener{

    private Button btnSiguiente, btnAtras;
    private boolean[] camposObligatorios = new boolean[6];
    private TextView txtPreguntaUno, txtPreguntaDos, txtPreguntaTres, txtPreguntaCuatro, txtPreguntaCinco, txtPreguntaSeis, txtPreguntaSiete;
    private Spinner spPreguntaUno, spPreguntaCinco, spPreguntaSeis;
    private EditText etRespuestaDos, etRespuestaTres, etRespuestaSiete;
    private CheckBox c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19;
    private Pregunta preguntaUno, preguntaDos, preguntaTres, preguntaCuatro, preguntaCinco, preguntaSeis, preguntaSiete;
    final String[] opcionesPreguntaUno = {"Elige", "Clásica", "Electrónica", "Folk", "Funk", "Flamenco", "Flamenquito (flamenco mezclado)", "Heavy",
            "Jazz", "Musicas del mundo", "Pop", "Punk", "Rap", "Reggae", "Reggaeton", "Rock", "Soul", "Trap", "Otros, escríbelos en el punto 7", "No escucho música"};
    final String[] opcionesPreguntaCuatro = {"Clásica", "Electrónica", "Folk", "Funk", "Flamenco", "Flamenquito", "Heavy", "Jazz", "Musicas del mundo",
            "No, no escucho otros estilos de música", "Pop", "Punk", "Rap", "Reggae", "Reggaeton", "Rock", "Soul", "Trap", "Otro (escribe en el punto 7 cuál)"};
    final String[] opcionesPreguntaExt = {"Elige", "Clásica", "Electrónica", "Folk", "Funk", "Flamenco", "Flamenquito (flamenco mezclado)", "Heavy",
            "Jazz", "Musicas del mundo", "Pop", "Punk", "Rap", "Reggae", "Reggaeton", "Rock", "Soul", "Trap", "Otros"};
    private CheckBox[] cBoxes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paginados);
        //AL PULSAR UN EDDITEXT TE ARREGLA EL FALLO QUE SE TE MUEVE EL LAYOUT
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
        txtPreguntaSiete = findViewById(R.id.txtPreguntaSiete);
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
        spPreguntaCinco = findViewById(R.id.spPreguntaCinco);
        spPreguntaSeis= findViewById(R.id.spPreguntaSeis);
        etRespuestaSiete = findViewById(R.id.etRespuestaSiete);

        //Array con todos los checkBox para comprobar si hay alguno seleccionado
        cBoxes = new CheckBox[]{c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19};


        //METODO QUE RELLENA LAS PREGUNTAS
        rellenaPregunta();

/*        txtPreguntaUno.setText(preguntaUno.getPregunta());
        txtPreguntaDos.setText(preguntaDos.getPregunta());
        txtPreguntaTres.setText(preguntaTres.getPregunta());
        txtPreguntaCuatro.setText(preguntaCuatro.getPregunta());
        txtPreguntaCinco.setText(preguntaCinco.getPregunta());
        txtPreguntaSeis.setText(preguntaSeis.getPregunta());
        txtPreguntaSiete.setText(preguntaSiete.getPregunta());*/

        rellenaCheckBox();

        //Adapters de los spinners
/*        ArrayAdapter<String> respuestasUno = new ArrayAdapter(getBaseContext(),
                android.R.layout.simple_spinner_item, preguntaUno.getRespuestas());
        spPreguntaUno.setAdapter(respuestasUno);

        ArrayAdapter<String> respuestasCinco = new ArrayAdapter(getBaseContext(),
                android.R.layout.simple_spinner_item, preguntaCinco.getRespuestas());
        spPreguntaCinco.setAdapter(respuestasCinco);

        ArrayAdapter<String> respuestasSeis = new ArrayAdapter(getBaseContext(),
                android.R.layout.simple_spinner_item, preguntaSeis.getRespuestas());
        spPreguntaSeis.setAdapter(respuestasSeis);*/


        //Listener del Spinner para Pregunta Uno
        spPreguntaUno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Aquí deberá guardar las respuesta que se de en la BBDD
                //Toast.makeText(getBaseContext(), spPreguntaUno.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Listener del Spinner para Pregunta Cinco
        spPreguntaCinco.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

       /* preguntaUno = new ObjetoPruebaPregunta("1 - ¿Cuál es tu estilo musical favorito? *", opcionesPreguntaUno);
        preguntaDos = new ObjetoPruebaPregunta("2- ¿ Por qué te gusta esa música? (qué te dice el estilo, qué te transmite la música, las letras, con qué te sientes identificad@, te gustan l@s cantantes...) *");
        preguntaTres = new ObjetoPruebaPregunta("3- ¿A qué edad has empezado a escucharla? *");
        preguntaCuatro = new ObjetoPruebaPregunta("4- ¿Escuchas otros estilos? Señala cuáles. *", opcionesPreguntaCuatro);
        preguntaCinco = new ObjetoPruebaPregunta("5- ¿ Cuál crees que es la más popular? *", opcionesPreguntaExt);
        preguntaSeis = new ObjetoPruebaPregunta("6- ¿Cuál crees que es la que menos se escucha? *", opcionesPreguntaExt);
        preguntaSiete = new ObjetoPruebaPregunta("7- Si lo ves necesario, añade cualquier cosa que quieras aclarar sobre alguno de los puntos anteriores.");*/


    }

    private void rellenaCheckBox() {

        /*c1.setText(preguntaCuatro.getRespuestas()[0]);
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
*/
    }

    @Override
    public void onClick(View v) {

        if (v.equals(btnSiguiente)){

            comprobarPreguntasObigatorias();

            if(!GestionEncuentas.validarFormulario(this,camposObligatorios,new EncuestaPaginaTres().getClass(), false)){
                Toast.makeText(getApplicationContext(),"DEBE DE RELLENAR TODOS LOS CAMPOS OBLIGATORIOS",Toast.LENGTH_SHORT).show();
            }
        }
        /*if(v.equals(btnAtras)){
            Intent i = new Intent(getBaseContext(), EncuestaPaginaUno.class);
            startActivity(i);
        }*/
    }

    public void comprobarPreguntasObigatorias(){

        camposObligatorios[0] = (!GestionEncuentas.comprobarSpinnerVacio(spPreguntaUno))?true:false;

        camposObligatorios[1] = (!GestionEncuentas.comprobarEditVacio(etRespuestaDos))?true:false;

        camposObligatorios[2]= (!GestionEncuentas.comprobarEditVacio(etRespuestaTres))?true:false;

        camposObligatorios[3]= (!GestionEncuentas.comprobarCBVacios(cBoxes)) ?true:false;

        camposObligatorios[4]=(!GestionEncuentas.comprobarSpinnerVacio(spPreguntaCinco))?true:false;

        camposObligatorios[5]=(!GestionEncuentas.comprobarSpinnerVacio(spPreguntaSeis))?true:false;


    }


}
