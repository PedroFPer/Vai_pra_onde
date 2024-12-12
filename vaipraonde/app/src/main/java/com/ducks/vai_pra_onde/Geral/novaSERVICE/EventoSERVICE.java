package com.ducks.vai_pra_onde.Geral.novaSERVICE;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.ducks.vai_pra_onde.Geral.DAO.EventosDAO.CadastroEventoDAO;
import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;

public class EventoSERVICE {
    public static void cadastrarEvento(Context context, Eventos evento) {
        CadastroEventoDAO.cadastrar(evento).thenAccept(sucessoCadastro -> {
           if(sucessoCadastro) {
               Toast.makeText(context, "Evento Cadastro", Toast.LENGTH_SHORT).show();
               Log.d("TestesDAOActivity", "EVENTO CRIADO COM SUCESSO!");
           }
           else {
               // metodo() do front end que exibe mensagem de erro:
               // "Erro ao cadastrar evento, tente novamente"
               Log.d("TestesDAOActivity", "Erro, evento não cadastrado");
           }
        });
    }
}
