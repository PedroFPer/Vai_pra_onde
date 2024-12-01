package com.ducks.vai_pra_onde.Geral.DAO;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ducks.vai_pra_onde.R;

public class TestesDAOActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_testes_daoactivity);
       /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        /* abaixo, modifique os campos com os valores desejados
        e a data no formato (yyyy-MM-dd) para realizar o teste de envio
        ao banco de dados na collection PessoaFisica*/
        String nome = "Dani California";
        String dataNascimento = "1999-04-26";
        String email = "SweetLouisiana@gmail.com";
        String telefone = "85989878614";
        String senha = "Red_Hot_Chilli_Peppers";
        PessoaFisicaDAO.cadastrarPF(nome, dataNascimento, email, telefone, senha);
    }
}