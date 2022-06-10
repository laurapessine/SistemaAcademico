// LAURA E EVANDRO
package com.example.sistemaacademico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
            String escola = txtEscola.getText().toString().trim();
            if (escola.isEmpty() || !escola.matches(".*\\w.*")) {
                Toast.makeText(getApplicationContext(), "Por favor, informe o nome da escola",
                        Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
                intent.putExtra("escola", escola);
                finish();
                startActivity(intent);
            }
        });

        btnCancelar.setOnClickListener(view -> System.exit(0));
    }
}