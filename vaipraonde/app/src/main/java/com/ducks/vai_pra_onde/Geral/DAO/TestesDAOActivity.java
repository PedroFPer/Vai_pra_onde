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
import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;
import com.ducks.vai_pra_onde.Geral.novaSERVICE.CadastroSERVICE;
import com.ducks.vai_pra_onde.Geral.novaSERVICE.EventoSERVICE;
import com.ducks.vai_pra_onde.R;

import java.util.concurrent.ExecutionException;

public class TestesDAOActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_testes_daoactivity);
        // TESTAR:
        //CADASTRO, UPDATE E DELETE de Eventos SERVICE + DAO
    }
}