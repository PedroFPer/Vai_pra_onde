package com.ducks.vai_pra_onde.Geral.TelasFront;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ducks.vai_pra_onde.Geral.Service.ServiceCadastro;
import com.ducks.vai_pra_onde.Geral.Service.ServiceLoginEntrad;
import com.ducks.vai_pra_onde.Geral.Utilidades.UtilVericCreden;
import com.ducks.vai_pra_onde.R;

import java.util.concurrent.CompletableFuture;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_inicial);

        UtilVericCreden utilVericCreden = new UtilVericCreden();
        ServiceLoginEntrad serviceLoginEntrad = new ServiceLoginEntrad ();

        EditText editTextEmail = findViewById(R.id.textLogin);
        EditText editTextSenha = findViewById(R.id.textSenha);



        Button buttonInicLogin = findViewById(R.id.BotaoCadas);
        buttonInicLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String emailLogin = editTextEmail.getText().toString().trim();
                String senhaLogin = editTextSenha.getText().toString().trim();

                if(emailLogin.isEmpty()){
                    //Adicionar mensagem
                    return;
                }

                if(senhaLogin.isEmpty()){
                    //Adicionar mensagem
                    return;
                } else if (!utilVericCreden.vericSenha(senhaLogin)) {
                    //Adicionar Mensagem
                    return;
                }

                //CompletableFuture<Boolean> vericCred = serviceLoginEntrad.serviceLogin(emailLogin,senhaLogin);



                Intent intent = new Intent(TelaInicial.this, PerfilTeste.class);
                startActivity(intent);
            }
        });




        Button buttonLogin = findViewById(R.id.BotaoLoginIni);

        buttonInicLogin.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaInicial.this, TelaCadasTipCli.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}