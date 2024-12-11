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
        
        pessoa.put("nomeEmpresa", pessoaJuridica.getNomeEmpresa());
        pessoa.put("nomeEmpresario", pessoaJuridica.getNomeEmpresario());
        pessoa.put("cpfEmpresario", pessoaJuridica.getCpfEmpresario());
        pessoa.put("senha", pessoaJuridica.getSenha());
        pessoa.put("logradouro", pessoaJuridica.getLogradouro());
        pessoa.put("bairro", pessoaJuridica.getBairro());
        pessoa.put("cidade", pessoaJuridica.getCidade());
        pessoa.put("estado", pessoaJuridica.getEstado());
        pessoa.put("cnpj", pessoaJuridica.getCnpj());
        pessoa.put("email", pessoaJuridica.getEmail());
        pessoa.put("telefone", pessoaJuridica.getTelefone());

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
