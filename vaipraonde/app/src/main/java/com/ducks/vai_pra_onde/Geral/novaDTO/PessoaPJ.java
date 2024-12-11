package com.ducks.vai_pra_onde.Geral.novaDTO;

public class PessoaPJ {
    private String nomeEmpresa, nomeEmpresario, cpfEmpresario, senha, logradouro, bairro, cidade, estado;
    private final String cnpj, email;
    private String codigoDocumento;

    public PessoaPJ(String nomeEmpresa, String nomeEmpresario, String cpfEmpresario, String senha,
    String logradouro, String bairro, String cidade, String estado, String cnpj, String email) {
        this.nomeEmpresa = nomeEmpresa;
        this.nomeEmpresario = nomeEmpresario;
        this.cpfEmpresario = cpfEmpresario;
        this.senha = senha;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cnpj = cnpj;
        this.email = email;
    }

    // construtor sobrecarregado: Usado na busca do objeto no Banco de Dados
    public PessoaPJ(String nomeEmpresa, String nomeEmpresario, String cpfEmpresario, String senha,
    String logradouro, String bairro, String cidade, String estado, String cnpj, String email, String codigoDocumento) {
        this.nomeEmpresa = nomeEmpresa;
        this.nomeEmpresario = nomeEmpresario;
        this.cpfEmpresario = cpfEmpresario;
        this.senha = senha;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cnpj = cnpj;
        this.email = email;
        this.codigoDocumento = codigoDocumento; // construtor do banco de dados
    }

    // METODOS PRIORIDADE PARA TESTE
    public String getCnpj() {
        return cnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getCodigoDocumento() {
        return codigoDocumento;
    }

    // Os demais metodos setters e getters serao feitos depois

}
