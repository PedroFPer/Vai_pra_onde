package com.ducks.vai_pra_onde.Geral.DTO;

import java.util.Date;

public class CadasPessoPfDTO {

    private String nome;
    private Date dataNascimento;
    private String email;
    private String telefone;
    private String senha;

    public CadasPessoPfDTO(String nome, String email, String telefone,String senha, Date dataNascimento){
        this.nome=nome;
        this.email=email;
        this.telefone=telefone;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }



    public String getNome() {
        if (nome != null) {
            return nome;
        } else {
            return "404";
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
            return dataNascimento;

    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        if (email != null) {
            return email;
        } else {
            return "404";
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        if (telefone != null) {
            return telefone;
        } else {
            return "404";
        }
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        if (senha != null) {
            return senha;
        } else {
            return "404";
        }
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
