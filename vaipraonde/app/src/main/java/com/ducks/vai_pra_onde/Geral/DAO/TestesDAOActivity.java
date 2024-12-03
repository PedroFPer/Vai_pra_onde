package com.ducks.vai_pra_onde.Geral.DAO;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ducks.vai_pra_onde.Geral.DAO.ObjectsTest.PessoaFisicaTEST;
import com.ducks.vai_pra_onde.R;

public class TestesDAOActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_testes_daoactivity);

        PessoaFisicaTEST pessoaSERVICE = new PessoaFisicaTEST("Green Day", "1999-12-02",
        "I_Hate@gmail.com","Everything about you", "88598758111" );
        PessoaFisicaDAO.cadastrar(pessoaSERVICE).thenAccept(sucessoCadastro -> {
            if(sucessoCadastro) {
                Log.d("TestesDAOActivity", "Cadastro realizado com sucesso!");
            }
            else {
                Log.d("TestesDAOActivity", "Falha no cadastro!");
            }
        });

        /*PessoaFisicaDAO.buscar("HailMary@RunQuickSee.com").thenAccept(pessoaBuscada -> {
            if (pessoaBuscada != null) {
                Log.d("TestesDAOActivity", pessoaBuscada.toString());
            } else {
                Log.d("TestesDAOActivity", "e-mail invalido!");
            }
        }).exceptionally(e -> {
            Log.e("TestesDAOActivity", e.getMessage());
            return null;
        });*/
    }
}