package com.ducks.vai_pra_onde.Geral.TelasFront;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

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

        public void replaceFragment(Fragment fragment) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragContCadasPJ, fragment)
                    .addToBackStack(null) // Adiciona à pilha para permitir voltar
                    .commit();
        }
    }

