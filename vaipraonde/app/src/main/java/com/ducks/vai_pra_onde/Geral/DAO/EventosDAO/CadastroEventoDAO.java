package com.ducks.vai_pra_onde.Geral.DAO.EventosDAO;

import android.content.Context;

import com.ducks.vai_pra_onde.Geral.DAO.ConnectionDB;
import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class CadastroEventoDAO {
    public static CompletableFuture<Boolean> cadastrar(Eventos evento) {
            FirebaseFirestore connection = ConnectionDB.connect();
        CompletableFuture<Boolean> valorBooleano = new CompletableFuture<>();
        Map<String, Object> eventoCadastro = new HashMap<>();

        eventoCadastro.put("nomeEvento", evento.getNomeEvento());
        eventoCadastro.put("nomeEmpresa", evento.getNomeEmpresa());
        eventoCadastro.put("codigoDocumentoEmpresa", evento.getCodigoDocumentoEmpresa());
        eventoCadastro.put("descricao", evento.getDescricao());
        eventoCadastro.put("email", evento.getEmail());
        eventoCadastro.put("telefone",evento.getTelefone());
        eventoCadastro.put("logradoduro", evento.getLogradouro());
        eventoCadastro.put("bairro", evento.getBairro());
        eventoCadastro.put("cidade", evento.getCidade());
        eventoCadastro.put("estado", evento.getEstado());
        eventoCadastro.put("dataEvento", evento.getDataEvento());

        connection.collection("Eventos").add(eventoCadastro)
                .addOnSuccessListener(documentoCriado -> {

                    valorBooleano.complete(true);
                })
                .addOnFailureListener(e -> {
                    valorBooleano.complete(false);
                });
        return valorBooleano;
    }
}
