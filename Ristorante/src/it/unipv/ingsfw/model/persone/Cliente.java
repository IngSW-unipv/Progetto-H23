package it.unipv.ingsfw.model.persone;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import it.unipv.ingsfw.model.alimenti.*;
import it.unipv.ingsfw.model.eccezioni.InvalidQuantityException;
import it.unipv.ingsfw.model.eccezioni.NoIdentificatoException;
import it.unipv.ingsfw.model.eccezioni.PiattoFinitoException;
import it.unipv.ingsfw.model.menu.*;
import it.unipv.ingsfw.model.ordine.*;
import it.unipv.ingsfw.model.ristorante.Ristorante;

public class Cliente extends Persona{
	private IMenu menu;


	public Cliente(String nome) {
		super(nome);
		this.menu=null;
	}

	public boolean accediPrenotazione(Map<String, Integer> m) throws IOException {	
		InputStreamReader input=new InputStreamReader(System.in);
		BufferedReader t=new BufferedReader(input);
		System.out.print("Inserisci nome prenotazione: ");
		String tmp=t.readLine();
		if(m.containsKey(tmp)) {
			System.out.println("ok");
			identificato = true;
		}
		else

			identificato = false;
		this.controllaPrenotazione();
		return identificato;
		
	}
	
	

	public boolean creaOrdine(IPiatto p,int quantita) throws IOException {
		
		boolean ordineCorretto=false;
		this.controllaPrenotazione();
		try {
			if(quantita<1)
				throw new InvalidQuantityException();
			if (p.getQuantita()-quantita < 0) {
				throw new PiattoFinitoException();
			}
			Ordine o=new Ordine();
			o.addPiatto(p, quantita);
			this.aggiornaConto(o);
			long t=System.currentTimeMillis();
			o.setTempo(t);
			ordini.add(o);
			p.setQuantita(p.getQuantita()-quantita);
			ordineCorretto=true;
			return ordineCorretto;
		}
		
		catch(InvalidQuantityException e) {
			System.out.println(e.getMessage());
			return ordineCorretto;
		}
		
		catch(PiattoFinitoException e) {
			System.out.println(e.getMessage());
			return ordineCorretto;
		}
	}



	public IOrdine getUltimoOrdine () {
		return ordini.get(ordini.size() - 1);
	}

	public void scegliMenu(IMenu m) {
		this.controllaPrenotazione();
		menu=m;
	}

	public double chiediConto() {
		this.controllaPrenotazione();
		return menu.getConto();
	}

	public void aggiornaConto(IOrdine o) {
		double costoTmp=0;
		for(IPiatto p:o.getPiattiOrdinati()) {
			costoTmp+=p.getPrezzo();
		}
		menu.setConto(menu.getConto()+costoTmp);
	}
	
	public IMenu getMenu() {
		return menu;
	}

	@Override
	public String toString() {
		return getNome();
	}
	
}
