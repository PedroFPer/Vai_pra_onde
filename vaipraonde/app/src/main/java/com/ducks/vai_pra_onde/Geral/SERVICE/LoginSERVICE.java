package com.ducks.vai_pra_onde.Geral.SERVICE;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.ducks.vai_pra_onde.Geral.DAO.Carregamentos.DownloadEventos;
import com.ducks.vai_pra_onde.Geral.DAO.Verificacoes.VerificarLogin;
import com.ducks.vai_pra_onde.Geral.TelasFront.TelaGeralSessaoPJ;
import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;

public class LoginSERVICE {
    public static void login(Context context, String email, String senha) {
        VerificarLogin.validarLogin(email, senha).thenAccept(pessoaJuridica -> {
            if (pessoaJuridica != null) {
                    DownloadEventos.carregarEventos(pessoaJuridica).thenAccept(listaEventos -> {
                        Log.d("LoginService",pessoaJuridica.getTelefone() );
                        Intent intent = new Intent(context, TelaGeralSessaoPJ.class);
                        intent.putExtra("pessoaJuridica", pessoaJuridica);
                        intent.putExtra("FragmentoShow", "PerfilEmpresa");
                        intent.putParcelableArrayListExtra("listaEventos", listaEventos);
                        context.startActivity(intent);
                });
            } else {
                Toast.makeText(context, "Erro no login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
