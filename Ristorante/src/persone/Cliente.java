package persone;
import menu.*;
import java.util.ArrayList;

import alimenti.Piatto;
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
		Ordine o=new Ordine();
		o.addPiatto(p, quantita);
		long t=System.currentTimeMillis();
		o.setTempo(t);
		ordini.add(o);
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
