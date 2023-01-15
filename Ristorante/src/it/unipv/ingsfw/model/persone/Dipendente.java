package it.unipv.ingsfw.model.persone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import it.unipv.ingsfw.model.alimenti.IPiatto;
import it.unipv.ingsfw.model.alimenti.Piatto;
import it.unipv.ingsfw.model.ordine.IOrdine;
import it.unipv.ingsfw.model.ordine.Ordine;
import it.unipv.ingsfw.model.ristorante.Ristorante;

public class Dipendente extends Persona{
	private Ristorante r;
	private boolean identificato;
	private int contPiatti;
	private ArrayList<IOrdine> ordiniAusiliario;
	
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

	public void addQuantitaPiatto(IPiatto p,int quantita) {
		p.incrementaQuantita(quantita);
	}



	public void aggiungiOrdini() {
		for (Cliente c: r.getClienti()) {
			for (IOrdine o: c.getOrdini()) {
				ordiniAusiliario.add(o);
			}	
		}

		Collections.sort(ordiniAusiliario, new Comparator<IOrdine>() {
			@Override
			public int compare(IOrdine o1, IOrdine o2) {
				return (int) (o1.getTempo() - o2.getTempo());
			}
		});

		for (IOrdine o: ordiniAusiliario) {
			if (ordini.size() == 0) {
				for(IOrdine oa : ordiniAusiliario) {
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

	public void aggiornaStatoPiatto(IOrdine o) {
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
