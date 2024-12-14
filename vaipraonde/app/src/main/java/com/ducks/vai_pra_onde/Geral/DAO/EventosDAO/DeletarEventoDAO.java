package com.ducks.vai_pra_onde.Geral.DAO.EventosDAO;

import com.ducks.vai_pra_onde.Geral.DAO.ConnectionDB;
import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.CompletableFuture;

public class DeletarEventoDAO {
    public static CompletableFuture<Boolean> deletar(Eventos evento) {
        FirebaseFirestore connection = ConnectionDB.connect();
        CompletableFuture<Boolean> retornoBooleano = new CompletableFuture<>();
        connection.collection("Eventos").document(evento.getCodigoDocumento()).delete()
                .addOnSuccessListener(voidReturn -> {
                    retornoBooleano.complete(true);
                })
                .addOnFailureListener(e -> {
                   retornoBooleano.complete(false);
                });
        return retornoBooleano;
    }
}
