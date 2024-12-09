package com.ducks.vai_pra_onde.Geral.DAO.PessoaJuridicaDAO;

import com.ducks.vai_pra_onde.Geral.DAO.ConnectionDB;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class CadastroDAO {
    public static CompletableFuture<Boolean> cadastrar(PessoaPJ pessoaJuridica) {
        FirebaseFirestore connection = ConnectionDB.connect();
        CompletableFuture<Boolean> valorBooleano = new CompletableFuture<>();
        Map<String, Object> pessoa = new HashMap<>();

        // por enquanto, vou adicionar apenas cnpj e email
        // para testes
        pessoa.put("cnpj", pessoaJuridica.getCnpj());
        pessoa.put("email", pessoaJuridica.getEmail());

        connection.collection("PessoaJuridica").add(pessoa)
                .addOnSuccessListener(documentoCriado -> {
                    valorBooleano.complete(true);
                })
                .addOnFailureListener(e -> {
                    valorBooleano.complete(false);
                });
        return valorBooleano;
    }
}
