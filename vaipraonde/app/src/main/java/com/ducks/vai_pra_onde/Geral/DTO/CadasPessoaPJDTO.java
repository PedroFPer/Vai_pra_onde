package com.ducks.vai_pra_onde.Geral.DTO;

public class CadasPessoaPJDTO {

    private String nomeEmpresa;
    private String cnpj;
    private String responsavel;
    private String cpfResponsavel;
    private String email;
    private String telefone;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private byte[] imagemByteArray;

    // Construtor
    public CadasPessoaPJDTO(String nomeEmpresa, String cnpj, String responsavel, String cpfResponsavel, String email,
                       String telefone, String logradouro, String bairro,
                       String cidade, String estado, String pais, byte[] imagemByteArray) {
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.responsavel = responsavel;
        this.cpfResponsavel = cpfResponsavel;
        this.email = email;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.imagemByteArray = imagemByteArray;
    }

    // Getters e Setters
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public byte[] getImagemByteArray() {
        return imagemByteArray;
    }

    public void setImagemByteArray(byte[] imagemByteArray) {
        this.imagemByteArray = imagemByteArray;
    }
}
