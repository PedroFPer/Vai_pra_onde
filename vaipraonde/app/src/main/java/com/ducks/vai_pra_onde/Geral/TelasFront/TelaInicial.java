package com.ducks.vai_pra_onde.Geral.TelasFront;


import static java.security.AccessController.getContext;

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

import com.ducks.vai_pra_onde.Geral.Utilidades.UtilVericCreden;
import com.ducks.vai_pra_onde.Geral.SERVICE.LoginSERVICE;
import com.ducks.vai_pra_onde.R;

import java.text.BreakIterator;
import java.util.concurrent.CompletableFuture;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_inicial);

        UtilVericCreden utilVericCreden = new UtilVericCreden();

        EditText editTextEmail = findViewById(R.id.textLogin);
        EditText editTextSenha = findViewById(R.id.textSenha);


        Button buttonCadas = findViewById(R.id.BotaoCadas);
        Button buttonLogin = findViewById(R.id.BotaoLoginIni);

        
        editTextEmail.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                if (editTextEmail.getText().toString().equals("Email")) {
                    editTextEmail.setText("");
                }
            }
        });

        editTextSenha.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                if (editTextSenha.getText().toString().equals("Senha")) {
                    editTextSenha.setText("");
                }
            }
        });


        buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String emailLogin = editTextEmail.getText().toString().trim();
                String senhaLogin = editTextSenha.getText().toString().trim();

                if (emailLogin.isEmpty()) {
                    Toast.makeText(TelaInicial.this, "O email não pode estar vazio", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (senhaLogin.isEmpty()) {
                    Toast.makeText(TelaInicial.this, "A senha não pode estar vazio", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!utilVericCreden.vericSenha(senhaLogin)) {
                    Toast.makeText(TelaInicial.this, "A senha deve conter 8 caracteres", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                LoginSERVICE.login(TelaInicial.this,emailLogin,senhaLogin);

            }
        });




        //Botão Cadastro PF

        buttonCadas.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaInicial.this, TelaCadasGeralPJ.class);
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
