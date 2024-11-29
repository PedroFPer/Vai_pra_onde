package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ducks.vai_pra_onde.R;

public class TelaCadaspf extends AppCompatActivity {

    private EditText email, telefone, senha, data, nome, sobrenome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_cadaspf);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        email = findViewById(R.id.email);
        telefone = findViewById(R.id.tel);
        senha = findViewById(R.id.senha);
        data = findViewById(R.id.data);
        nome = findViewById(R.id.nome);
        sobrenome = findViewById(R.id.sobrenome);

    }

    public void cadastro(View v){
        String emailst = email.getText().toString();
        String telefonest = telefone.getText().toString();
        String senhast = senha.getText().toString();
        String nomest = nome.getText().toString();
        String sobrenomest = sobrenome.getText().toString();

        if(emailst.isEmpty()){
            Toast.makeText(this, "O e-mail não pode estar vazio.", Toast.LENGTH_SHORT).show();

        }
        if(telefonest.isEmpty() ){
            Toast.makeText(this, "O telefone não pode estar vazio.", Toast.LENGTH_SHORT).show();

        }
        if(senhast.isEmpty()){
            Toast.makeText(this, "A senha não pode estar vazio.", Toast.LENGTH_SHORT).show();

        }
        if(nomest.isEmpty()){
            Toast.makeText(this, "O nome não pode estar vazio.", Toast.LENGTH_SHORT).show();

        }
        if(sobrenomest.isEmpty()){
            Toast.makeText(this, "O sobrenome não pode estar vazio.", Toast.LENGTH_SHORT).show();

        }


    }
}