package com.ducks.vai_pra_onde.Geral.Service;

import com.ducks.vai_pra_onde.Geral.DAO.PessoaFisicaDAO;
import com.ducks.vai_pra_onde.Geral.DTO.CadasPessoPfDTO;

/* LEIA:
a importacao abaixo "com.ducks.vai_pra_onde.Geral.DAO.ObjectsTest.PessoaFisicaTEST"
devera ser apagada posteriormente, sendo adicionada nesta classe apenas para teste

OBS: 'CadasPessoaPfDTO' deve substituir 'PessoaFisicaTEST'

import com.ducks.vai_pra_onde.Geral.DAO.ObjectsTest.PessoaFisicaTEST;
*/

public class ServiceCadastro {
    public boolean serviceCadastroPf(CadasPessoPfDTO cadasPessoPfDTO){

        //boolean veriCadastro =(Metodo DAO de cadastro que returnar um valor booleano);

        /*if(veriCadastro){
            return true;
        }*/
        return false;
    }

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
}
