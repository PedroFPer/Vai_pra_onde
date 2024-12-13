package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ducks.vai_pra_onde.R;

public class PerfilEvento extends AppCompatActivity {
    TextView nome_evento=findViewById(R.id.nome_evento);
    TextView nome_da_empresa=findViewById(R.id.nome_da_empresa);
    TextView descrição=findViewById(R.id.descricao);
    TextView data_evento=findViewById(R.id.data_evento);
    TextView horario_evento=findViewById(R.id.horario_do_evento);
    TextView endereco=findViewById(R.id.endereco);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_perfil_evento);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}