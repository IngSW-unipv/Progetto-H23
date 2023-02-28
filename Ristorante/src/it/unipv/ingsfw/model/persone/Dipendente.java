package it.unipv.ingsfw.model.persone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import it.unipv.ingsfw.model.alimenti.IPiatto;
import it.unipv.ingsfw.model.ordine.IOrdine;

public class Dipendente extends Persona{
	boolean logIn1;
	private String ordiniString;


	private ArrayList<IOrdine> ordiniAusiliario;

	public Dipendente(String nome) {
		super(nome);
		logIn1=true;
		identificato = false;
		ordiniAusiliario = new ArrayList<>();
		this.ordiniString = "";
	}


	public boolean identificati(String s) throws IOException {
		InputStreamReader input=new InputStreamReader(System.in);
		BufferedReader t=new BufferedReader(input);
		System.out.print("Inserisci password ristorante: ");
		String tmp=t.readLine();
		if(tmp.equals(s)) {
			System.out.println("ok");
			identificato = true;
		}

		else {
			identificato = false;

		}
		this.controllaPrenotazione();
		return identificato;
	}

	public void addQuantitaPiatto(IPiatto p,int quantita) {
		this.controllaPrenotazione();
		p.incrementaQuantita(quantita);
	}



	public void aggiungiOrdini(ArrayList<Cliente> clienti) {
		this.controllaPrenotazione();
		for (Cliente c: clienti) {
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

		ordiniAusiliario.clear();
	}

	public void aggiornaStatoPiatto(IOrdine o) {
		this.controllaPrenotazione();
		o.setStato(true);
		System.out.println("ordine in arrivo!");
	}

	public void preparaOrdine() {
		this.controllaPrenotazione();
		for (int i = 0; i<ordini.size(); i++) {

			aggiornaStatoPiatto(ordini.get(i));

		}
		ordini.clear();
	}
	public String getStringOrdini() {
		ordiniString = "";
		for (IOrdine o: ordini) {
			ordiniString=ordiniString+o.getNomiPiattiOrdinati()+ " " +  "\n\n";
		}
		return ordiniString;
	}
	
	
}
