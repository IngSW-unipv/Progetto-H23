package it.unipv.ingsfw.model.menu;

public class AYCE extends Menu{

	public AYCE(double conto) {
		super();
		this.conto=conto;
	}
	
	@Override
	public void setConto(double conto) {
		//non fa niente -> non posso cambiare il conto dell'AYCE
	}
}
