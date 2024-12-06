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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ducks.vai_pra_onde.Geral.DTO.FragmeCadasPessoPjDTO;
import com.ducks.vai_pra_onde.R;

public class TelaCadasPJ1 extends Fragment {
    private FragmeCadasPessoPjDTO viewModelPj;

    public TelaCadasPJ1() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_tela_cadas_pj1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelPj = new ViewModelProvider(requireActivity()).get(FragmeCadasPessoPjDTO.class);

        EditText edtNomeEmprPj = view.findViewById(R.id.CadasNomePj);
        EditText edtEmailEmprPj = view.findViewById(R.id.CadasEmailPj);
        EditText edtTelefEmprPj = view.findViewById(R.id.CadasTelefPj);
        EditText edtCnpjEmprPj = view.findViewById(R.id.CadasCnpjPj);
        Button buttonCadasPj1 = view.findViewById(R.id.BotaoCadas1);

        edtNomeEmprPj.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                if (edtNomeEmprPj.getText().toString().equals("Espaço de evento exemplo")) {
                    edtNomeEmprPj.setText("");
                        }
                    }
                });

        edtEmailEmprPj.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                if (edtEmailEmprPj.getText().toString().equals("email@email.com.br")) {
                    edtEmailEmprPj.setText("");
                }
            }
        });

        edtTelefEmprPj.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                if (edtTelefEmprPj.getText().toString().equals("1234567891234")) {
                    edtTelefEmprPj.setText("");
                }
            }
        });

        edtCnpjEmprPj.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                if (edtCnpjEmprPj.getText().toString().equals("12345678912345")) {
                    edtCnpjEmprPj.setText("");
                }
            }
        });



        buttonCadasPj1.setOnClickListener(v -> {
            String nomeEmprPj = edtNomeEmprPj.getText().toString().trim();
            String emailEmprPj = edtEmailEmprPj.getText().toString().trim();
            String telefEmprPj = edtTelefEmprPj.getText().toString().trim();
            String cnpjEmprPj = edtCnpjEmprPj.getText().toString().trim();


            if (nomeEmprPj.isEmpty()) {
                showToast("O nome não pode estar vazio.");
                return;
            }

            if (emailEmprPj.isEmpty()) {
                showToast("O email não pode estar vazio.");
                return;
            }

            if (!telefEmprPj.matches("\\d{13}")) {
                showToast("O telefone deve conter exatamente 13 dígitos numéricos.");
                return;
            }

            if (!cnpjEmprPj.matches("\\d{14}")) {
                showToast("O CNPJ deve conter exatamente 14 dígitos numéricos.");
                return;
            }

            viewModelPj.setNomeEmpresa(nomeEmprPj);
            viewModelPj.setEmail(emailEmprPj);
            viewModelPj.setTelefone(telefEmprPj);
            viewModelPj.setCnpj(cnpjEmprPj);

            if (getActivity() != null) {
                com.ducks.vai_pra_onde.Geral.TelasFront.FragmentManagerHelper.replaceFragment((AppCompatActivity) getActivity(), new TelaCadasPJ2());
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.LayoutCadasPJ1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
