package com.ducks.vai_pra_onde.Geral.novaSERVICE;
// apagar esse import depois (usado para testes)
import android.util.Log;

import com.ducks.vai_pra_onde.Geral.DAO.PessoaJuridicaDAO.CadastroDAO;
import com.ducks.vai_pra_onde.Geral.DAO.Verificacoes.VerificarCadastro;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;

public class
CadastroSERVICE {
    public static void executarVerificacao(PessoaPJ pessoa) {
        VerificarCadastro.verificaDadosUnique(pessoa.getCnpj(), pessoa.getEmail())
                .thenAccept(sucessoVerificacao -> {
                    if(sucessoVerificacao) {
                        CadastroDAO.cadastrar(pessoa).thenAccept(sucessoCadastro -> {
                            if(sucessoCadastro) {
                                // metodo() do front end que exibe mensagem:
                                // "Usuario cadastrado com sucesso!"
                                Log.d("TestesDAOActivity", "USUARIO CADASTRADO COM SUCESSO!");
                            }
                            else {
                                // metodo() do front end que exibe mensagem de erro:
                                // "Erro ao cadastrar, tente novamente"
                                Log.d("TestesDAOActivity", "ERRO NO BANCO DE DADOS");
                            }
                        });
                    }
                    else {
                        // metodo() do front end que exibe mensagem de erro:
                        // "Erro ao cadastrar, tente novamente"
                        Log.d("TestesDAOActivity", "ERRO: EMAIL OU CNPJ JA EXISTEM");
                    }
                });
    }
}
