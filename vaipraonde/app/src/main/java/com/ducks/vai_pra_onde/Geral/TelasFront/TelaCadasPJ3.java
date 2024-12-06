package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ducks.vai_pra_onde.Geral.DTO.FragmeCadasPessoPjDTO;
import com.ducks.vai_pra_onde.R;

public class TelaCadasPJ3 extends Fragment {
    private FragmeCadasPessoPjDTO viewModelPj;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar o layout do fragmento
        return inflater.inflate(R.layout.activity_tela_cadas_pj3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obter a instância do ViewModel
        viewModelPj = new ViewModelProvider(requireActivity()).get(FragmeCadasPessoPjDTO.class);


        // Referências aos elementos do layout
        EditText edtLogradouro = view.findViewById(R.id.CadasLogrPj);
        EditText edtBairro = view.findViewById(R.id.CadasBairrPj);
        EditText edtCidade = view.findViewById(R.id.CadasCidadesPj);
        EditText edtEstado = view.findViewById(R.id.CadasEstaPj);
        EditText edtPais = view.findViewById(R.id.CadasPaisPj);
        Button buttonProxima = view.findViewById(R.id.BotaoCadas1);

        edtLogradouro.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                if (edtLogradouro.getText().toString().equals("Rua, Galeria")){
                    edtLogradouro.setText("");
                }
            }
        });

        edtBairro.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                if (edtBairro.getText().toString().equals("Queimadinha")) {
                    edtBairro.setText("");
                }
            }
        });
        edtCidade.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                if (edtCidade.getText().toString().equals("Feira de Santana")) {
                    edtCidade.setText("");
                }
            }
        });

        edtEstado.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                if (edtEstado.getText().toString().equals("Bahia")) {
                    edtEstado.setText("");
                }
            }
        });

        edtPais.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                if (edtPais.getText().toString().equals("Brasil")) {
                    edtPais.setText("");
                }
            }
        });

        buttonProxima.setOnClickListener(v -> {
            String logradouro = edtLogradouro.getText().toString().trim();
            String bairro = edtBairro.getText().toString().trim();
            String cidade = edtCidade.getText().toString().trim();
            String estado = edtEstado.getText().toString().trim();
            String pais = edtPais.getText().toString().trim();

            // Validações para garantir que os campos não estão vazios
            if (logradouro.isEmpty()) {
                Toast.makeText(getContext(), "O logradouro não pode estar vazio.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (bairro.isEmpty()) {
                Toast.makeText(getContext(), "O bairro não pode estar vazio.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (cidade.isEmpty()) {
                Toast.makeText(getContext(), "A cidade não pode estar vazia.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (estado.isEmpty()) {
                Toast.makeText(getContext(), "O estado não pode estar vazio.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (pais.isEmpty()) {
                Toast.makeText(getContext(), "O país não pode estar vazio.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Armazenar as informações no ViewModel
            viewModelPj.setLogradouro(logradouro);
            viewModelPj.setBairro(bairro);
            viewModelPj.setCidade(cidade);
            viewModelPj.setEstado(estado);
            viewModelPj.setPais(pais);

            if (getActivity() != null) {
                com.ducks.vai_pra_onde.Geral.TelasFront.FragmentManagerHelper.replaceFragment((AppCompatActivity) getActivity(), new TelaCadasPJ4());
            }
        });
    }
}
