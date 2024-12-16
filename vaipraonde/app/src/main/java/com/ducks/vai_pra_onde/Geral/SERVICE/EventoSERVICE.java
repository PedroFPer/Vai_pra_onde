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

    public static void editarEvento(Context context,Eventos evento) {
        EditarEventoDAO.editar(evento).thenAccept(sucessoUpdate -> {
            if(sucessoUpdate) {
                Toast.makeText(context, "Evento Editado com Sucesso", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context, "Ocorreu algum problema na edição", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void deletarEvento(Context context,Eventos evento) {
        DeletarEventoDAO.deletar(evento).thenAccept(sucessoDelete -> {
            if(sucessoDelete) {
                Toast.makeText(context, "Evento Deletado com Sucesso", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(context, "Ocorreu algum problema", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
