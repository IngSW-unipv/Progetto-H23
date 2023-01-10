package persone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ausiliari.Comparatore;
import ordine.Ordine;

public abstract class Persona {
	private String nome;
	protected ArrayList<Ordine> ordini;

	public Persona(String nome) {
		super();
		this.nome = nome;
		this.ordini=new ArrayList<>();
	}

	public abstract boolean identificati();

	public String getNome() {
		return nome;
	}

	public ArrayList<Ordine> getOrdini() {
		return ordini;
	}
	public void stampaOrdini() {
		for (Ordine o: this.ordini) {
			o.stampaPiattiOrdinati();
		}

		Collections.sort(ordini, new Comparator<Ordine>() {
		@Override
		public int compare(Ordine o1, Ordine o2) {
			return (int) (o1.getTempo() - o2.getTempo());
		}
	});
		


	}

}
