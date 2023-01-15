package it.unipv.ingsfw.model.ordine;
import java.util.ArrayList;
import java.util.Collections;

import it.unipv.ingsfw.model.alimenti.*;
import it.unipv.ingsfw.model.ausiliari.Comparatore;

public class Ordine implements IOrdine{
	private long tempo;
	private ArrayList<IPiatto> piattiOrdinati;
	private boolean stato;
	
	public Ordine() {
		super();
		this.tempo = 0;
		this.piattiOrdinati = new ArrayList<>();
		this.stato = false;
	} 
	@Override
	public void addPiatto(IPiatto p, int quantita) {
		
		for(int i=0;i<quantita;i++) {
			piattiOrdinati.add(p);
		}
	}
	@Override
	public long getTempo() {
		return tempo;
	}
	@Override
	public void setTempo(long tempo) {
		this.tempo = tempo;
	}
	@Override
	public boolean getStato() {
		return stato;
	}
	@Override
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	@Override
	public ArrayList<IPiatto> getPiattiOrdinati() {
		return piattiOrdinati;
	}
	@Override
	public void setPiattiOrdinati(ArrayList<IPiatto> piattiOrdinati) {
		this.piattiOrdinati = piattiOrdinati;
	}
	@Override
	public void stampaPiattiOrdinati() {
		for (IPiatto p: piattiOrdinati) {
			System.out.println("Nome: "+ p.getNome());
			System.out.println("Prezzo: " + p.getPrezzo());
			System.out.println("Quantita: " + p.getQuantita());
		
		}
	}
	
	
	
	
	
	
	
	
	
}
