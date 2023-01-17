package it.unipv.ingsfw.model.persone;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import it.unipv.ingsfw.model.alimenti.*;
import it.unipv.ingsfw.model.eccezioni.NoIdentificatoException;
import it.unipv.ingsfw.model.eccezioni.PiattoFinitoException;
import it.unipv.ingsfw.model.menu.*;
import it.unipv.ingsfw.model.ordine.*;
import it.unipv.ingsfw.model.ristorante.Ristorante;

public class Cliente extends Persona{
	private IMenu menu;
	private Ristorante r;

	public Cliente(String nome) {
		super(nome);
		this.menu=null;
		this.r = null;
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
	
	

	public void creaOrdine(IPiatto p,int quantita) throws IOException {
		this.controllaPrenotazione();
		try {
			
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
		}
		catch(PiattoFinitoException e) {
			System.out.println(e.getMessage());
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
	
}
