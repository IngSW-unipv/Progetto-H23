package it.unipv.ingsfw.model.menu;
import java.util.ArrayList;

import it.unipv.ingsfw.model.alimenti.*;

//Sistemare menu

public abstract class Menu implements IMenu{
	protected double conto;
	//protected ArrayList<Piatto> alimenti;
	
	public Menu() {
		super();
		//this.alimenti = new ArrayList<>();
	}
	@Override
	public void setConto(double conto) {
		this.conto = conto;
	}
	@Override
	public double getConto() {
		return conto;
	}
}
