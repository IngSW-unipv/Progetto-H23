package it.unipv.ingsfw.main;

import java.io.IOException;

import it.unipv.ingsfw.controller.RistoranteController;
import it.unipv.ingsfw.model.RistoranteSingleton;
import it.unipv.ingsfw.model.menu.ALaCarte;
import it.unipv.ingsfw.model.menu.AYCE;
import it.unipv.ingsfw.model.ordine.IOrdine;
import it.unipv.ingsfw.model.persone.Cliente;
import it.unipv.ingsfw.model.persone.Dipendente;
import it.unipv.ingsfw.model.ristorante.IRistorante;
import it.unipv.ingsfw.view.RistoranteGui;

public class RistoranteStarter {

	public RistoranteStarter() {
		super();
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		RistoranteSingleton rs= RistoranteSingleton.getSingleton();
		IRistorante r=rs.getRistorante();

//		Cliente c1 = new Cliente ("Fabio");
//		Cliente c2 = new Cliente ("Zoe");
//		r.addCliente(c1);
//		r.addCliente(c2);
//
//		c1.setIdentificato(true);
//		c2.setIdentificato(true);
//
//		c1.scegliMenu(new ALaCarte());
//		c2.scegliMenu(new AYCE(r.getConto()));
//
//		c1.creaOrdine(r.getElementOfPiatti(5), 4);
//		Thread.sleep(1);
//		c1.creaOrdine(r.getElementOfPiatti(9), 7);
//		Thread.sleep(1);
//		c1.creaOrdine(r.getElementOfPiatti(9), 1);
//		Thread.sleep(1);
//		c2.creaOrdine(r.getElementOfPiatti(6), 9);
//		Thread.sleep(1);
//		c2.creaOrdine(r.getElementOfPiatti(4), 8);

		RistoranteGui rg=new RistoranteGui();
		RistoranteController rc=new RistoranteController(rg,rs);
	}
}