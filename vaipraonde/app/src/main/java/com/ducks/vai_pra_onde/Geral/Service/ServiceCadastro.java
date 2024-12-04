package com.ducks.vai_pra_onde.Geral.Service;

import com.ducks.vai_pra_onde.Geral.DAO.PessoaFisicaDAO;
import com.ducks.vai_pra_onde.Geral.DTO.CadasPessoPfDTO;

 /*LEIA:
a importacao abaixo "com.ducks.vai_pra_onde.Geral.DAO.ObjectsTest.PessoaFisicaTEST"
devera ser apagada posteriormente, sendo adicionada nesta classe apenas para teste
*/
//OBS: 'CadasPessoaPfDTO' deve substituir 'PessoaFisicaTEST'

import com.ducks.vai_pra_onde.Geral.DAO.ObjectsTest.PessoaFisicaTEST;

import java.util.concurrent.ExecutionException;


public class ServiceCadastro {
    public boolean serviceCadastroPf(CadasPessoPfDTO cadasPessoPfDTO){

        //boolean veriCadastro =(Metodo DAO de cadastro que returnar um valor booleano);

        /*if(veriCadastro){
            return true;
        }*/
        return false;
    }

    // solucao 01: preservando a assincronia das threads, sem bloquear a thread principal --> status: FUNCIONAL
    /*public boolean cadastroSERVICE(PessoaFisicaTEST pessoaSERVICE) { // considere 'pessoaSERVICE' um objeto tratado
        boolean resultadoOperacao = false; //INVIAVEL
        PessoaFisicaDAO.cadastrar(pessoaSERVICE).thenAccept(sucessoCadastro -> {
            if(sucessoCadastro) {
                //resultadoOperacao = true; INVIAVEL
            }
            else {
                //resultadoOperacao = false; INVIAVEL
            }
        });
        return resultadoOperacao; //INVIAVEL
    }*/

    // solucao 02: BLOQUEANDO a thread principal --> status: FUNCIONAL
    /*public boolean cadastroSERVICE(PessoaFisicaTEST pessoaSERVICE) {
        try {
            return PessoaFisicaDAO.cadastrar(pessoaSERVICE).get(); // bloqueio da thread principal
        }
        catch(InterruptedException | ExecutionException e) {
            //Log.e("TELA_QUE_REALIZA_O_CADASTRO", "Erro durante o cadastro: " + e.getMessage());
            return false;
        }
    }*/
}
