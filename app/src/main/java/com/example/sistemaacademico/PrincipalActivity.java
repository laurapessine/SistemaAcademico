package com.example.sistemaacademico;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PrincipalActivity extends AppCompatActivity {

    private TextView lblEscola, lblProf, lblTitulo, lblDisc1, lblDisc2, lblDisc3;
    private Button btnProfessor, btnDisciplina;
    private RadioGroup radioGroup;
    private RadioButton radDisc1, radDisc2, radDisc3;

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
        radDisc1 = findViewById(R.id.radDisc1);
        radDisc2 = findViewById(R.id.radDisc2);
        radDisc3 = findViewById(R.id.radDisc3);

        Intent intentMain = getIntent();
        String escola = intentMain.getStringExtra("escola");
        lblEscola.setText(escola);

        btnProfessor.setOnClickListener(view -> {
            Intent intentVaiProf = new Intent(getApplicationContext(), ProfessorActivity.class);
            startActivity(intentVaiProf);
        });

        btnDisciplina.setOnClickListener(view -> {
            Intent intentVaiDisc = new Intent(getApplicationContext(), DisciplinaActivity.class);
            startActivity(intentVaiDisc);
        });

        Intent intentVoltaProf = getIntent();
        String professor = intentVoltaProf.getStringExtra("professor");
        String titulacao = intentVoltaProf.getStringExtra("titulacao");
        lblProf.setText(professor);
        lblTitulo.setText(titulacao);
    }

    private class EscutadorRadioGroup implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int id) {
            switch (id) {
                case R.id.radDisc1:
                    // código aqui
                    break;
                case R.id.radDisc2:
                    // código aqui
                    break;
                case R.id.radDisc3:
                    // código aqui
                    break;
            }
        }
    }
}
