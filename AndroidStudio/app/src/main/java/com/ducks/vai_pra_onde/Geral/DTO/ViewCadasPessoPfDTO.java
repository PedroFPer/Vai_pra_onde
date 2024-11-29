package com.ducks.vai_pra_onde.Geral.DTO;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewCadasPessoPfDTO extends ViewModel {

    private MutableLiveData<String> nome = new MutableLiveData<>();
    private MutableLiveData<String> dataNascimento = new MutableLiveData<>();
    private MutableLiveData<String> email = new MutableLiveData<>();
    private MutableLiveData<String> telefone = new MutableLiveData<>();
    private MutableLiveData<String> senha = new MutableLiveData<>();

    public LiveData<String> getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.setValue(nome);
    }

    public LiveData<String> getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento.setValue(dataNascimento);
    }

    public LiveData<String> getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email.setValue(email);
    }

    public LiveData<String> getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone.setValue(telefone);
    }

    public LiveData<String> getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha.setValue(senha);
    }
}
