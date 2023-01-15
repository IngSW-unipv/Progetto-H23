package it.unipv.ingsfw.model.ordine;

import java.util.ArrayList;

import it.unipv.ingsfw.model.alimenti.IPiatto;

public interface IOrdine {
	//public Ordine();
	public void addPiatto(IPiatto p, int quantita);
	public long getTempo();
	public void setTempo(long tempo);
	public boolean getStato();
	public void setStato(boolean stato);
	public ArrayList<IPiatto> getPiattiOrdinati();
	public void setPiattiOrdinati(ArrayList<IPiatto> piattiOrdinati);
	public void stampaPiattiOrdinati();
}
