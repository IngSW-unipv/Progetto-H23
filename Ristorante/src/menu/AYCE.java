package menu;

import java.util.ArrayList;

import alimenti.Piatto;

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
