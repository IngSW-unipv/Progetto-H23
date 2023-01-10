package ordine;
import java.util.ArrayList;
import java.util.Collections;

import alimenti.*;
import ausiliari.Comparatore;

public class Ordine {
	private long tempo;
	private ArrayList<Piatto> piattiOrdinati;
	private boolean stato;
	
	public Ordine() {
		super();
		this.tempo = 0;
		this.piattiOrdinati = new ArrayList<>();
		this.stato = false;
	} 
	
	public void addPiatto(Piatto p, int quantita) {
		
		for(int i=0;i<quantita;i++) {
			piattiOrdinati.add(p);
		}
	}
	
	

	public long getTempo() {
		return tempo;
	}

	public void setTempo(long tempo) {
		this.tempo = tempo;
	}

	public boolean getStato() {
		return stato;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}

	public ArrayList<Piatto> getPiattiOrdinati() {
		return piattiOrdinati;
	}

	public void setPiattiOrdinati(ArrayList<Piatto> piattiOrdinati) {
		this.piattiOrdinati = piattiOrdinati;
	}
	public void stampaPiattiOrdinati() {
		for (Piatto p: piattiOrdinati) {
			System.out.println("Nome: "+ p.getNome());
			System.out.println("Prezzo: " + p.getPrezzo());
			System.out.println("Quantita: " + p.getQuantita());
		
		}
	}
	
	
	
	
	
	
	
	
	
}
