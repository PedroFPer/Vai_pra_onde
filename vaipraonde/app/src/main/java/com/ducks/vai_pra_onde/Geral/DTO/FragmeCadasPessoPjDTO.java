package com.ducks.vai_pra_onde.Geral.DTO;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FragmeCadasPessoPjDTO extends ViewModel {

    private MutableLiveData<String> nomeEmpresa = new MutableLiveData<>();
    private MutableLiveData<String> cnpj = new MutableLiveData<>();
    private MutableLiveData<String> responsavel = new MutableLiveData<>();
    private MutableLiveData<String> cpfResponsavel = new MutableLiveData<>();

    private MutableLiveData<String> senha = new MutableLiveData<>();
    private MutableLiveData<String> email = new MutableLiveData<>();
    private MutableLiveData<String> telefone = new MutableLiveData<>();
    private MutableLiveData<String> documentacao = new MutableLiveData<>();
    private MutableLiveData<String> logradouro = new MutableLiveData<>();
    private MutableLiveData<String> bairro = new MutableLiveData<>();
    private MutableLiveData<String> cidade = new MutableLiveData<>();
    private MutableLiveData<String> estado = new MutableLiveData<>();
    private MutableLiveData<String> pais = new MutableLiveData<>();


    private MutableLiveData<byte[]> imagemByteArray = new MutableLiveData<>();

    public String getNomeEmpresa() {

        if(nomeEmpresa.getValue()!=null){
            String empresa= nomeEmpresa.getValue();
            return empresa;
        }else {
            return "404";
        }

    }

    public void setNomeEmpresa(String nomeEmpresa) {

        this.nomeEmpresa.setValue(nomeEmpresa);
    }

    public String getCnpj() {
        if(cnpj.getValue()!=null){
            String cnpjstr= cnpj.getValue();
            return cnpjstr;
        }else {
            return "404";
        }

    }

    public void setCnpj(String cnpj) {

        this.cnpj.setValue(cnpj);
    }

    public String getResponsavel() {
        if(responsavel.getValue()!=null){
            String responsavelstr= responsavel.getValue();
            return responsavelstr;
        }else {
            return "404";
        }

    }

    public void setResponsavel(String responsavel) {

        this.responsavel.setValue(responsavel);
    }

    public String getCpfResponsavel() {
        if(cpfResponsavel.getValue()!=null){
            String cpfresponsavelstr= cpfResponsavel.getValue();
            return cpfresponsavelstr;
        }else {
            return "404";
        }

    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel.setValue(cpfResponsavel);
    }

    public String getEmail() {
        if(email.getValue()!=null){
            String emailstr= email.getValue();
            return emailstr;
        }else {
            return "404";
        }

    }

    public void setEmail(String email) {

        this.email.setValue(email);
    }

    public String getTelefone() {
        if(telefone.getValue()!=null){
            String telefonestr= telefone.getValue();
            return telefonestr;
        }else {
            return "404";
        }

    }

    public void setTelefone(String telefone) {

        this.telefone.setValue(telefone);
    }

    public String getDocumentacao() {
        if(documentacao.getValue()!=null){
            String documentacaostr= documentacao.getValue();
            return documentacaostr;
        }else {
            return "404";
        }

    }

    public void setDocumentacao(String documentacao) {

        this.documentacao.setValue(documentacao);
    }

    public String getLogradouro() {
        if (logradouro.getValue() != null) {
            String logradourostr = logradouro.getValue();
            return logradourostr;
        } else {
            return "404";
        }
    }

    public void setLogradouro(String logradouro) {

        this.logradouro.setValue(logradouro);
    }

    public String getBairro() {
        if (bairro.getValue() != null) {
            String bairrostr = bairro.getValue();
            return bairrostr;
        } else {
            return "404";
        }
    }

    public void setBairro(String bairro) {
        this.bairro.setValue(bairro);
    }

    public String getCidade() {
        if (cidade.getValue() != null) {
            String cidadestr = cidade.getValue();
            return cidadestr;
        } else {
            return "404";
        }
    }


    public void setCidade(String cidade) {
        this.cidade.setValue(cidade);
    }

    public String getEstado() {
        if (estado.getValue() != null) {
            String estadostr = estado.getValue();
            return estadostr;
        } else {
            return "404";
        }
    }


    public void setEstado(String estado) {
        this.estado.setValue(estado);
    }

    public String getPais() {
        if (pais.getValue() != null) {
            String paisstr = pais.getValue();
            return paisstr;
        } else {
            return "404";
        }
    }

    public void setPais(String pais) {
        this.pais.setValue(pais);
    }


    public void setDocumAutecEmpr(byte[] imagem) {
        imagemByteArray.setValue(imagem); // Armazena a imagem
    }

    public byte[] getImageByteArray() {
        if (imagemByteArray.getValue() != null) {
            byte[] imgbyte = imagemByteArray.getValue();
            return imgbyte;
        } else {
            return null;
        }

    }
    public LiveData<byte[]> getImageByteArrayView() {
        return imagemByteArray;
    }


    public String getSenha() {
        if (senha.getValue() != null) {
            String senhastr = senha.getValue();
            return senhastr;
        } else {
            return "404";
        }
    }

    public void setSenha(String senha) {
        this.senha.setValue(senha);
    }

}
