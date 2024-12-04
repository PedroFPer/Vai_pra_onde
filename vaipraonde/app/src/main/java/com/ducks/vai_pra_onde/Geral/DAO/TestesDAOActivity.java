package com.ducks.vai_pra_onde.Geral.DAO;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ducks.vai_pra_onde.Geral.DAO.ObjectsTest.PessoaFisicaTEST;
import com.ducks.vai_pra_onde.Geral.DAO.TestesSERVICE.PessoaFisicaSERVICE_TEST;
import com.ducks.vai_pra_onde.R;

import java.util.concurrent.ExecutionException;

public class TestesDAOActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_testes_daoactivity);

        /*PessoaFisicaTEST pessoaSERVICE = new PessoaFisicaTEST("Lying From You", "1999-12-02",
        "LinkinPark@gmail.com","Metheora", "88598758111" );*/

        // TESTE: BLOQUEANDO A THREAD EM "cadastrar"
        /*if(PessoaFisicaSERVICE_TEST.cadastroSERVICE(pessoaSERVICE)) {
            Log.d("TestesDAOActivity", "Cadastro realizado com sucesso!");
        }
        else {
            Log.d("TestesDAOActivity", "Falha no cadastro!");
        }/*


        /*PessoaFisicaDAO.cadastrar(pessoaSERVICE).thenAccept(sucessoCadastro -> {
            if(sucessoCadastro) {
                Log.d("TestesDAOActivity", "Cadastro realizado com sucesso!");
            }
            else {
                Log.d("TestesDAOActivity", "Falha no cadastro!");
            }
        });*/

        PessoaFisicaDAO.buscar("LinkinPark@gmail.com").thenAccept(pessoaBuscada -> {
            if (pessoaBuscada != null) {
                Log.d("TestesDAOActivity", pessoaBuscada.toString());
            } else {
                Log.d("TestesDAOActivity", "e-mail invalido!");
            }
        }).exceptionally(e -> {
            Log.e("TestesDAOActivity", e.getMessage());
            return null;
        });
    }
}