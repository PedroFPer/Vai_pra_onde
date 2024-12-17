package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ducks.vai_pra_onde.Geral.FragmeViewModel.FragmeSessaoPessoaPJViewModel;
import com.ducks.vai_pra_onde.Geral.SERVICE.FrontEndSERVICE.AtualizarListaSERVICE;
import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;
import com.ducks.vai_pra_onde.R;

import java.util.ArrayList;

public class TelaListadeEventos extends Fragment {

    private LinearLayout eventContainer;
    private TextView noEventMessage;

    private FragmeSessaoPessoaPJViewModel viewModelSessaoPJ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_lista_de_eventos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonCadasEven = view.findViewById(R.id.btn_criar_evento);

        eventContainer = view.findViewById(R.id.eventContainer);
        noEventMessage = view.findViewById(R.id.noEventMessage);

        viewModelSessaoPJ = new ViewModelProvider(requireActivity()).get(FragmeSessaoPessoaPJViewModel.class);

        ArrayList<Eventos> listaEventos = viewModelSessaoPJ.getListaEventos();
        PessoaPJ pessoaPJ = viewModelSessaoPJ.getPessoaPJ();


        float density = getResources().getDisplayMetrics().density;


        if (listaEventos != null) {
            noEventMessage.setVisibility(View.GONE);
            adicionarEventos(listaEventos, pessoaPJ, density);
        } else {
            noEventMessage.setVisibility(View.VISIBLE);
        }

        buttonCadasEven.setOnClickListener(v -> {
            if (getActivity() != null) {
                AppCompatActivity activity = (AppCompatActivity) getActivity();

                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragSessaoPJ, new TelaCadastroEvento())
                        .addToBackStack(null)
                        .commit();
            }
        });

        requireActivity().getOnBackPressedDispatcher().addCallback(
                getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        if (getActivity() != null) {
                            AppCompatActivity activity = (AppCompatActivity) getActivity();

                            activity.getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.fragSessaoPJ, new PerfilEmpresa())
                                    .addToBackStack(null)
                                    .commit();
                        }
                    }
                }
        );
    }



    private void adicionarEventos(ArrayList<Eventos> listaEventos, PessoaPJ pessoaPJ, float density) {

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int screenWidth = metrics.widthPixels;



        int largura = (int) (screenWidth * 0.73);
        int altura = (int) (70 * density);

        for (Eventos evento : listaEventos) {
            Button itemEvento = new Button(getActivity());

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(largura, altura);
            params.setMargins(0, 10, 0, 10);

            itemEvento.setLayoutParams(params);
            itemEvento.setBackgroundResource(R.drawable.borda_preta);
            itemEvento.setText(evento.getDataEvento().getDay()+"/"+ evento.getDataEvento().getMonth() + " | " + evento.getNomeEvento());
            itemEvento.setPadding(10,1,10,1);
            itemEvento.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
            itemEvento.setTextSize(18);

            // Adicionar funcionalidade ao botão
            itemEvento.setOnClickListener(v -> {
                
                Intent intent = new Intent(getActivity(), TelaCadastroModifEvento.class);
                intent.putExtra("pessoaJuridica", pessoaPJ);
                intent.putExtra("evento", evento);
                startActivity(intent);
                requireActivity().finish();
            });

            eventContainer.addView(itemEvento);
        }
    }
}
