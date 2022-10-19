package org.iesch.p04_quizzes;

import static org.iesch.p04_quizzes.R.string.mensajeDelTst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import org.iesch.p04_quizzes.databinding.ActivityMainBinding;
import org.iesch.p04_quizzes.models.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    public int contador = 0;
    List<Pregunta> lstQuestions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle(getString(R.string.preguntas));

        try {
            Bundle extras = getIntent().getExtras();
            contador = extras.getInt("contador");
        } catch (Exception e) {
            contador = 0;
        }

        crearPreguntas();

        cargarPreguntas();

        botonClick();

    }

    private void crearPreguntas() {
        Pregunta question1 = new Pregunta(getString(R.string.QueAnimalEsMasRapido), getString(R.string.Liebre), getString(R.string.Tortuga), 1);
        Pregunta question2 = new Pregunta(getString(R.string.QuePesaMas), getString(R.string.DosKgDeTela), getString(R.string.UnKgDeHierro), 2);
        Pregunta question3 = new Pregunta(getString(R.string.QueEstaMasAlto), getString(R.string.UnaNubeA1500mDeAltura), getString(R.string.UnaNubeAUnKmDeAltura), 3);

        lstQuestions.add(question1);
        lstQuestions.add(question2);
        lstQuestions.add(question3);
    }

    private void cargarPreguntas() {
        Pregunta pregunta = lstQuestions.get(contador);

        binding.tvNPregunta.setText(pregunta.getNumero() + " / 3");
        binding.tvPregunta.setText(pregunta.getEnunciado());

        int random = (int) (Math.random() * 10 + 1);
        if (random % 2 != 0) {
            binding.rbTop.setText(pregunta.getRespuestaCorrecta());
            binding.rbDown.setText(pregunta.getRespuestaIncorrecta());
        } else {
            binding.rbTop.setText(pregunta.getRespuestaIncorrecta());
            binding.rbDown.setText(pregunta.getRespuestaCorrecta());
        }
    }

    private void botonClick() {
        Intent intent = new Intent(this, SolucionActivity.class);

        Pregunta pregunta = lstQuestions.get(contador);

        binding.btnEnviar.setOnClickListener(view -> {

            if (binding.rbTop.isChecked()) {
                if (binding.rbTop.getText().equals(pregunta.getRespuestaCorrecta())) {
                    intent.putExtra("bool", true);
                    intent.putExtra("contador", pregunta.getNumero());
                    startActivity(intent);
                } else {
                    intent.putExtra("bool", false);
                    intent.putExtra("contador", pregunta.getNumero());
                    startActivity(intent);
                }
            } else if (binding.rbDown.isChecked()) {
                if (binding.rbDown.getText().equals(pregunta.getRespuestaCorrecta())) {
                    intent.putExtra("bool", true);
                    intent.putExtra("contador", pregunta.getNumero());
                    startActivity(intent);
                } else {
                    intent.putExtra("bool", false);
                    intent.putExtra("contador", pregunta.getNumero());
                    startActivity(intent);
                }
            } else {
                Toast.makeText(this, mensajeDelTst, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
