package com.example.sistemaacademico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtEscola;
    private Button btnOK, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEscola = findViewById(R.id.txtEscola);
        btnOK = findViewById(R.id.btnOK);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnOK.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
            String escola = txtEscola.getText().toString();
            intent.putExtra("escola", escola);
            startActivity(intent);
        });

        btnCancelar.setOnClickListener(view -> {
            System.exit(0);
        });
    }
}