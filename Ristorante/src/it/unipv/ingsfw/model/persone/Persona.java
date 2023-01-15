package it.unipv.ingsfw.model.persone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import it.unipv.ingsfw.model.ausiliari.Comparatore;
import it.unipv.ingsfw.model.ordine.IOrdine;
import it.unipv.ingsfw.model.ordine.Ordine;

public abstract class Persona implements IPersona{
	private String nome;
	protected ArrayList<IOrdine> ordini;

	public Persona(String nome) {
		super();
		this.nome = nome;
		this.ordini=new ArrayList<IOrdine>();
	}
	@Override
	public String getNome() {
		return nome;
	}
	@Override
	public ArrayList<IOrdine> getOrdini() {
		return ordini;
	}
	@Override
	public void stampaOrdini() {
		for (IOrdine o: this.ordini) {
			o.stampaPiattiOrdinati();
		}

		Collections.sort(ordini, new Comparator<IOrdine>() {
		@Override
		public int compare(IOrdine o1, IOrdine o2) {
			return (int) (o1.getTempo() - o2.getTempo());
		}
		});
	}
}