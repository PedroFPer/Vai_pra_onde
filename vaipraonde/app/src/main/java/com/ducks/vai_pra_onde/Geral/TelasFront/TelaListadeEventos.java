package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.content.Intent; // Import necessário
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;
import com.ducks.vai_pra_onde.R;

import java.util.ArrayList;

public class TelaListadeEventos extends AppCompatActivity {

    private LinearLayout eventContainer;
    private TextView noEventMessage;
    private PessoaPJ pessoaPJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_eventos);

        // Recuperando as Views
        eventContainer = findViewById(R.id.eventContainer);
        noEventMessage = findViewById(R.id.noEventMessage);

        // Recuperando os dados enviados pela Intent
        ArrayList<Eventos> listaUsuarios = getIntent().getParcelableArrayListExtra("listaUsuarios");
        pessoaPJ = getIntent().getParcelableExtra("pessoaJuridica");

        // Populando a tela com os eventos
        configurarEventos(listaUsuarios);

        // Ação ao clicar em criar evento (botão pode ser reativado, se necessário)
        criarNovoEvento();
    }

    /**
     * Configura os eventos na tela.
     *
     * @param listaUsuarios Lista de eventos recebidos pela Intent.
     */
    private void configurarEventos(ArrayList<Eventos> listaUsuarios) {
        // Limpa o container de eventos
        eventContainer.removeAllViews();

        if (listaUsuarios != null && !listaUsuarios.isEmpty()) {
            // Oculta a mensagem de "Nenhum evento disponível"
            noEventMessage.setVisibility(View.GONE);

            // Adiciona cada evento na tela
            for (Eventos evento : listaUsuarios) {
                View eventoView = getLayoutInflater().inflate(R.layout.activity_item_evento, eventContainer, false);

                // Configurando as Views do evento
                TextView eventoNome = eventoView.findViewById(R.id.eventName);
                TextView eventoHorario = eventoView.findViewById(R.id.eventTime);

                // Configuração para exibir dados do evento
                // eventoNome.setText(evento.getNome());
                // eventoHorario.setText(evento.getHorario());

                // Adiciona a View ao container
                eventContainer.addView(eventoView);
            }
        } else {
            // Exibe a mensagem de "Nenhum evento disponível"
            noEventMessage.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Abre a tela para criar um novo evento.
     */
    private void criarNovoEvento() {
        Intent intent = new Intent(this, EventoCadastro.class); // Adicionado evento para abrir a nova tela
        intent.putExtra("PessoaPJ", pessoaPJ);
        startActivity(intent);
    }
}
