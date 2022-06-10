package com.example.sistemaacademico;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
            Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
            String disciplina = txtDisciplina.getText().toString();
            intent.putExtra("disciplina", disciplina);
            startActivity(intent);
        });

        btnCancelar.setOnClickListener(view -> finish());
    }
}
