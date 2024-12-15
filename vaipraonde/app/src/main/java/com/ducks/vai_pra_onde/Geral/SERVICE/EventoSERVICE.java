package com.ducks.vai_pra_onde.Geral.SERVICE;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.ducks.vai_pra_onde.Geral.DAO.EventosDAO.CadastroEventoDAO;
import com.ducks.vai_pra_onde.Geral.DAO.EventosDAO.DeletarEventoDAO;
import com.ducks.vai_pra_onde.Geral.DAO.EventosDAO.EditarEventoDAO;
import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;

public class EventoSERVICE {
    public static void cadastrarEvento( Context context,Eventos evento) {
        CadastroEventoDAO.cadastrar(evento).thenAccept(sucessoCadastro -> {
           if(sucessoCadastro) {
               Toast.makeText(context, "Evento Cadastro", Toast.LENGTH_SHORT).show();
               Log.d("TestesDAOActivity", "EVENTO CRIADO COM SUCESSO!");
           }
           else {
               Toast.makeText( context, "Cadastro evento não concluido", Toast.LENGTH_SHORT).show();
               Log.d("TestesDAOActivity", "Erro, evento não cadastrado");
           }
        });
    }

    public static void editarEvento(Eventos evento) {
        EditarEventoDAO.editar(evento).thenAccept(sucessoUpdate -> {
            if(sucessoUpdate) {
                // dialog-box para exibir que o evento foi atualizado com sucesso
                Log.d("TestesDAOActivity", "EVENTO ATUALIZADO COM SUCESSO!");
            }
            else {
                // dialog-box para indicar falha na atualizacao do evento
                Log.d("TestesDAOActivity", "FALHA AO ATUALIZAR");
            }
        });
    }

    public static void deletarEvento(Eventos evento) {
        DeletarEventoDAO.deletar(evento).thenAccept(sucessoDelete -> {
            if(sucessoDelete) {
                // dialog-box para exibir que o evento foi DELETADO com sucesso
                Log.d("TestesDAOActivity", "EVENTO DELETADO COM SUCESSO!");
            }
            else {
                // dialog-box para indicar falha ao deletar o evento
                Log.d("TestesDAOActivity", "FALHA AO DELETAR");
            }
        });
    }
}
