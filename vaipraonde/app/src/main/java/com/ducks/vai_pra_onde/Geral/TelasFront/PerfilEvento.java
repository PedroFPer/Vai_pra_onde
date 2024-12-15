package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.ducks.vai_pra_onde.R;

public class PerfilEvento extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_evento_cadastro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView nomeEventoView = view.findViewById(R.id.nome_evento_vw);
        TextView nomeDaEmpresaView = view.findViewById(R.id.nome_da_empresa_vw);
        TextView descricaoView = view.findViewById(R.id.descricao_vw);
        TextView dataAnoView = view.findViewById(R.id.data_ano_vw);
        TextView dataMesView = view.findViewById(R.id.data_mes_vw);
        TextView dataEventoView = view.findViewById(R.id.data_evento_vw);
        TextView horarioHoraView = view.findViewById(R.id.horario_do_evento_vw_hora);
        TextView horarioMinView = view.findViewById(R.id.horario_do_evento_vw_min);
        TextView emailView = view.findViewById(R.id.Email_vw);
        TextView enderecoCidadeView = view.findViewById(R.id.endereco_cidade_vw);
        TextView enderecoBairroView = view.findViewById(R.id.endereco_bairro_vw);
        TextView enderecoLogradouroView = view.findViewById(R.id.endereco_logradouro_vw);
        TextView telefoneView = view.findViewById(R.id.telefone_vw);
    }

}


