package com.ducks.vai_pra_onde.Geral.DAO.ObjectsTest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class PessoaFisicaTEST {
    private final String nome, data_nascimento, email, telefone;
    private String senha;
    public PessoaFisicaTEST(String nome, String data_nascimento, String email, String senha, String telefone) {
        this.nome =  nome;
        this.data_nascimento = data_nascimento;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public PessoaFisicaTEST(String nome, Date data_nascimento, String email, String senha, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        this.data_nascimento = formatador.format(data_nascimento);
    }

    public Date getData() {
        java.util.Date dataFormatada = null;
        try {
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            dataFormatada = formatador.parse(data_nascimento);

        } catch(ParseException e) {
            System.out.println(e.getMessage());
        }
        return dataFormatada;
    }


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // teste em TestesDAOActivity
    @Override
    public String toString() {
        return String.format("nome: %s%ndata_nascimento: %s%nemail: %s%nsenha: %s%ntelefone: %s%n",
        nome, data_nascimento,  email, senha, telefone);
    }
}
