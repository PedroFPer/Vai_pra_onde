package com.ducks.vai_pra_onde.Geral.DAO.Verificacoes;

import com.ducks.vai_pra_onde.Geral.DAO.ConnectionDB;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.CompletableFuture;

public class VerificarLogin {
    public static CompletableFuture<PessoaPJ> validarLogin(String email, String senha) {
        FirebaseFirestore connection = ConnectionDB.connect();
        CompletableFuture<PessoaPJ> pessoa = new CompletableFuture<>();
        connection.collection("PessoaJuridica").whereEqualTo("email", email).get()
                .addOnSuccessListener(documentoQuery -> {
                    if(!documentoQuery.isEmpty()) {
                        DocumentSnapshot documento = documentoQuery.getDocuments().get(0);
                        if(documento.getString("senha").equals(senha)) {
                            PessoaPJ pessoaPJConta = new PessoaPJ(documento.getString("nomeEmpresa"), documento.getString("nomeEmpresario"),
                            documento.getString("cpfEmpresario"), documento.getString("senha"), documento.getString("logradouro"),
                            documento.getString("bairro"), documento.getString("cidade"), documento.getString("estado"),
                            documento.getString("cnpj"), documento.getString("email"), documento.getId());
                            pessoa.complete(pessoaPJConta);
                        }
                        else {
                            pessoa.complete(null); // senha e email nao casam
                        }
                    }
                    else {
                        pessoa.complete(null); // email nao existe
                    }
                });
        return pessoa;
    }
}
