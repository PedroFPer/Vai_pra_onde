package com.ducks.vai_pra_onde.Geral.DAO.Verificacoes;

import com.ducks.vai_pra_onde.Geral.DAO.ConnectionDB;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.CompletableFuture;

public class VerificarCadastro {
    public static CompletableFuture<Boolean> verificaDadosUnique(String cnpj, String email) {
        FirebaseFirestore connection = ConnectionDB.connect();
        CompletableFuture<Boolean> verificacao = new CompletableFuture<>();

        connection.collection("PessoaJuridica").whereEqualTo("cnpj",cnpj).get()
                .addOnSuccessListener(documentoCnpjQuery -> {
                    if(!documentoCnpjQuery.isEmpty()) {
                        verificacao.complete(false); // cnpj ja cadastrado
                    }
                    else {
                        connection.collection("PessoaJuridica").whereEqualTo("email", email).get()
                                .addOnSuccessListener(documentoEmailQuery -> {
                                    if(!documentoEmailQuery.isEmpty()) {
                                        verificacao.complete(false); // email ja cadastrado
                                    }
                                    else {
                                        verificacao.complete(true); // email e cnpj validos!
                                    }
                                });
                    }
                });
        return verificacao;
    }
}
