package com.ducks.vai_pra_onde.Geral.novaDTO;

import java.util.Date;

public class Eventos {
    /*Nome do Evento, Nome da Empresa, codigoDocumento (Firebase),
    codigoDocumentoEmpresa (Firebase), Descrição, Data do Evento, Horário do Evento, Email,
    Telefone, Logradouro, Bairro, ,Cidade. Estado, País
     */
    private String nomeEvento, nomeEmpresa, codigoDocumento, codigoDocumentoEmpresa, descricao, email;
    private String telefone, logradouro, bairro, cidade, estado;
    private Date dataEvento;

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

    // faltam os metodos getters

    // os metodos setters deve ser APENAS:
    // setDataEvento(Date dataEvento)

}
