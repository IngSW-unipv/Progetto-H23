package persone;

import alimenti.Piatto;

public class Dipendente extends Persona{

	public Dipendente(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean identificati() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void addQuantitaPiatto(Piatto p,int quantita) {
		p.incrementaQuantita(quantita);
	}
}
