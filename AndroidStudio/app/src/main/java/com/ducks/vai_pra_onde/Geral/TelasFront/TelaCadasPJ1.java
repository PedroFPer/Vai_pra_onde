package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class TelaCadasPJ1 extends AppCompatActivity {
    private ViewCadasPessoPjDTO viewModelPj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_cadas_pj1);

        viewModelPj = new ViewModelProvider(this).get(ViewCadasPessoPjDTO.class);

        EditText edtNomeEmprPj = findViewById(R.id.CadasNomePj);
        EditText edtEmailEmprPj = findViewById(R.id.CadasEmailPj);
        EditText edtTelefEmprPj = findViewById(R.id.CadasTelefPj);
        EditText edtCnpjEmprPj= findViewById(R.id.CadasCnpjPj);
        Button buttonCadasPj1 = findViewById(R.id.BotaoCadas1);

        buttonCadasPj1.setOnClickListener(v -> {

            String nomeEmprPj = edtNomeEmprPj.getText().toString().trim();
            String emailEmprPj = edtEmailEmprPj.getText().toString().trim();
            String telefEmprPj = edtTelefEmprPj.getText().toString().trim();
            String cnpjEmprPj = edtCnpjEmprPj.getText().toString().trim();


            if (nomeEmprPj.isEmpty()) {
                Toast.makeText(this, "O nome não pode estar vazio.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (emailEmprPj.isEmpty()) {
                Toast.makeText(this, "O email não pode estar vazio.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (telefEmprPj.length() != 13) {
                Toast.makeText(this, "O telefone deve ter exatamente 13 dígitos.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (cnpjEmprPj.length() != 14) {
                Toast.makeText(this, "O CNPJ deve ter exatamente 14 dígitos.", Toast.LENGTH_SHORT).show();
                return;
            }

            viewModelPj.setNomeEmpresa(nomeEmprPj);
            viewModelPj.setEmail(emailEmprPj);
            viewModelPj.setTelefone(telefEmprPj);
            viewModelPj.setCnpj(cnpjEmprPj);


            Intent intent = new Intent(TelaCadasPJ1.this, TelaCadasPJ2.class);
            startActivity(intent);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
