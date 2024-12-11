package com.ducks.vai_pra_onde.Geral.novaSERVICE;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.ducks.vai_pra_onde.Geral.DAO.Carregamentos.DownloadEventos;
import com.ducks.vai_pra_onde.Geral.DAO.Verificacoes.VerificarLogin;
import com.ducks.vai_pra_onde.Geral.TelasFront.PerfilTeste;
import com.ducks.vai_pra_onde.Geral.TelasFront.TelaCadasGeralPJ;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;

import java.util.ArrayList;

public class LoginSERVICE {
    public static void login(Context context, String email, String senha) {
        Log.d("LoginService", "Entrada no metodo login");
        VerificarLogin.validarLogin(email, senha).thenAccept(pessoaJuridica -> {
            Log.d("LoginService", "Está verificando?");
            if (pessoaJuridica != null) {
                Log.d("LoginService", "Conta encontrada?");
                    DownloadEventos.carregarEventos(pessoaJuridica).thenAccept(listaEventos -> {
                        Log.d("LoginService", "Conta encontrada");
                        Intent intent = new Intent(context, PerfilTeste.class);
                        intent.putExtra("pessoaJuridica", pessoaJuridica);
                        intent.putParcelableArrayListExtra("listaEventos", listaEventos);
                        Log.d("LoginService", "Objetos deportados");
                        context.startActivity(intent);
                });
            } else {
                Log.d("LoginService", "Deu errado");
                Toast.makeText(context, "Erro no login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
