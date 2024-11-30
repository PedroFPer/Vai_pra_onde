package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.ducks.vai_pra_onde.Geral.DTO.ViewCadasPessoPjDTO;
import com.ducks.vai_pra_onde.R;
import com.ducks.vai_pra_onde.Geral.TelasFront.FragmentManagerHelper;

public class TelaCadasPJ2 extends Fragment {

    private ViewCadasPessoPjDTO viewModelPj;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_tela_cadas_pj2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelPj = new ViewModelProvider(requireActivity()).get(ViewCadasPessoPjDTO.class);

        EditText edtNomeResPj = view.findViewById(R.id.CadasNomeResPj);
        EditText edtCpfResPj = view.findViewById(R.id.CadasCpfResPj);
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

        buttonCadasPj1.setOnClickListener(v -> {
            String nomeResPj = edtNomeResPj.getText().toString().trim();
            String cpfResPj = edtCpfResPj.getText().toString().trim();

            if (nomeResPj.isEmpty()) {
                Toast.makeText(getContext(), "O nome do responsável não pode estar vazio.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (cpfResPj.length() != 11) {
                Toast.makeText(getContext(), "O CPF deve ter exatamente 11 dígitos.", Toast.LENGTH_SHORT).show();
                return;
            }

            viewModelPj.setResponsavel(nomeResPj);
            viewModelPj.setCpfResponsavel(cpfResPj);

            if (getActivity() != null) {
                FragmentManagerHelper.replaceFragment((AppCompatActivity) getActivity(), new TelaCadasPJ3());
            }
        });
    }
}


