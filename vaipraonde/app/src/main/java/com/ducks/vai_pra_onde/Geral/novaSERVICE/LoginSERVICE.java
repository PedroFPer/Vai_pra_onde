package com.ducks.vai_pra_onde.Geral.novaSERVICE;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.ducks.vai_pra_onde.Geral.DAO.Carregamentos.DownloadEventos;
import com.ducks.vai_pra_onde.Geral.DAO.Verificacoes.VerificarLogin;
import com.ducks.vai_pra_onde.Geral.TelasFront.TelaCadasGeralPJ;

public class LoginSERVICE {
    public static void login(Context context, String email, String senha) {
        VerificarLogin.validarLogin(email, senha).thenAccept(pessoaJuridica -> {
            if (pessoaJuridica != null) {
                DownloadEventos.carregarEventos(pessoaJuridica).thenAccept(listaEventos -> {
                    Intent intent = new Intent(context, TelaCadasGeralPJ.class);
                    context.startActivity(intent);
                });
            } else {
                Log.d("LoginService", "Deu errado");
                Toast.makeText(context, "Erro no login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
