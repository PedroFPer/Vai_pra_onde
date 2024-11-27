package com.ducks.vai_pra_onde.Geral.DTO;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.MutableLiveData;

import com.ducks.vai_pra_onde.R;

public class CadastroViewModel extends ViewModel {
    private MutableLiveData<String> email = new MutableLiveData<>();
    private MutableLiveData<String> nome = new MutableLiveData<>();

    public LiveData<String> getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email.setValue(email);
    }

    public LiveData<String> getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.setValue(nome);
    }
}