package com.ducks.vai_pra_onde.Geral.DAO.EventosDAO;

import com.ducks.vai_pra_onde.Geral.DAO.ConnectionDB;
import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.CompletableFuture;

public class EditarEventoDAO {
    public static CompletableFuture<Boolean> editar(Eventos evento) {
        FirebaseFirestore connection = ConnectionDB.connect();
        CompletableFuture<Boolean> retornoBooleano = new CompletableFuture<>();
        connection.collection("Eventos").document(evento.getCodigoDocumento())
                .update("dataEvento", evento.getDataEvento(), "horaEvento", evento.getHoraEvento(),
                "minutoEvento", evento.getMinutoEvento(), "nomeEvento", evento.getNomeEvento(), "descricao", evento.getDescricao(),
                "logradouro", evento.getLogradouro(), "bairro", evento.getBairro(), "cidade", evento.getCidade())
                .addOnSuccessListener(operacaoVoid -> {
                    retornoBooleano.complete(true);
                })
                .addOnFailureListener(e -> {
                    retornoBooleano.complete(false);
                });
        return retornoBooleano;
    }
}
