package com.ducks.vai_pra_onde.Geral.DAO;

import android.os.Bundle;
import android.util.Log;
import com.ducks.vai_pra_onde.Geral.DAO.Validacoes.Login;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ducks.vai_pra_onde.Geral.DAO.ObjectsTest.PessoaFisicaTEST;
import com.ducks.vai_pra_onde.Geral.DAO.TestesSERVICE.PessoaFisicaSERVICE_TEST;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;
import com.ducks.vai_pra_onde.Geral.novaSERVICE.CadastroSERVICE;
import com.ducks.vai_pra_onde.R;

import java.util.concurrent.ExecutionException;

public class TestesDAOActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_testes_daoactivity);

        // SIMULACAO: CADASTRO DE PESSOA JURIDICA: FRONT END -> DTO -> SERVICE -> BANCO DE DADOS

        // PASSO 1: O objeto PessoaPJ (pacote newDTO) abaixo recebe dados do FRONT END
        //PessoaPJ pessoa = new PessoaPJ("AquilesCIA", "Aquiles", "123456789", "aquilesBonito", "A", "B", "C", "D", "1234", "aquiles@gmail.com");

        // PASSO 2: O objeto PessoaPJ ja preenchido com dados do FRONT END, e passado por uma verificacao
        // se a verificacao ocorrer com sucesso, o usuario e cadastrado e uma mensagem informando isso
        // e exibida
        //CadastroSERVICE.executarVerificacao(pessoa);
    }
}