package com.ducks.vai_pra_onde.Geral.SERVICE.FrontEndSERVICE;

import android.content.Context;
import android.content.Intent;

import com.ducks.vai_pra_onde.Geral.DAO.Carregamentos.DownloadEventos;
import com.ducks.vai_pra_onde.Geral.TelasFront.TelaGeralSessaoPJ;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;

public class AtualizarListaSERVICE {
    public static void atualizarLista(Context context, PessoaPJ pessoaLogada) {
        DownloadEventos.carregarEventos(pessoaLogada).thenAccept(listaEventosAtualizada -> {
            Intent intent = new Intent(context, TelaGeralSessaoPJ.class);
            intent.putExtra("pessoaJuridica", pessoaLogada);
            intent.putExtra("FragmentoShow", "ListaPessoa");
            intent.putParcelableArrayListExtra("listaEventos", listaEventosAtualizada);
            context.startActivity(intent);
        });
    }
}
