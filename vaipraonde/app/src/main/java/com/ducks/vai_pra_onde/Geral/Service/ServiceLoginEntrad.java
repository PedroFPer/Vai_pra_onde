package com.ducks.vai_pra_onde.Geral.Service;

import com.ducks.vai_pra_onde.Geral.DAO.Validacoes.Login;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ServiceLoginEntrad {
    /*public CompletableFuture<Boolean> serviceLogin(String email, String senha){
        Login loginEntrad = new Login();
        CompletableFuture<Boolean> vericCred = loginEntrad.loginPessoaFisica(email,senha);

        return vericCred;
    }*/
    public HashMap<String, Object> serviceLogin(String email, String senha) {
        try {
            return Login.loginPessoaFisica(email, senha).get();
        }
        catch(InterruptedException | ExecutionException e) {
            return null;
        }
    }

}
