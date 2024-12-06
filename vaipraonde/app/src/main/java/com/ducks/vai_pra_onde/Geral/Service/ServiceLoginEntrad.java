package com.ducks.vai_pra_onde.Geral.Service;

import com.ducks.vai_pra_onde.Geral.DAO.Validacoes.Login;

import java.util.concurrent.CompletableFuture;

public class ServiceLoginEntrad {
    public CompletableFuture<Boolean> serviceLogin(String email, String senha){
        Login loginEntrad = new Login();
        CompletableFuture<Boolean> vericCred = loginEntrad.loginPessoaFisica(email,senha);

        return vericCred;
    }
}
