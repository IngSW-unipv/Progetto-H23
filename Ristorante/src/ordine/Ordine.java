package ordine;
import java.util.ArrayList;

import alimenti.*;

public class Ordine {
	private long tempo;
	private ArrayList<Piatto> piattiOrdinati;
	
	public Ordine() {
		super();
		this.tempo = 0;
		this.piattiOrdinati = new ArrayList<>();
	} 
	
	public void addPiatto(Piatto p, int quantita) {
		
		for(int i=0;i<quantita;i++) {
			piattiOrdinati.add(p);
		}
	}
	
	public void setTempo(long tempo) {
		this.tempo=tempo;
	}
}
