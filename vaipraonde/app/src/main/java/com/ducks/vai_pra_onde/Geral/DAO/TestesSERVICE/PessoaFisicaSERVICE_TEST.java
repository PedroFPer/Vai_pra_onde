package com.ducks.vai_pra_onde.Geral.DAO.TestesSERVICE;

import com.ducks.vai_pra_onde.Geral.DAO.ObjectsTest.PessoaFisicaTEST;
import com.ducks.vai_pra_onde.Geral.DAO.PessoaFisicaDAO;

import java.util.concurrent.ExecutionException;

public class PessoaFisicaSERVICE_TEST {
    public static boolean cadastroSERVICE(PessoaFisicaTEST pessoaSERVICE) {
        try {
            return PessoaFisicaDAO.cadastrar(pessoaSERVICE).get(); // bloqueio da thread principal
        }
        catch(InterruptedException | ExecutionException e) {
            return false;
        }
    }
}
