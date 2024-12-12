package com.ducks.vai_pra_onde.Geral.Utilidades;

import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilVericCreden {


    public boolean vericCpf(String cpf){
        if(cpf.length()!=11){
            return false;
        }else{
            return true;
        }
    }
    public boolean vericCnpj(String cnpj){
        if(cnpj.length()!=14){
            return false;
        }else{
            return true;
        }
    }
    public boolean vericTelef(String telefone){
        if(telefone.length()!=13){
            return false;
        }else{
            return true;
        }
    }

    public boolean vericSenha(String senha){
        if(senha.length()!=8){
            return false;
        }else{
            return true;
        }
    }


    public boolean vericIdade (Date dataFormatadest){
        UtilDataAtual utilDataAtual = new UtilDataAtual();

        Date dataAtual = utilDataAtual.utilDataAtu();

        Calendar calInic = Calendar.getInstance();
        calInic.setTime(dataFormatadest);
        int anoNasci = calInic.get(Calendar.YEAR);

        Calendar calFim = Calendar.getInstance();
        calFim.setTime(dataAtual);
        int anoAtual = calFim.get(Calendar.YEAR);

        int idadeClie = anoAtual-anoNasci;

        if(idadeClie>=16){
            return true;
        }else{
            return false;
        }
    }

    public boolean vericDataVal(Date dataFormatadest) {
        UtilDataAtual utilDataAtual = new UtilDataAtual();
        Date dataAtual = utilDataAtual.utilDataAtu();


        Calendar calAtual = Calendar.getInstance();
        calAtual.setTime(dataAtual);
        int vericAnoAtual = calAtual.get(Calendar.YEAR);


        Calendar calData = Calendar.getInstance();
        calData.setTime(dataFormatadest);
        int anoNasc = calData.get(Calendar.YEAR);
        int mesNasc = calData.get(Calendar.MONTH) + 1;
        int diaNasc = calData.get(Calendar.DAY_OF_MONTH);


        if (anoNasc <= 130 - vericAnoAtual || anoNasc > vericAnoAtual) {
            return false;
        }


        if (mesNasc < 1 || mesNasc > 12) {
            return false;
        }

        boolean isValido = false;
        switch (mesNasc) {
            case 2: // Fevereiro
                // Verifica se o ano é bissexto
                if ((anoNasc % 4 == 0 && anoNasc % 100 != 0) || (anoNasc % 400 == 0)) {
                    isValido = diaNasc >= 1 && diaNasc <= 29;
                } else {
                    isValido = diaNasc >= 1 && diaNasc <= 28;
                }
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                isValido = diaNasc >= 1 && diaNasc <= 30;
                break;

            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                isValido = diaNasc >= 1 && diaNasc <= 31;
                break;
        }

        return isValido;
    }
}
