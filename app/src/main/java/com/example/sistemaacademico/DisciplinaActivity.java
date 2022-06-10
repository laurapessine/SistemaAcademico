package com.example.sistemaacademico;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DisciplinaActivity extends AppCompatActivity {

    private EditText txtDisciplina;
    private Button btnOK, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplina);

        txtDisciplina = findViewById(R.id.txtDisciplina);
        btnOK = findViewById(R.id.btnOK3);
        btnCancelar = findViewById(R.id.btnCancelar3);

        btnOK.setOnClickListener(view -> {
            Intent intent = new Intent();
            String disciplina = txtDisciplina.getText().toString();
            if (disciplina.isEmpty() || !disciplina.matches(".*\\w.*")) {
                Toast.makeText(getApplicationContext(), "Disciplina não informada",
                        Toast.LENGTH_LONG).show();
            } else {
                intent.putExtra("disciplina", disciplina);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btnCancelar.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("disciplina", "não informado");
            setResult(RESULT_CANCELED, intent);
            finish();
        });
    }
}
