package com.ducks.vai_pra_onde.Geral.novaSERVICE;

import com.ducks.vai_pra_onde.Geral.DAO.Carregamentos.DownloadEventos;
import com.ducks.vai_pra_onde.Geral.DAO.Verificacoes.VerificarLogin;

public class LoginSERVICE {
    public static void login(String email, String senha) {
        VerificarLogin.validarLogin(email, senha).thenAccept(pessoaJuridica -> {
            if(pessoaJuridica != null) {
                DownloadEventos.carregarEventos(pessoaJuridica).thenAccept(listaEventos -> {
                    // metodo FRONT END
                    // abrirTela_PerfilEmpresa(pessoaJuridica, listaEventos);
                });
            }
            else {
                // metodo() do Front-End para exibir mensagem:
                // "Falha ao efetuar Login! Email ou senha invalidos."
            }
        });
    }
}
