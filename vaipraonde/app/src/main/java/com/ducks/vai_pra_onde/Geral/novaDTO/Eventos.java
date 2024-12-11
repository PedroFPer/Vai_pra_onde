package com.ducks.vai_pra_onde.Geral.novaDTO;

import java.util.Date;

public class Eventos {
    /*Nome do Evento, Nome da Empresa, codigoDocumento (Firebase),
    codigoDocumentoEmpresa (Firebase), Descrição, Data do Evento, Horário do Evento, Email,
    Telefone, Logradouro, Bairro, ,Cidade. Estado*/
    private String nomeEvento, nomeEmpresa, codigoDocumento, codigoDocumentoEmpresa, descricao, email;
    private String telefone, logradouro, bairro, cidade, estado;
    private Date dataEvento;

    // construtor usado na recuperacao no Banco de Dados
    public Eventos(String nomeEvento, String nomeEmpresa, String codigoDocumento, String codigoDocumentoEmpresa,
    String descricao, String email, String telefone, String logradouro, String bairro, String cidade, String estado,
    Date dataEvento) {
        this.nomeEvento = nomeEvento;
        this.nomeEmpresa = nomeEmpresa;
        this.codigoDocumento = codigoDocumento;
        this.codigoDocumentoEmpresa = codigoDocumentoEmpresa;
        this.descricao = descricao;
        this.email = email;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.dataEvento = dataEvento;
    }

    // construtor usado no FRONT END de cadastro de eventos
    public Eventos(String nomeEvento, String nomeEmpresa, String codigoDocumentoEmpresa, String descricao, String email,
    String telefone, String logradouro, String bairro, String cidade, String estado, Date dataEvento) {
        this.nomeEvento = nomeEvento;
        this.nomeEmpresa = nomeEmpresa;
        this.codigoDocumentoEmpresa = codigoDocumentoEmpresa;
        this.descricao = descricao;
        this.email = email;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.dataEvento = dataEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public String getCodigoDocumento() {
        return codigoDocumento;
    }

    public String getCodigoDocumentoEmpresa() {
        return codigoDocumentoEmpresa;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    // faltam os metodos setters
}
