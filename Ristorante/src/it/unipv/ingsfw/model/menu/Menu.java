package it.unipv.ingsfw.model.menu;


public abstract class Menu implements IMenu{
	
	protected double conto;

	public Menu() {
		super();
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
