package com.ducks.vai_pra_onde.Geral.SERVICE.FrontEndSERVICE;

import com.ducks.vai_pra_onde.Geral.DAO.Carregamentos.DownloadEventos;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;

public class AtualizarListaSERVICE {
    public static void atualizarLista(PessoaPJ pessoaLogada) {
        DownloadEventos.carregarEventos(pessoaLogada).thenAccept(listaEventosAtualizada -> {
            /* Chamar a tela "TelaInicial" e passar como parametros
               o objeto "pessoaLogada" e "listaEventosAtualizada"
             */
        });
    }
}
