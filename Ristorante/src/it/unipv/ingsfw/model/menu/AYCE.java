package it.unipv.ingsfw.model.menu;

import java.util.ArrayList;

import it.unipv.ingsfw.model.alimenti.Piatto;

public class AYCE extends Menu{

	public AYCE(double costo) {
		super();
		this.costo=costo;
	}
	
	@Override
	public double getConto() {
		return costo;
	}
}
