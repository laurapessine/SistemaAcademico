package com.example.sistemaacademico;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
            Intent intent = new Intent();
            String professor = txtNome.getText().toString().trim();
            String titulacao = txtTitulacao.getText().toString().trim();
            if (professor.isEmpty() || !professor.matches(".*\\w.*") ||
                    titulacao.isEmpty() || !titulacao.matches(".*\\w.*")) {
                Toast.makeText(getApplicationContext(), "Nome e/ou titulação não informado(s)",
                        Toast.LENGTH_LONG).show();
            } else {
                intent.putExtra("professor", professor);
                intent.putExtra("titulacao", titulacao);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btnCancelar.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("professor", "não informado");
            intent.putExtra("titulacao", "não informado");
            setResult(RESULT_CANCELED, intent);
            finish();
        });
    }
}
