package com.ducks.vai_pra_onde.Geral.novaSERVICE;

import android.util.Log;

import com.ducks.vai_pra_onde.Geral.DAO.EventosDAO.CadastroEventoDAO;
import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;

public class EventoSERVICE {
    public static void cadastrarEvento(Eventos evento) {
        CadastroEventoDAO.cadastrar(evento).thenAccept(sucessoCadastro -> {
           if(sucessoCadastro) {
               // metodo() do front end que exibe mensagem:
               // "Evento criado com sucesso!"
               Log.d("TestesDAOActivity", "EVENTO CRIADO COM SUCESSO!");
           }
           else {
               // metodo() do front end que exibe mensagem de erro:
               // "Erro ao cadastrar evento, tente novamente"
               Log.d("TestesDAOActivity", "ERRO NO BANCO DE DADOS");
           }
        });
    }
}
