package com.ducks.vai_pra_onde.Geral.novaSERVICE.FrontEndSERVICE;

import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;

import java.util.ArrayList;

public class Buscas {
    public static Eventos buscarEvento(String nomeEvento, ArrayList<Eventos> listaEventos) {
        for(Eventos evento : listaEventos)
            if(evento.getNomeEvento().equals(nomeEvento))
                return evento;
        return null;
    }
}
