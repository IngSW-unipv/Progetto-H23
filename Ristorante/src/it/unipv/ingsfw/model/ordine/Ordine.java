package it.unipv.ingsfw.model.ordine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import it.unipv.ingsfw.model.alimenti.*;

public class Ordine implements IOrdine{
	private long tempo;
	private ArrayList<IPiatto> piattiOrdinati;
	private boolean stato;

	public Ordine() {
		super();
		this.tempo=0;
		this.piattiOrdinati = new ArrayList<>();
		this.stato = false;
	} 
	@Override
	public void addPiatto(IPiatto piatto, int quantita) {

		for(int i=0;i<quantita;i++) {
			piattiOrdinati.add(piatto);
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
			System.out.println(p.getNome());
		}
	}


	@Override
	public String getNomiPiattiOrdinati() {
		Set <IPiatto> setPiatti = new HashSet<>();
		String piattiString="";
		setPiatti.addAll(piattiOrdinati);
		for (IPiatto p: setPiatti ) {
			piattiString = piattiString + p.getNome() + " " +   Collections.frequency(piattiOrdinati, p);
		}

		return piattiString;
	}
}