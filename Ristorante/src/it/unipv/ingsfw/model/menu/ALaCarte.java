package it.unipv.ingsfw.model.menu;

import java.util.ArrayList;

import it.unipv.ingsfw.model.alimenti.Piatto;

public class ALaCarte extends Menu{

	public ALaCarte() {
		super();
		conto=0;
	}
	
	public void PiattiOrdine() {
		// Da fare uscire in ordine Primo, Secondo...
	}
	
	/*@Override
	public double getConto() {
		for(Piatto p:alimenti) {
			conto=conto+p.getPrezzo();
		}
		return conto;
	}*/
}
