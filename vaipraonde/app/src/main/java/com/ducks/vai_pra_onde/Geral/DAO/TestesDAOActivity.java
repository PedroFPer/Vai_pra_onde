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

        PessoaFisicaTEST pessoaSERVICE = new PessoaFisicaTEST("Notorius B.I.G", "1972-12-02",
        "Party_And_Bullshit@GofuckYou.com","Who Shot Ya?", "88981658971" );

        PessoaFisicaDAO.cadastrar(pessoaSERVICE);

        /*try {
            PessoaFisicaTEST pessoaBuscada = PessoaFisicaDAO.buscar("HibrydMoments@hotmail.com").get();
            if(pessoaBuscada != null) {
                Log.d("TestesDAOActivity", pessoaBuscada.toString());
            }
            else {
                Log.d("TestesDAOActivity", "Email Invalido!");
            }
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }*/
    }
}