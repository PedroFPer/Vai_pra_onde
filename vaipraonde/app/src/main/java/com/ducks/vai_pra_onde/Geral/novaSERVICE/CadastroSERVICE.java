package com.ducks.vai_pra_onde.Geral.novaSERVICE;
// apagar esse import depois (usado para testes)
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.ducks.vai_pra_onde.Geral.DAO.PessoaJuridicaDAO.CadastroDAO;
import com.ducks.vai_pra_onde.Geral.DAO.Verificacoes.VerificarCadastro;
import com.ducks.vai_pra_onde.Geral.TelasFront.TelaCadasPJ4;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;

public class
CadastroSERVICE {
    public static void executarVerificacao(Context context, PessoaPJ pessoa) {
        VerificarCadastro.verificaDadosUnique(pessoa.getCnpj(), pessoa.getEmail())
                .thenAccept(sucessoVerificacao -> {
                    if(sucessoVerificacao) {
                        CadastroDAO.cadastrar(pessoa).thenAccept(sucessoCadastro -> {
                            if(sucessoCadastro) {
                                Toast.makeText(context, "Usuario cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                                Log.d("TestesDAOActivity", "USUARIO CADASTRADO COM SUCESSO!");
                            }
                            else {
                                Toast.makeText(context, "Ocorreu um erro no cadastro, por favor tente novamente", Toast.LENGTH_SHORT).show();
                                Log.d("TestesDAOActivity", "ERRO NO BANCO DE DADOS");
                            }
                        });
                    }
                    else {
                        Toast.makeText(context, "Ocorreu um erro no cadastro, por favor tente novamente", Toast.LENGTH_SHORT).show();
                        Log.d("TestesDAOActivity", "ERRO: EMAIL OU CNPJ JA EXISTEM");
                    }
                });
    }
}
