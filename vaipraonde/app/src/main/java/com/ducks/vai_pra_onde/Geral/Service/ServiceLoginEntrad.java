package com.ducks.vai_pra_onde.Geral.Service;

import com.ducks.vai_pra_onde.Geral.DAO.Validacoes.Login;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ServiceLoginEntrad {

    public HashMap<String, Object> serviceLoginPF(String email, String senha) {
        try {
            return Login.loginPessoaFisica(email, senha).get();
        }
        catch(InterruptedException | ExecutionException e) {
            return null;
        }
    }

    //Metodo para verificar e puxar o objeto pessoal PJ
    /*public HashMap<String, Object> serviceLoginPJ(String email, String senha) {
        try {
            return Login.loginPessoaJuridica(email, senha).get();
        }
        catch(InterruptedException | ExecutionException e) {
            return null;
        }
    }*/

}
