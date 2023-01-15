package it.unipv.ingsfw.main.test;

import java.util.ArrayList;

import it.unipv.ingsfw.model.alimenti.*;
import it.unipv.ingsfw.model.menu.ALaCarte;
import it.unipv.ingsfw.model.menu.AYCE;
import it.unipv.ingsfw.model.menu.IMenu;
import it.unipv.ingsfw.model.menu.Menu;
import it.unipv.ingsfw.model.ordine.Ordine;
import it.unipv.ingsfw.model.persone.Cliente;
import it.unipv.ingsfw.model.persone.Dipendente;
import it.unipv.ingsfw.model.ristorante.Ristorante;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Ristorante r = new Ristorante ("NOME", "PASSWORD");
		r.creaDipendente("Paolo");
		r.creaDipendente("Agostino");
		r.creaDipendente("Sabatino");
		ArrayList<Dipendente> d = r.getDipendenti();

		Cliente c1 = new Cliente ("GinoPippo");
		Cliente c2 = new Cliente ("Pippo");
		Cliente c3 = new Cliente ("Franceschina");

		r.prenotaCliente(c1, 300);
		r.prenotaCliente(c2,  1);
		r.prenotaCliente(c3, 10);

		System.out.println(r.getPostiLiberi());
		for (Dipendente dip: r.getDipendenti() ) {
			System.out.println(dip.getNome());
			System.out.println(dip.getPasssword());
		}
		
		IMenu m = new AYCE(30);
		IMenu m1=new ALaCarte();
		
		c1.scegliMenu(m);
		c2.scegliMenu(m1);
		c3.scegliMenu(m1);

		IPiatto p1 = new Primo(16.50, "Pizza margherita", 6);
		IPiatto p2 = new Secondo (10.00, "Fritto misto", 4);
		IPiatto p3 = new Antipasto (8.50, "Patatine piccole", 2);

		System.out.println(p1.getQuantita());

		//d.get(1).addQuantitaPiatto(p1, 4);

		//System.out.println(p1.getQuantita());


		c2.creaOrdine(p3, 1);
		Thread.sleep(1);
		c2.creaOrdine(p2, 2);
		Thread.sleep(1);
		c3.creaOrdine(p1, 1);
		Thread.sleep(1);
		

		/*for (Ordine o: c1.getOrdini() ) {
			o.stampaPiattiOrdinati();


		}
		 */
		Dipendente d1 = d.get(1);

	
		d1.aggiungiOrdini();

		//d1.stampaOrdini();

		System.out.println("----------");

		/*for (Ordine o: d1.getOrdini()) {
			System.out.println(o.getTempo());
		}
*/
		Thread.sleep(1);
		c3.creaOrdine(p3, 1);
		Thread.sleep(1);
		c2.creaOrdine(p2, 1);
		Thread.sleep(1);
		c1.creaOrdine(p2, 3);
		Thread.sleep(1);

		System.out.println("------------");
		 




		//c1.stampaOrdini();
		//c2.stampaOrdini();
		//c3.stampaOrdini();

		d1.aggiungiOrdini();

		/*for (Ordine o: d1.getOrdini()) {
			System.out.println(o.getTempo());
		}

		System.out.println("--------");

		for (Ordine o: c1.getOrdini()) {
			System.out.println(o.getTempo());
		}

		System.out.println("--------");

		for (Ordine o: c2.getOrdini()) {
			System.out.println(o.getTempo());
		}
		System.out.println("--------");

		for (Ordine o: c3.getOrdini()) {
			System.out.println(o.getTempo());
		}
		*/

		//d1.stampaOrdini();




		//d1.aggiungiOrdini();
		
		d1.preparaOrdine();
		System.out.println(p1.getQuantita());
		
		c3.creaOrdine(p1, 100);
		d1.aggiungiOrdini();
		d1.preparaOrdine();
		System.out.println(p1.getQuantita());
		
		d1.preparaOrdine();
		System.out.println(p1.getQuantita());
		
		System.out.println(c1.chiediConto());
		System.out.println(c2.chiediConto());


	}
}
