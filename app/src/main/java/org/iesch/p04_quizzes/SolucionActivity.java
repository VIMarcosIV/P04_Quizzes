package org.iesch.p04_quizzes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import org.iesch.p04_quizzes.MainActivity;
import org.iesch.p04_quizzes.R;
import org.iesch.p04_quizzes.databinding.ActivitySolucionBinding;

public class SolucionActivity extends AppCompatActivity {
    ActivitySolucionBinding binding;
    int numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySolucionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle(getString(R.string.ResultadosTitle));

        obtenerDatos();

        botonClick();
    }

    private void obtenerDatos() {
        Bundle extras = getIntent().getExtras();
        numero = extras.getInt("contador");
        boolean acierto = extras.getBoolean("bool");
        binding.btnResultados.setText(R.string.SiguientePregunta);

        if (acierto == true) {
            binding.tvResultados.setText(R.string.RespCorrecta);
        } else {
            binding.tvResultados.setText(R.string.RespIncorrecta);
        }

        if (numero == 3) {
            if (acierto == true) {
                binding.tvResultados.setText(R.string.RespCorrecta);
                binding.btnResultados.setText(R.string.RecomenzarQuiz);
            } else {
                binding.tvResultados.setText(R.string.RespIncorrecta);
                binding.btnResultados.setText(R.string.RecomenzarQuiz);
            }
        }
    }

    private void botonClick() {
        Intent intent = new Intent(this, MainActivity.class);

        binding.btnResultados.setOnClickListener(v -> {
            if (numero != 3) {
                intent.putExtra("contador", numero);
            } else {
                intent.putExtra("contador", 0);
            }
            startActivity(intent);
        });
    }
}