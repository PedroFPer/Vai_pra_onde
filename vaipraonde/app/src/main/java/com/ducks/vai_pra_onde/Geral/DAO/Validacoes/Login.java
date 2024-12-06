package com.ducks.vai_pra_onde.Geral.DAO.Validacoes;

import com.ducks.vai_pra_onde.Geral.DAO.ConnectionDB;
import com.ducks.vai_pra_onde.Geral.DAO.ObjectsTest.PessoaFisicaTEST;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Login {
    public static CompletableFuture<HashMap<String, Object>> loginPessoaFisica(String email, String senhaArgumentada) {
        FirebaseFirestore connection = ConnectionDB.connect();
        CompletableFuture<HashMap<String, Object>> future = new CompletableFuture<>();

        connection.collection("PessoaFisica").whereEqualTo("email", email).get()
                .addOnSuccessListener(documentosQUERY -> {
                    if(!documentosQUERY.isEmpty()) {
                        DocumentSnapshot documento =documentosQUERY.getDocuments().get(0);
                        String senhaCorreta = documento.getString("senha");

                        if(senhaCorreta.equals(senhaArgumentada)) {
                            HashMap<String, Object> pessoaFisica = new HashMap<>();
                            pessoaFisica.put("nome", documento.getString("nome"));
                            pessoaFisica.put("data_nascimento", new java.text.SimpleDateFormat("yyyy-MM-dd").format(documento.getDate("data_nascimento")));
                            pessoaFisica.put("email", documento.getString("email"));
                            pessoaFisica.put("telefone", documento.getString("telefone"));
                            pessoaFisica.put("senha", documento.getString("senha"));
                            pessoaFisica.put("documentoID", documento.getId());

                            future.complete(pessoaFisica); // senha casa com o email
                        }
                        else {
                            future.complete(null); // senha nao casa com o email argumentado
                        }
                    }
                    else {
                        future.complete(null); // email nao encontrado
                    }
                })
                .addOnFailureListener(e -> {
                    future.complete(null); // excecao lancada quando ocorre um problema na API
                });
        return future;
    }
    /*public static CompletableFuture<HashMap<String, Object>> loginPessoaJuridica(String email, , String cnpj, String senhaArgumentada) {
        // validar loginPessoaJuridica
    }*/
}
