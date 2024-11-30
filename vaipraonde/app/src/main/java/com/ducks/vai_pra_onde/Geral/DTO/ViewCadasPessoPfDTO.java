package com.ducks.vai_pra_onde.Geral.DTO;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewCadasPessoPfDTO extends ViewModel {

    private MutableLiveData<String> nome = new MutableLiveData<>();
    private MutableLiveData<String> dataNascimento = new MutableLiveData<>();
    private MutableLiveData<String> email = new MutableLiveData<>();
    private MutableLiveData<String> telefone = new MutableLiveData<>();
    private MutableLiveData<String> senha = new MutableLiveData<>();

    public String getNome() {
        if (nome.getValue() != null) {
            String nomeStr = nome.getValue();
            return nomeStr;
        } else {
            return "404";
        }
    }

    public void setNome(String nome) {
        this.nome.setValue(nome);
    }

    public String getDataNascimento() {
        if (dataNascimento.getValue() != null) {
            String dataNascimentoStr = dataNascimento.getValue();
            return dataNascimentoStr;
        } else {
            return "404";
        }
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento.setValue(dataNascimento);
    }

    public String getEmail() {
        if (email.getValue() != null) {
            String emailStr = email.getValue();
            return emailStr;
        } else {
            return "404";
        }
    }

    public void setEmail(String email) {
        this.email.setValue(email);
    }

    public String getTelefone() {
        if (telefone.getValue() != null) {
            String telefoneStr = telefone.getValue();
            return telefoneStr;
        } else {
            return "404";
        }
    }

    public void setTelefone(String telefone) {
        this.telefone.setValue(telefone);
    }

    public String getSenha() {
        if (senha.getValue() != null) {
            String senhaStr = senha.getValue();
            return senhaStr;
        } else {
            return "404";
        }
    }

    public void setSenha(String senha) {
        this.senha.setValue(senha);
    }
}
