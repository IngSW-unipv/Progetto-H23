package it.unipv.ingsfw.model.alimenti;

public class Bibita extends Piatto{

	public Bibita(double prezzo, String nome, int quantita) {
		super(prezzo, nome, quantita);
		tipo = tipo.BIBITA;
	}
	
}
