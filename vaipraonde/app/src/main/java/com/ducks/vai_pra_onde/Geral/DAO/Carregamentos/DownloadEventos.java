package com.ducks.vai_pra_onde.Geral.DAO.Carregamentos;

import com.ducks.vai_pra_onde.Geral.DAO.ConnectionDB;
import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DownloadEventos {
    public static CompletableFuture<ArrayList<Eventos>> carregarEventos(PessoaPJ pessoa) {
        FirebaseFirestore connection = ConnectionDB.connect();
        CompletableFuture<ArrayList<Eventos>> eventosFuture = new CompletableFuture<>();

        connection.collection("Eventos").whereEqualTo("codigoDocumentoEmpresa", pessoa.getCodigoDocumento()).get()
                .addOnSuccessListener(documentoQuery -> {
                    if(!documentoQuery.isEmpty()) {
                        ArrayList<Eventos> listaEventos = new ArrayList<>();

                        List<DocumentSnapshot> documentos = documentoQuery.getDocuments();

                        for(DocumentSnapshot documento : documentos) {
                            Eventos evento = new Eventos(documento.getString("nomeEvento"), documento.getString("nomeEmpresa"),
                            documento.getId(), documento.getString("codigoDocumentoEmpresa"), documento.getString("descricao"),
                            documento.getString("email"), documento.getString("telefone"), documento.getString("logradouro"),
                            documento.getString("bairro"), documento.getString("cidade"), documento.getString("estado"),
                            documento.getDate("dataEvento"));
                            listaEventos.add(evento);
                        }

                        eventosFuture.complete(listaEventos); // ArrayList<Eventos>
                    }
                    else {
                        eventosFuture.complete(null);
                    }
                });
        return eventosFuture;

    }
}
