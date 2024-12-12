package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;
import com.ducks.vai_pra_onde.R;

import java.util.ArrayList;

public class PerfilEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_perfil_empresa);

        ArrayList<Eventos> listaUsuarios = getIntent().getParcelableArrayListExtra("listaUsuarios");
        PessoaPJ pessoaPJ = getIntent().getParcelableExtra("pessoaJuridica");

        TextView editNom = findViewById(R.id.nome);
        TextView editEmai = findViewById(R.id.email);



        editNom.setText(pessoaPJ.getNomeEmpresa());
        editEmai.setText(pessoaPJ.getEmail());





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}