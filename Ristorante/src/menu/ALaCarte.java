package menu;

import java.util.ArrayList;

import alimenti.Piatto;

public class ALaCarte extends Menu{

	public ALaCarte(ArrayList<Piatto> alimenti) {
		super();
		costo=0;
	}
	
	@Override
	public double getConto() {
		for(Piatto p:alimenti) {
			costo=costo+p.getPrezzo();
		}
		return costo;
	}
}
