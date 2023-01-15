package it.unipv.ingsfw.model.alimenti;
import it.unipv.ingsfw.model.alimenti.*;

public interface IPiatto {
	
	//public Piatto(double prezzo, String nome, int quantita);
	public int getQuantita();
	public void setQuantita(int quantita);
	public void incrementaQuantita(int quantita);
	public double getPrezzo();
	public String getNome();
}
