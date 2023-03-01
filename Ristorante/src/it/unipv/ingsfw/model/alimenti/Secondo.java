package it.unipv.ingsfw.model.alimenti;

public class Secondo extends Piatto{

	public Secondo(double prezzo, String nome, int quantita) {
		super(prezzo, nome, quantita);
		tipo = tipo.SECONDO;
	}

}
