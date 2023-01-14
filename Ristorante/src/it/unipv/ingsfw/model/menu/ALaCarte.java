package it.unipv.ingsfw.model.menu;

import java.util.ArrayList;

import it.unipv.ingsfw.model.alimenti.Piatto;

public class ALaCarte extends Menu{

	public ALaCarte() {
		super();
		costo=0;
	}
	
	@Override
	public double getConto() {/*
		for(Piatto p:alimenti) {
			costo=costo+p.getPrezzo();
		}*/
		return costo;
	}
}
