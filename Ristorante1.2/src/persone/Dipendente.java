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



	public void aggiungiOrdini() {
		for (Cliente c: r.getClienti()) {
			for (Ordine o: c.getOrdini()) {
				ordiniAusiliario.add(o);
			}	
		}

		Collections.sort(ordiniAusiliario, new Comparator<Ordine>() {
			@Override
			public int compare(Ordine o1, Ordine o2) {
				return (int) (o1.getTempo() - o2.getTempo());
			}
		});

		for (Ordine o: ordiniAusiliario) {
			if (ordini.size() == 0) {
				for(Ordine oa : ordiniAusiliario) {
					ordini.add(oa);
				}


			}
			else if (o.getTempo() > ordini.get(ordini.size() -1).getTempo())
				ordini.add(o);

		}
		/*
		System.out.println("Array ausiliario:");
		for (Ordine o : ordiniAusiliario) {
			System.out.println(o.getTempo() );
			o.stampaPiattiOrdinati();
		}
		System.out.println("Finito");

		System.out.println("Ordini aggiunti:");
		for (Ordine o : ordini) {
			System.out.println(o.getTempo() );
			o.stampaPiattiOrdinati();
		}
		System.out.println("Finito");
		 */
		ordiniAusiliario.clear();


	}

	public void aggiornaStatoPiatto(Ordine o) {
		o.setStato(true);
		System.out.println("ordine in arrivo!");
	}

	public String getPasssword() {
		return r.getPassword();
	}

	public void preparaOrdine() {
		for (int i = contPiatti; i<ordini.size(); i++) {

			aggiornaStatoPiatto(ordini.get(i));
		}
		contPiatti = ordini.size();
	}
}

















