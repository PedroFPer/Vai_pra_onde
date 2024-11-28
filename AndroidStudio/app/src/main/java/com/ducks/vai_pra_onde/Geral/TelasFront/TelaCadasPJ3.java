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

public class TelaCadasPJ3 extends AppCompatActivity {
    private ViewCadasPessoPjDTO viewModelPj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_cadas_pj3);

        viewModelPj = new ViewModelProvider(this).get(ViewCadasPessoPjDTO.class);

        // Referências aos elementos do layout
        EditText edtLogradouro = findViewById(R.id.CadasLogrPj);
        EditText edtBairro = findViewById(R.id.CadasBairrPj);
        EditText edtCidade = findViewById(R.id.CadasCidadesPj);
        EditText edtEstado = findViewById(R.id.CadasEstaPj);
        EditText edtPais = findViewById(R.id.CadasPaisPj);
        Button buttonProxima = findViewById(R.id.BotaoCadas1);

        buttonProxima.setOnClickListener(v -> {
            String logradouro = edtLogradouro.getText().toString().trim();
            String bairro = edtBairro.getText().toString().trim();
            String cidade = edtCidade.getText().toString().trim();
            String estado = edtEstado.getText().toString().trim();
            String pais = edtPais.getText().toString().trim();


            if (logradouro.isEmpty()) {
                Toast.makeText(this, "O logradouro não pode estar vazio.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (bairro.isEmpty()) {
                Toast.makeText(this, "O bairro não pode estar vazio.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (cidade.isEmpty()) {
                Toast.makeText(this, "A cidade não pode estar vazia.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (estado.isEmpty()) {
                Toast.makeText(this, "O estado não pode estar vazio.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (pais.isEmpty()) {
                Toast.makeText(this, "O país não pode estar vazio.", Toast.LENGTH_SHORT).show();
                return;
            }

            viewModelPj.setLogradouro(logradouro);
            viewModelPj.setBairro(bairro);
            viewModelPj.setCidade(cidade);
            viewModelPj.setEstado(estado);
            viewModelPj.setPais(pais);


            Intent intent = new Intent(TelaCadasPJ3.this, TelaCadasPJ4.class);
            startActivity(intent);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
