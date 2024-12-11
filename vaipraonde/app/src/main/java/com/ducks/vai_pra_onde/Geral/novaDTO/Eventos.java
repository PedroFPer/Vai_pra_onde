package com.ducks.vai_pra_onde.Geral.novaDTO;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;

public class Eventos implements Parcelable {
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

    protected Eventos(Parcel in) {
        nomeEvento = in.readString();
        nomeEmpresa = in.readString();
        codigoDocumento = in.readString();
        codigoDocumentoEmpresa = in.readString();
        descricao = in.readString();
        email = in.readString();
        telefone = in.readString();
        logradouro = in.readString();
        bairro = in.readString();
        cidade = in.readString();
        estado = in.readString();
    }

    public static final Creator<Eventos> CREATOR = new Creator<Eventos>() {
        @Override
        public Eventos createFromParcel(Parcel in) {
            return new Eventos(in);
        }

        @Override
        public Eventos[] newArray(int size) {
            return new Eventos[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nomeEvento);
        dest.writeString(nomeEmpresa);
        dest.writeString(codigoDocumento);
        dest.writeString(codigoDocumentoEmpresa);
        dest.writeString(descricao);
        dest.writeString(email);
        dest.writeString(telefone);
        dest.writeString(logradouro);
        dest.writeString(bairro);
        dest.writeString(cidade);
        dest.writeString(estado);
    }

    // faltam os metodos getters

    // os metodos setters deve ser APENAS:
    // setDataEvento(Date dataEvento)

}