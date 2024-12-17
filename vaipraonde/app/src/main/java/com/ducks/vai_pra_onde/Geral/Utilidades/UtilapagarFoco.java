package com.ducks.vai_pra_onde.Geral.Utilidades;

import android.view.View;
import android.widget.EditText;

public class UtilapagarFoco {
    public void apagarTextoAoFocar(EditText editText) {
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    editText.setText(""); // Limpa o texto quando o EditText recebe foco
                }
            }
        });
    }
}
