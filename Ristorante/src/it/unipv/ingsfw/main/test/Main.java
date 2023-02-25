package it.unipv.ingsfw.main.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import it.unipv.ingsfw.controller.RistoranteController;
import it.unipv.ingsfw.jdbc.bean.PiattoDAO;
import it.unipv.ingsfw.model.RistoranteSingleton;
import it.unipv.ingsfw.model.alimenti.*;
import it.unipv.ingsfw.model.menu.ALaCarte;
import it.unipv.ingsfw.model.menu.AYCE;
import it.unipv.ingsfw.model.menu.IMenu;
import it.unipv.ingsfw.model.ordine.IOrdine;
import it.unipv.ingsfw.model.persone.Cliente;
import it.unipv.ingsfw.model.persone.Dipendente;
import it.unipv.ingsfw.model.ristorante.Ristorante;
import it.unipv.ingsfw.view.RistoranteGui;

public class Main {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Ristorante r = new Ristorante ("NOME", "PASS");
		RistoranteSingleton rs= RistoranteSingleton.getSingleton();
		Ristorante r=rs.getRistorante();
		r.stampaPiatti();
		r.stampaPrenotazioni();

		Cliente c1 = new Cliente ("GinoPippo");
		Cliente c2 = new Cliente ("Pippo");
		Cliente c3 = new Cliente ("Franceschina");

		r.prenotaCliente(c1, 300);
		r.prenotaCliente(c2,  101);

		r.stampaPrenotazioni();

		r.prenotaCliente(c3, 81);

		r.stampaPrenotazioni();

		//se nomi diversi prezzi non allineati
//		IPiatto p1=new Antipasto(4, "pgggggggggggg1", 6);
//		IPiatto p2=new Antipasto(3, "p2", 7);
//		IPiatto p3=new Antipasto(5, "p3", 8);

//		rs.getRistorante().addPiatto(p1);
//		rs.getRistorante().addPiatto(p2);
//		rs.getRistorante().addPiatto(p3);

		r.prenotaClientenoPrenotazione(1);
		r.prenotaClientenoPrenotazione(2);
		r.prenotaClientenoPrenotazione(6);

		//scommentare qua sotto per provare vediOrdini(se c'è devi identificarti prima di fare apparire la gui)

		Dipendente d1 = r.creaDipendente("Paolo");
		//		d1.identificati(r.getPassword());
		d1.setIdentificato(true);
		c1.scegliMenu(new ALaCarte());
		c2.scegliMenu(new ALaCarte());
		c3.scegliMenu(new ALaCarte());

		c1.creaOrdine(r.getElementOfPiatti(5), 4);
		Thread.sleep(1);
		c3.creaOrdine(r.getElementOfPiatti(9), 7);
		Thread.sleep(1);
		c1.creaOrdine(r.getElementOfPiatti(9), 1);
		Thread.sleep(1);
		c2.creaOrdine(r.getElementOfPiatti(6), 9);
		Thread.sleep(1);
		c2.creaOrdine(r.getElementOfPiatti(4), 8);
		Thread.sleep(1);
		c3.creaOrdine(r.getElementOfPiatti(8), 1);
		Thread.sleep(1);
		c1.creaOrdine(r.getElementOfPiatti(2), 2);

		d1.aggiungiOrdini(r.getClienti());
		for (IOrdine o: c1.getOrdini() ) {
			o.stampaPiattiOrdinati();
		}

		
		
		//d1.stampaOrdini();
		//System.out.println(d1.getStringOrdini());

		//System.out.println("\n\n\n\n\n\n");
		//System.out.println(s);

		RistoranteGui rg=new RistoranteGui();
		RistoranteController rc=new RistoranteController(rg,rs);

		//r.creaDipendente("Agostino");
		//r.creaDipendente("Sabatino");
		//ArrayList<Dipendente> d = r.getDipendenti();
		//		c1.accediPrenotazione(r.getPrenotazioni());
		//		c2.accediPrenotazione(r.getPrenotazioni());
		//		c3.accediPrenotazione(r.getPrenotazioni());

		//		System.out.println(r.getPrenotazioni());
		/*
		System.out.println(r.getPostiLiberi());
		for (Dipendente dip: r.getDipendenti() ) {
			System.out.println(dip.getNome());

		}

		IMenu m = new AYCE(30);
		IMenu m1=new ALaCarte();

		IPiatto p1 = new Primo(16.50, "Pizza margherita", 6);
		IPiatto p2 = new Secondo (10.00, "Fritto misto", 4);
		IPiatto p3 = new Antipasto (8.50, "Patatine piccole", 2);

		System.out.println(p1.getQuantita());

		//d.get(1).addQuantitaPiatto(p1, 4);

		//System.out.println(p1.getQuantita());
		Dipendente d1 = d.get(1);

		//d1.identificati(r.getPassword());
		c1.accediPrenotazione(r.getPrenotazioni());
		c2.accediPrenotazione(r.getPrenotazioni());
		c3.accediPrenotazione(r.getPrenotazioni());

		c1.scegliMenu(m);
		c2.scegliMenu(m1);
		c3.scegliMenu(m1);


		c2.creaOrdine(p3, 1);
		Thread.sleep(1);
		c2.creaOrdine(p2, 2);
		Thread.sleep(1);
		c3.creaOrdine(p1, 1);
		Thread.sleep(1);


		for (IOrdine o: c1.getOrdini() ) {
			o.stampaPiattiOrdinati();
		}

		for (IOrdine o: c2.getOrdini() ) {
			o.stampaPiattiOrdinati();
		}

		for (IOrdine o: c3.getOrdini() ) {
			o.stampaPiattiOrdinati();
		}

		d1.aggiungiOrdini(r.getClienti());

		//d1.stampaOrdini();

		System.out.println("----------");

		/*for (Ordine o: d1.getOrdini()) {
			System.out.println(o.getTempo());
		}
		 */
		/*Thread.sleep(1);
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
		/*
		d1.preparaOrdine();
		System.out.println(p1.getQuantita());

		c3.creaOrdine(p1, 100);
		d1.aggiungiOrdini(r.getClienti());
		d1.preparaOrdine();
		System.out.println(p1.getQuantita());

		d1.preparaOrdine();
		System.out.println(p1.getQuantita());

		System.out.println(c1.chiediConto());
		System.out.println(c2.chiediConto());

		 */
	}
}
