package it.unipv.ingsfw.model.ausiliari;

import java.util.Comparator;

import it.unipv.ingsfw.model.ordine.IOrdine;
import it.unipv.ingsfw.model.ordine.Ordine;

public class Comparatore implements Comparator<IOrdine> {
	@Override
    public int compare(IOrdine o1, IOrdine o2) {
        return (int) (o1.getTempo() - o2.getTempo());
    }
}

