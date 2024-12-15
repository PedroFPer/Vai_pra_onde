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
    TextView nomeEventoView = findViewById(R.id.nome_evento_vw);
    TextView nomeDaEmpresaView = findViewById(R.id.nome_da_empresa_vw);
    TextView descricaoView = findViewById(R.id.descricao_vw);
    TextView dataAnoView = findViewById(R.id.data_ano_vw);
    TextView dataMesView = findViewById(R.id.data_mes_vw);
    TextView dataEventoView = findViewById(R.id.data_evento_vw);
    TextView horarioHoraView = findViewById(R.id.horario_do_evento_vw_hora);
    TextView horarioMinView = findViewById(R.id.horario_do_evento_vw_min);
    TextView emailView = findViewById(R.id.Email_vw);
    TextView enderecoCidadeView = findViewById(R.id.endereco_cidade_vw);
    TextView enderecoBairroView = findViewById(R.id.endereco_bairro_vw);
    TextView enderecoLogradouroView = findViewById(R.id.endereco_logradouro_vw);
    TextView telefoneView = findViewById(R.id.telefone_vw);
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