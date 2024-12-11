package com.ducks.vai_pra_onde.Geral.novaDTO;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class PessoaPJ implements Parcelable {
    private String nomeEmpresa, nomeEmpresario, cpfEmpresario, senha, logradouro, bairro, cidade, estado, telefone;
    private final String cnpj, email;
    private String codigoDocumento;

    public PessoaPJ(String nomeEmpresa, String nomeEmpresario, String cpfEmpresario, String senha,
                    String logradouro, String bairro, String cidade, String estado, String cnpj, String email, String telefone) {
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
        this.telefone = telefone;
    }

    // Construtor sobrecarregado: Usado na busca do objeto no Banco de Dados
    public PessoaPJ(String nomeEmpresa, String nomeEmpresario, String cpfEmpresario, String senha,
                    String logradouro, String bairro, String cidade, String estado, String cnpj, String email, String telefone, String codigoDocumento) {
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
        this.telefone = telefone; // Agora o telefone é atribuído corretamente
        this.codigoDocumento = codigoDocumento; // Construtor do banco de dados
    }

    // Métodos de acesso (GETTERS)
    public String getCnpj() {
        return cnpj;
    }

    public String getEmail() {
        return email;
    }
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public String getNomeEmpresario() {
        return nomeEmpresario;
    }

    public String getCpfEmpresario() {
        return cpfEmpresario;
    }

    public String getSenha() {
        return senha;
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

    public String getTelefone() {
        return telefone;
    }

    public String getCodigoDocumento() {
        return codigoDocumento;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nomeEmpresa);
        dest.writeString(nomeEmpresario);
        dest.writeString(cpfEmpresario);
        dest.writeString(senha);
        dest.writeString(logradouro);
        dest.writeString(bairro);
        dest.writeString(cidade);
        dest.writeString(estado);
        dest.writeString(cnpj);
        dest.writeString(email);
        dest.writeString(telefone); // Agora o telefone também é gravado corretamente
        dest.writeString(codigoDocumento);
    }

    protected PessoaPJ(Parcel in) {
        nomeEmpresa = in.readString();
        nomeEmpresario = in.readString();
        cpfEmpresario = in.readString();
        senha = in.readString();
        logradouro = in.readString();
        bairro = in.readString();
        cidade = in.readString();
        estado = in.readString();
        cnpj = in.readString();
        email = in.readString();
        telefone = in.readString(); // Garantindo a leitura do telefone
        codigoDocumento = in.readString();
    }

    public static final Creator<PessoaPJ> CREATOR = new Creator<PessoaPJ>() {
        @Override
        public PessoaPJ createFromParcel(Parcel in) {
            return new PessoaPJ(in);
        }

        @Override
        public PessoaPJ[] newArray(int size) {
            return new PessoaPJ[size];
        }
    };
}
