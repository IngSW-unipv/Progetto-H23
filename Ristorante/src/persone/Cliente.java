package persone;
import menu.*;
import java.util.ArrayList;

import alimenti.Piatto;
import eccezioni.PiattoFinitoException;
import ordine.*;

public class Cliente extends Persona{
	Menu menu;
	
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
	
	public void creaOrdine(Piatto p,int quantita) {
		try {
			if (p.getQuantita()-quantita < 0) {
				throw new PiattoFinitoException();
			}
			Ordine o=new Ordine();
			o.addPiatto(p, quantita);
			long t=System.currentTimeMillis();
			o.setTempo(t);
			ordini.add(o);
			p.setQuantita(p.getQuantita()-quantita);
		}
		catch(PiattoFinitoException e) {
			System.out.println(e.getMessage());
		}
			
	}
	
	public Ordine getUltimoOrdine () {
		return ordini.get(ordini.size() - 1);
	}
	
	public void scegliMenu(Menu m) {
		menu=m;
	}
	
	public double chiediConto() {
		return menu.getConto();
	}
}
