package com.example.sistemaacademico;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ProfessorActivity extends AppCompatActivity {

    private EditText txtNome, txtTitulacao;
    private Button btnOK, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

        txtNome = findViewById(R.id.txtNome);
        txtTitulacao = findViewById(R.id.txtTitulacao);
        btnOK = findViewById(R.id.btnOK2);
        btnCancelar = findViewById(R.id.btnCancelar2);

        btnOK.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
            String professor = txtNome.getText().toString();
            String titulacao = txtTitulacao.getText().toString();
            intent.putExtra("professor", professor);
            intent.putExtra("titulacao", titulacao);
            startActivity(intent);
        });

        btnCancelar.setOnClickListener(view -> finish());
    }
}
