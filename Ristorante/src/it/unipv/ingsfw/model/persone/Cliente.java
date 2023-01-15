package it.unipv.ingsfw.model.persone;
import java.util.ArrayList;

import it.unipv.ingsfw.model.alimenti.*;
import it.unipv.ingsfw.model.eccezioni.PiattoFinitoException;
import it.unipv.ingsfw.model.menu.*;
import it.unipv.ingsfw.model.ordine.*;

public class Cliente extends Persona{
	IMenu menu;
	
	public Cliente(String nome) {
		super(nome);
		this.menu=null;
	}
	
	@Override
	public boolean identificati() {
		//da definire
		return false;
	}
	
	public boolean prenota(String nome, int numeroPersone) {
		//da finire
		return false;
	}
	
	public void creaOrdine(IPiatto p,int quantita) {
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
		menu=m;
	}
	
	public double chiediConto() {
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
