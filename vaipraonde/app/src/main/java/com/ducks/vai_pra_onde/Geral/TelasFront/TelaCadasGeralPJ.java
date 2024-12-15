package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


import com.ducks.vai_pra_onde.R;

public class TelaCadasGeralPJ extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tela_cadas_geral_pj);


            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragContCadasPJ, new TelaCadasPJ1())
                        .commit();
            }
        }

    }

