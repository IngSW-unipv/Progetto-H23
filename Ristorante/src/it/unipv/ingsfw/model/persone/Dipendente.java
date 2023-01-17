package it.unipv.ingsfw.model.persone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import it.unipv.ingsfw.model.alimenti.IPiatto;
import it.unipv.ingsfw.model.alimenti.Piatto;
import it.unipv.ingsfw.model.eccezioni.NoIdentificatoException;
import it.unipv.ingsfw.model.ordine.IOrdine;
import it.unipv.ingsfw.model.ordine.Ordine;
import it.unipv.ingsfw.model.ristorante.Ristorante;

public class Dipendente extends Persona{
	private Ristorante r;
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
	public void identificati(Ristorante r) throws IOException {
		InputStreamReader input=new InputStreamReader(System.in);
		BufferedReader t=new BufferedReader(input);
		System.out.print("Inserisci password ristorante: ");
		String tmp=t.readLine();
		if(tmp.equals(r.getPassword())) {
			System.out.println("ok");
			identificato = true;
		}

		else {
			identificato = false;

		}
		this.controllaPrenotazione();

	}

	public void addQuantitaPiatto(IPiatto p,int quantita) {
		this.controllaPrenotazione();
		p.incrementaQuantita(quantita);
	}



	public void aggiungiOrdini() {
		this.controllaPrenotazione();
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
		this.controllaPrenotazione();
		o.setStato(true);
		System.out.println("ordine in arrivo!");
	}

	public String getPasssword() {
		return r.getPassword();
	}

	public void preparaOrdine() {
		this.controllaPrenotazione();
		for (int i = contPiatti; i<ordini.size(); i++) {

			aggiornaStatoPiatto(ordini.get(i));
		}
		contPiatti = ordini.size();
	}
}
