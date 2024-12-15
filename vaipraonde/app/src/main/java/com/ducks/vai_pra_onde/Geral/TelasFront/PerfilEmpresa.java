package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ducks.vai_pra_onde.Geral.FragmeViewModel.FragmeSessaoPessoaPJViewModel;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;
import com.ducks.vai_pra_onde.R;

public class PerfilEmpresa extends Fragment {

    private FragmeSessaoPessoaPJViewModel viewModelSessaoPJ;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_perfil_empresa, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelSessaoPJ = new ViewModelProvider(requireActivity()).get(FragmeSessaoPessoaPJViewModel.class);

        TextView editNom = view.findViewById(R.id.nome);
        TextView editEmai = view.findViewById(R.id.email);

        Button buttonListEven = view.findViewById(R.id.listaEventos);

        PessoaPJ pessoaPJ = viewModelSessaoPJ.getPessoaPJ();

        if (pessoaPJ != null) {
            editNom.setText(pessoaPJ.getNomeEmpresa());
            editEmai.setText(pessoaPJ.getEmail());
        } else {
            Log.e("PerfilEmpresa", "PessoaPJ não encontrada");

        }

        buttonListEven.setOnClickListener(v->{
            if (getActivity() != null) {
                AppCompatActivity activity = (AppCompatActivity) getActivity();
                // Realiza a transação para substituir o fragmento
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragSessaoPJ, new TelaListadeEventos()) // Aqui você substitui o fragmento pelo novo
                        .addToBackStack(null) // Adiciona ao back stack para permitir navegação para trás
                        .commit();
            }
                });

    }
}
