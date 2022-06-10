package com.example.sistemaacademico;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PrincipalActivity extends AppCompatActivity {

    private TextView lblEscola, lblProf, lblTitulo, lblDisc1, lblDisc2, lblDisc3;
    private Button btnProfessor, btnDisciplina;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        lblEscola = findViewById(R.id.lblEscola);
        lblProf = findViewById(R.id.lblProf);
        lblTitulo = findViewById(R.id.lblTitulo);
        lblDisc1 = findViewById(R.id.lblDisc1);
        lblDisc2 = findViewById(R.id.lblDisc2);
        lblDisc3 = findViewById(R.id.lblDisc3);
        btnProfessor = findViewById(R.id.btnProfessor);
        btnDisciplina = findViewById(R.id.btnDisciplina);
        radioGroup = findViewById(R.id.radioGroup);

        Intent intentMain = getIntent();
        String escola = intentMain.getStringExtra("escola");
        lblEscola.setText(escola);

        btnProfessor.setOnClickListener(view -> {
            Intent intentProf = new Intent(getApplicationContext(), ProfessorActivity.class);
            startActivityForResult(intentProf, 1);
        });

        btnDisciplina.setOnClickListener(view -> {
            int radio = radioGroup.getCheckedRadioButtonId();
            if (radio == -1) {
                Toast.makeText(getApplicationContext(), "Por favor, selecione uma disciplina",
                        Toast.LENGTH_LONG).show();
            } else {
                Intent intentDisc = new Intent(getApplicationContext(), DisciplinaActivity.class);
                startActivityForResult(intentDisc, 2);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String professor = intent.getStringExtra("professor");
                String titulacao = intent.getStringExtra("titulacao");
                lblProf.setText(professor);
                lblTitulo.setText(titulacao);
            } else {
                lblProf.setText("não informado");
                lblTitulo.setText("não informado");
            }
        } else if (requestCode == 2) {
            int radio = radioGroup.getCheckedRadioButtonId();
            if (resultCode == RESULT_OK) {
                String disciplina = intent.getStringExtra("disciplina");
                if (radio == R.id.radDisc1) {
                    lblDisc1.setText(disciplina);
                } else if (radio == R.id.radDisc2) {
                    lblDisc2.setText(disciplina);
                } else if (radio == R.id.radDisc3) {
                    lblDisc3.setText(disciplina);
                }
            } else {
                if (radio == R.id.radDisc1) {
                    lblDisc1.setText("não informado");
                } else if (radio == R.id.radDisc2) {
                    lblDisc2.setText("não informado");
                } else if (radio == R.id.radDisc3) {
                    lblDisc3.setText("não informado");
                }
            }
        }
    }
}
