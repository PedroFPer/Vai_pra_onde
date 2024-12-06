package com.ducks.vai_pra_onde.Geral.DAO.Validacoes;

import com.ducks.vai_pra_onde.Geral.DAO.ConnectionDB;
import com.ducks.vai_pra_onde.Geral.DAO.ObjectsTest.PessoaFisicaTEST;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.CompletableFuture;

public class Login {
    public static CompletableFuture<Boolean> loginPessoaFisica(String email, String senhaArgumentada) {
        FirebaseFirestore connection = ConnectionDB.connect();
        CompletableFuture<Boolean> future = new CompletableFuture<>();

        connection.collection("PessoaFisica").whereEqualTo("email", email).get()
                .addOnSuccessListener(documentosQUERY -> {
                    if(!documentosQUERY.isEmpty()) {
                        DocumentSnapshot documento =documentosQUERY.getDocuments().get(0);
                        String senhaCorreta = documento.getString("senha");
                        if(senhaCorreta.equals(senhaArgumentada)) {
                            future.complete(true); // senha casa com o email
                        }
                        else {
                            future.complete(false); // senha nao casa com o email argumentado
                        }
                    }
                    else {
                        future.complete(false); // email nao encontrado
                    }
                })
                .addOnFailureListener(e -> {
                    future.complete(false); // excecao lancada quando ocorre um problema na API
                });
        return future;
    }
    /*public static CompletableFuture<Boolean> loginPessoaJuridica(String email, , String cnpj, String senhaArgumentada) {
        // validar loginPessoaJuridica
    }*/
}
