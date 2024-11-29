package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ducks.vai_pra_onde.R;

public class TelaLoginTipCli extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_login_tip_cli);

        //Botão cadastro PJ

        Button buttonInicLogin = findViewById(R.id.BotaoCadasTipDon);
        buttonInicLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaLoginTipCli.this, TelaCadasGeralPJ.class);
                startActivity(intent);
            }
        });









        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void cadaspf(View v){
        Intent i = new Intent(TelaLoginTipCli.this, TelaCadaspf.class);
        startActivity(i);
    }
}