package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ducks.vai_pra_onde.Geral.FragmeViewModel.FragmeSessaoPessoaPJViewModel;
import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;
import com.ducks.vai_pra_onde.Geral.SERVICE.EventoSERVICE;
import com.ducks.vai_pra_onde.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TelaCadastroEvento extends Fragment {

    private FragmeSessaoPessoaPJViewModel viewModelSessaoPJ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_cadastro_evento, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelSessaoPJ = new ViewModelProvider(requireActivity()).get(FragmeSessaoPessoaPJViewModel.class);

        PessoaPJ pessoaPJ = viewModelSessaoPJ.getPessoaPJ();

        //Atribuição dos componentes para variaveis

        //Informações da empresa que não podem ser modificadas
        TextView nome_da_empresa = view.findViewById(R.id.nome_da_empresa_cad);
        TextView Email = view.findViewById(R.id.Email_cad);
        TextView Telefone = view.findViewById(R.id.telefone_cad);

        //Informações da empresa que podem ser modificadas
        EditText cidade = view.findViewById(R.id.endereco_cidade_cad);
        EditText bairro = view.findViewById(R.id.endereco_bairro_cad);
        EditText rua = view.findViewById(R.id.endereco_logradouro_cad);

        //Informações do evento
        EditText nome_evento = view.findViewById(R.id.nome_evento_cad);
        EditText descricao = view.findViewById(R.id.descricao_cad);
        EditText data_ano = view.findViewById(R.id.data_ano_cad);
        EditText data_mes = view.findViewById(R.id.data_mes_cad);
        EditText data_dia=view.findViewById(R.id.data_dia_cad);
        EditText horario_hora = view.findViewById(R.id.horario_evento_cad_hora);
        EditText horario_minuto = view.findViewById(R.id.horario_do_evento_cad_min);

        //Botão cadastro

        Button buttonSubmit=view.findViewById(R.id.BtnSubmit);


        nome_da_empresa.setText(pessoaPJ.getNomeEmpresa());
        Email.setText(pessoaPJ.getEmail());
        Telefone.setText(pessoaPJ.getTelefone());


        buttonSubmit.setOnClickListener(v -> {

            String nome_evento_edit = nome_evento.getText().toString().trim();
            String nome_da_empresa_edit = nome_da_empresa.getText().toString().trim();
            String descricao_edit = descricao.getText().toString().trim();
            String email_edit = Email.getText().toString().trim();
            String telefone_edit = Telefone.getText().toString().trim();

            String cidade_edit = cidade.getText().toString().trim();
            String bairro_edit = bairro.getText().toString().trim();
            String rua_edit = rua.getText().toString().trim();

            // Usando variáveis int para evitar valores nulos desnecessários
            int data_dia_edit = -1;
            int data_mes_edit = -1;
            int data_ano_edit = -1;
            int horario_hora_edit = -1;
            int horario_minuto_edit = -1;

            // Validação de dados numéricos
            try {
                data_dia_edit = Integer.parseInt(data_dia.getText().toString().trim());
                data_mes_edit = Integer.parseInt(data_mes.getText().toString().trim());
                data_ano_edit = Integer.parseInt(data_ano.getText().toString().trim());
                horario_hora_edit = Integer.parseInt(horario_hora.getText().toString().trim());
                horario_minuto_edit = Integer.parseInt(horario_minuto.getText().toString().trim());
            } catch (NumberFormatException e) {
                Toast.makeText(getActivity(), "Preencha todos os campos com números válidos!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validações para garantir que os valores estejam dentro dos intervalos corretos
            if (data_dia_edit < 1 || data_dia_edit > 31) {
                Toast.makeText(getActivity(), "Dia do evento inválido!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (data_mes_edit < 1 || data_mes_edit > 12) {
                Toast.makeText(getActivity(), "Mês do evento inválido!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (data_ano_edit < 1900 || data_ano_edit > 2100) {
                Toast.makeText(getActivity(), "Ano do evento inválido!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (horario_hora_edit < 0 || horario_hora_edit > 23) {
                Toast.makeText(getActivity(), "Hora do evento inválida!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (horario_minuto_edit < 0 || horario_minuto_edit > 59) {
                Toast.makeText(getActivity(), "Minuto do evento inválido!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validação dos campos de texto
            if (nome_evento_edit.isEmpty()) {
                Toast.makeText(getActivity(), "Nome do evento não pode estar vazio!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (descricao_edit.isEmpty()) {
                Toast.makeText(getActivity(), "Descrição não pode estar vazia!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (cidade_edit.isEmpty()) {
                Toast.makeText(getActivity(), "Cidade não pode estar vazia!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (bairro_edit.isEmpty()) {
                Toast.makeText(getActivity(), "Bairro não pode estar vazio!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (rua_edit.isEmpty()) {
                Toast.makeText(getActivity(), "Rua não pode estar vazia!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (email_edit.isEmpty()) {
                Toast.makeText(getActivity(), "Email não pode estar vazio!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (telefone_edit.isEmpty()) {
                Toast.makeText(getActivity(), "Telefone não pode estar vazio!", Toast.LENGTH_SHORT).show();
                return;
            }


            // Formatando a data corretamente
            String data_completa = String.format("%02d/%02d/%04d", data_dia_edit, data_mes_edit, data_ano_edit);
            Date data_final = null;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                data_final = dateFormat.parse(data_completa);



            } catch (ParseException e) {
                Toast.makeText(getActivity(), "Erro ao formatar a data!", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
                return;
            }

            // Criar o objeto Evento e enviar para o serviço
            Eventos evento = new Eventos(
                    nome_evento_edit,
                    nome_da_empresa_edit,
                    pessoaPJ.getCodigoDocumento(),
                    descricao_edit,
                    email_edit,
                    telefone_edit,
                    rua_edit,
                    bairro_edit,
                    cidade_edit,
                    "Bahia",
                    horario_hora_edit,
                    horario_minuto_edit,
                    data_final
            );
            EventoSERVICE.cadastrarEvento(getActivity(), evento);
            Toast.makeText(getActivity(), "Evento Cadastrado com Sucesso", Toast.LENGTH_SHORT).show();
        });
    }
}



