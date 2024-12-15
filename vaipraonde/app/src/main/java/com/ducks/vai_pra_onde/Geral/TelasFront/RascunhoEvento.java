package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ducks.vai_pra_onde.Geral.FragmeViewModel.FragmeSessaoPessoaPJViewModel;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;
import com.ducks.vai_pra_onde.R;

public class RascunhoEvento extends Fragment {

    private FragmeSessaoPessoaPJViewModel viewModelSessaoPJ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_evento_cadastro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelSessaoPJ = new ViewModelProvider(requireActivity()).get(FragmeSessaoPessoaPJViewModel.class);

        PessoaPJ pessoaPJ = viewModelSessaoPJ.getPessoaPJ();

        //Atribuição dos componentes para variaveis

        //Informações da empresa que não podem ser modificadas
        TextView nomeDaEmpresaView = view.findViewById(R.id.nome_da_empresa_vw);
        TextView emailView = view.findViewById(R.id.Email_vw);
        TextView telefoneView = view.findViewById(R.id.telefone_vw);

        //Informações da empresa que podem ser modificadas
        EditText enderecoCidadeView = view.findViewById(R.id.endereco_cidade_vw);
        EditText enderecoBairroView = view.findViewById(R.id.endereco_bairro_vw);
        EditText enderecoLogradouroView = view.findViewById(R.id.endereco_logradouro_vw);

        //Informações do evento
        EditText nomeEventoView = view.findViewById(R.id.nome_evento_vw);
        EditText descricaoView = view.findViewById(R.id.descricao_vw);
        EditText dataAnoView = view.findViewById(R.id.data_ano_vw);
        EditText dataMesView = view.findViewById(R.id.data_mes_vw);
        EditText dataEventoView = view.findViewById(R.id.data_evento_vw);
        EditText horarioHoraView = view.findViewById(R.id.horario_do_evento_vw_hora);
        EditText horarioMinView = view.findViewById(R.id.horario_do_evento_vw_min);


        //Atribuição dos valores para o front
        nomeDaEmpresaView.setText(pessoaPJ.getNomeEmpresa());
        emailView.setText(pessoaPJ.getEmail());
        telefoneView.setText(pessoaPJ.getTelefone());



    }

}


