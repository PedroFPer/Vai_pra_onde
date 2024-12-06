package com.ducks.vai_pra_onde.Geral.Utilidades;

import java.util.Calendar;
import java.util.Date;

public class UtilDataAtual {
    public Date utilDataAtu(){
        Date dataAtual = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataAtual);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        dataAtual=calendar.getTime();

        return dataAtual;
    }
}
