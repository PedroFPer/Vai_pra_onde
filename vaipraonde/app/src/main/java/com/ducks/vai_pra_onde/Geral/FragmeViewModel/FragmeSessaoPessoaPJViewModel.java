package com.ducks.vai_pra_onde.Geral.FragmeViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ducks.vai_pra_onde.Geral.novaDTO.Eventos;
import com.ducks.vai_pra_onde.Geral.novaDTO.PessoaPJ;

import java.util.ArrayList;

public class FragmeSessaoPessoaPJViewModel extends ViewModel {
    private MutableLiveData<PessoaPJ> pessoaPJ = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Eventos>> listaEventos = new MutableLiveData<>(new ArrayList<>());

    public PessoaPJ getPessoaPJ() {
        return pessoaPJ.getValue();
    }

    public void setPessoaPJ(PessoaPJ pessoaPJ) {
        this.pessoaPJ.setValue(pessoaPJ);
    }

    public ArrayList<Eventos> getListaEventos() {
        return listaEventos.getValue();
    }

    public void setListaEventos(ArrayList<Eventos> eventos) {
        listaEventos.setValue(eventos);
    }

    public void addEvento(Eventos evento) {
        ArrayList<Eventos> eventosAtual = listaEventos.getValue();
        if (eventosAtual != null) {
            eventosAtual.add(evento);
            listaEventos.setValue(eventosAtual);
        }
    }

    public void removeEvento(Eventos evento) {
        ArrayList<Eventos> eventosAtual = listaEventos.getValue();
        if (eventosAtual != null) {
            eventosAtual.remove(evento);
            listaEventos.setValue(eventosAtual);
        }
    }
}
