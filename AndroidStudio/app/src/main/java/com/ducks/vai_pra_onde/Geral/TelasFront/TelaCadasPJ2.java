package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.ducks.vai_pra_onde.Geral.DTO.ViewCadasPessoPjDTO;
import com.ducks.vai_pra_onde.R;

public class TelaCadasPJ2 extends AppCompatActivity {
    private ViewCadasPessoPjDTO viewModelPj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_cadas_pj2);


        viewModelPj = new ViewModelProvider(this).get(ViewCadasPessoPjDTO.class);


        EditText edtNomeResPj = findViewById(R.id.CadasNomeResPj);
        EditText edtCpfResPj = findViewById(R.id.CadasCpfResPj);
        Button buttonCadasPj1 = findViewById(R.id.BotaoCadas1);


        buttonCadasPj1.setOnClickListener(v -> {
            String nomeResPj = edtNomeResPj.getText().toString().trim();
            String cpfResPj = edtCpfResPj.getText().toString().trim();


            if (nomeResPj.isEmpty()) {
                Toast.makeText(this, "O nome do responsável não pode estar vazio.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (cpfResPj.length() != 11) {
                Toast.makeText(this, "O CPF deve ter exatamente 11 dígitos.", Toast.LENGTH_SHORT).show();
                return;
            }

            viewModelPj.setResponsavel(nomeResPj);
            viewModelPj.setCpfResponsavel(cpfResPj);


            Intent intent = new Intent(TelaCadasPJ2.this, TelaCadasPJ3.class);
            startActivity(intent);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

