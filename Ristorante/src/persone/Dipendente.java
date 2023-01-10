package persone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import alimenti.Piatto;
import ordine.Ordine;
import ristorante.Ristorante;

public class Dipendente extends Persona{
	private Ristorante r;
	private boolean identificato;
	private int contPiatti;
	private ArrayList<Ordine> ordiniAusiliario;
	public Dipendente(String nome, Ristorante r) {
		super(nome);
		this.r = r;
		contPiatti = 0;
		identificato = false;
		ordiniAusiliario = new ArrayList<>();
	}

	@Override
	public boolean identificati() {
		// TODO Auto-generated method stub
		return false;
	}

	public void addQuantitaPiatto(Piatto p,int quantita) {
		p.incrementaQuantita(quantita);
	}



	// Da sistemare dopo il sort.
	public void aggiungiOrdini() {
		int i = 0;
		for (Cliente c: r.getClienti()) {
			for (Ordine o: c.getOrdini()) {
				ordiniAusiliario.add(i, o);
				i++;
			}
			Collections.sort(ordiniAusiliario, new Comparator<Ordine>() {
				@Override
				public int compare(Ordine o1, Ordine o2) {
					return (int) (o1.getTempo() - o2.getTempo());
				}
				});
			for (Ordine o: c.getOrdini()) {
				if (ordini.size() == 0) {
					ordini.add(o);
				}
				else if (o.getTempo() > ordini.get(ordini.size() - 1).getTempo())
					ordini.add(o);

			}
		}
	}

	public void aggiornaStatoPiatto(Ordine o) {
		o.setStato(true);
	}
	public String getPasssword() {
		return r.getPassword();
	}
	
	public void preparaOrdine() {
		for (int i = contPiatti; i<ordini.size(); i++) {

			for (Piatto p: ordini.get(i).getPiattiOrdinati()) {
				p.setQuantita(p.getQuantita()- 1);
			}
		}
		contPiatti = ordini.size();
	
	}
}




	












