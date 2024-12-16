package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ducks.vai_pra_onde.Geral.FragmeViewModel.FragmeSessaoPessoaPJViewModel;
import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;
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
        float density = getResources().getDisplayMetrics().density;

        // Processar listaEventos se existir
        if (listaEventos != null && !listaEventos.isEmpty()) {
            adicionarEventos(listaEventos, density);
        }

        // Exibir ou esconder a mensagem de "Nenhum evento"
        if (eventContainer.getChildCount() > 0) {
            noEventMessage.setVisibility(View.GONE);
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
    }

    private void adicionarEventosDeTeste(ArrayList<String> teste, float density) {
        int largura = (int) (330 * density);
        int altura = (int) (70 * density);

        for (String s : teste) {
            Button itemEvento = new Button(getActivity());

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(largura, altura);
            params.setMargins(0, 10, 0, 10);

            itemEvento.setLayoutParams(params);
            itemEvento.setBackgroundResource(R.drawable.borda_preta);
            itemEvento.setText("Nome: " + s);
            itemEvento.setTextColor(getResources().getColor(R.color.black));
            itemEvento.setTextSize(18);

            // Adicionar funcionalidade ao botão
            itemEvento.setOnClickListener(v -> {
                System.out.println("Botão clicado: " + s);
            });

            eventContainer.addView(itemEvento);
        }
    }

    private void adicionarEventos(ArrayList<Eventos> listaEventos, float density) {
        int largura = (int) (330 * density);
        int altura = (int) (70 * density);

        for (Eventos evento : listaEventos) {
            Button itemEvento = new Button(getActivity());

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(largura, altura);
            params.setMargins(0, 10, 0, 10);

            itemEvento.setLayoutParams(params);
            itemEvento.setBackgroundResource(R.drawable.borda_preta);
            itemEvento.setText(evento.getDataEvento() + " | " + evento.getNomeEvento());
            itemEvento.setTextColor(getResources().getColor(R.color.black));
            itemEvento.setTextSize(18);

            // Adicionar funcionalidade ao botão
            itemEvento.setOnClickListener(v -> {
                System.out.println("Botão clicado: " + evento.getNomeEvento());
            });

            eventContainer.addView(itemEvento);
        }
    }
}
