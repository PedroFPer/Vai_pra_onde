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


import com.ducks.vai_pra_onde.Geral.FragmeViewModel.FragmeCadasPessoPjViewModel;
import com.ducks.vai_pra_onde.Geral.Utilidades.UtilVericCreden;
import com.ducks.vai_pra_onde.R;

public class TelaCadasPJ2 extends Fragment {

    private FragmeCadasPessoPjViewModel viewModelPj;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_tela_cadas_pj2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelPj = new ViewModelProvider(requireActivity()).get(FragmeCadasPessoPjViewModel.class);
        UtilVericCreden utilVericCreden = new UtilVericCreden();

        EditText edtNomeResPj = view.findViewById(R.id.CadasNomeResPj);
        EditText edtCpfResPj = view.findViewById(R.id.CadasCpfResPj);
        EditText edtSenhaResPj = view.findViewById(R.id.CadasSenhaResPj);
        Button buttonCadasPj1 = view.findViewById(R.id.BotaoCadas1);

        edtNomeResPj.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                if (edtNomeResPj.getText().toString().equals("João da silva")) {
                    edtNomeResPj.setText("");
                }
            }
        });

        edtCpfResPj.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                if (edtCpfResPj.getText().toString().equals("00000000000")) {
                    edtCpfResPj.setText("");
                }
            }
        });

        edtSenhaResPj.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                if (edtSenhaResPj.getText().toString().equals("1234567")) {
                    edtSenhaResPj.setText("");
                }
            }
        });

        buttonCadasPj1.setOnClickListener(v -> {
            String nomeResPj = edtNomeResPj.getText().toString().trim();
            String cpfResPj = edtCpfResPj.getText().toString().trim();
            String senhaPj = edtSenhaResPj.getText().toString().trim();

            if (nomeResPj.isEmpty()) {
                Toast.makeText(getContext(), "O nome do responsável não pode estar vazio.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (cpfResPj.isEmpty()) {
                Toast.makeText(getContext(), "O CPF não pode estar vazio", Toast.LENGTH_SHORT).show();
                return;
            } else if (!utilVericCreden.vericCpf(cpfResPj)) {
                Toast.makeText(getContext(), "O CPF deve conter exatamente 11 dígitos numéricos", Toast.LENGTH_SHORT).show();
                return;
            }

            if (senhaPj.isEmpty()) {
                Toast.makeText(getContext(), "A senha não pode estar vazio", Toast.LENGTH_SHORT).show();
                return;
            } else if (!utilVericCreden.vericSenha(senhaPj)) {
                Toast.makeText(getContext(), "A senha tem que ter 8 caracteres ", Toast.LENGTH_SHORT).show();
                return;
            }

            viewModelPj.setResponsavel(nomeResPj);
            viewModelPj.setCpfResponsavel(cpfResPj);
            viewModelPj.setSenha(senhaPj);

            if (getActivity() != null) {
                com.ducks.vai_pra_onde.Geral.TelasFront.FragmentManagerHelper.replaceFragment((AppCompatActivity) getActivity(), new TelaCadasPJ3());
            }
        });
    }
}


