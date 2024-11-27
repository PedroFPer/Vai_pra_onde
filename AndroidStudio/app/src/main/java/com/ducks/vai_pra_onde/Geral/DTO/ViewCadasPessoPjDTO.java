package com.ducks.vai_pra_onde.Geral.DTO;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewCadasPessoPjDTO extends ViewModel {

    private MutableLiveData<String> nomeEmpresa = new MutableLiveData<>();
    private MutableLiveData<String> cnpj = new MutableLiveData<>();
    private MutableLiveData<String> responsavel = new MutableLiveData<>();
    private MutableLiveData<String> cpfResponsavel = new MutableLiveData<>();
    private MutableLiveData<String> email = new MutableLiveData<>();
    private MutableLiveData<String> telefone = new MutableLiveData<>();
    private MutableLiveData<String> documentacao = new MutableLiveData<>();
    private MutableLiveData<String> logradouro = new MutableLiveData<>();
    private MutableLiveData<String> bairro = new MutableLiveData<>();
    private MutableLiveData<String> cidade = new MutableLiveData<>();
    private MutableLiveData<String> estado = new MutableLiveData<>();
    private MutableLiveData<String> pais = new MutableLiveData<>();
    private MutableLiveData<String> referencia = new MutableLiveData<>();

    public LiveData<String> getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa.setValue(nomeEmpresa);
    }

    public LiveData<String> getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj.setValue(cnpj);
    }

    public LiveData<String> getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel.setValue(responsavel);
    }

    public LiveData<String> getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel.setValue(cpfResponsavel);
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

    public LiveData<String> getDocumentacao() {
        return documentacao;
    }

    public void setDocumentacao(String documentacao) {
        this.documentacao.setValue(documentacao);
    }

    public LiveData<String> getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro.setValue(logradouro);
    }

    public LiveData<String> getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro.setValue(bairro);
    }

    public LiveData<String> getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade.setValue(cidade);
    }

    public LiveData<String> getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado.setValue(estado);
    }

    public LiveData<String> getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais.setValue(pais);
    }

    public LiveData<String> getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia.setValue(referencia);
    }
}
