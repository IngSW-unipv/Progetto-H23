package it.unipv.ingsfw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import it.unipv.ingsfw.model.RistoranteSingleton;
import it.unipv.ingsfw.model.menu.ALaCarte;
import it.unipv.ingsfw.model.menu.AYCE;
import it.unipv.ingsfw.model.persone.Cliente;
import it.unipv.ingsfw.model.ristorante.IRistorante;

import it.unipv.ingsfw.view.IRistoranteGUI;

public class ClienteController {

	private IRistoranteGUI rg;
	private IRistorante r;
	private RistoranteSingleton rs;


	private Cliente cl;
	public ClienteController(IRistoranteGUI rg, RistoranteSingleton rs) {
		super();
		this.rs=rs;
		r=rs.getRistorante();
		this.rg=rg;
		this.setClienteListeners();
	}



	private void setClienteListeners() {

		rg.getHomeClienteButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				rg.sceltaPersona();
			}
		});

		rg.getNomeClienteField().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String s=rg.getTextNomeClienteField();
				if(r.containsKeyPrenotazioni(s)) {
					cl=new Cliente(s);
					r.addCliente(cl);
					cl.setIdentificato(true);

					rg.scegliMenuR();
					rg.setTextOfNomeClienteField("");
				}
				else 
					rg.popUpErrore("Nome prenotazione errato");
			}
		});

		rg.getNoPrenotazioneButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (r.getPostiLiberi() == 0)
					rg.popUpErrore("Posti finiti, ci dispiace");
				else {
					rg.clienteNoPrenotatoR(r.getPostiLiberi());
					rg.setTextOfNomeClienteField("");
				}

			}
		});

		rg.getSceltaMenuButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				cl=r.prenotaClientenoPrenotazione(rg.getValueClienteNoPrenotato());
				r.addCliente(cl);

				rg.scegliMenuR();
			}
		});

		rg.getAyceButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.scegliMenu(new AYCE(r.getConto()));
				rg.inviaOrdineR(r.getArrayNomeePrezzoPiatti(),r.getArrayQuantitaPiatti());

			}
		});

		rg.getALaCaButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.scegliMenu(new ALaCarte());
				rg.inviaOrdineR(r.getArrayNomeePrezzoPiatti(),r.getArrayQuantitaPiatti());

			}
		});

		rg.getPiattiMenu().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {

				ArrayList<String> nome=r.getArrayNomeePrezzoPiatti();
				ArrayList<Integer> quant=r.getArrayQuantitaPiatti();

				for(int i=0;i<nome.size();i++) {
					if(nome.get(i).equals(rg.getPiattiMenu().getSelectedValue()))
					{
						rg.setValueOfValueC(rg.getMinimumOfValueC());
						rg.setMaxOfValueC(quant.get(i));
					}
				}
			}
		});

		rg.getinviaOrdineButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=rg.getSelectedIndexOfPiattiMenu();

				if(rg.getSelectedValueOfPiattiMenu()==null)
				{
					rg.popUpErrore("Seleziona un piatto!");
				}

				else if(r.getElementOfPiatti(i).getQuantita()==0) {

					rg.popUpErrore("Piatto finito!");

				}
				else if (rg.getValueOfValueC()==0) {
					rg.popUpErrore("Seleziona una quantit� valida");
				}
				else {
					try {
						rs.diminuisciQuantita(r.getElementOfPiatti(i), rg.getValueOfQuantPiattoSpinner());
						cl.creaOrdine(r.getElementOfPiatti(i), rg.getValueOfQuantPiattoSpinner());
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					rg.setTextOfTotale(rg.getDefaultTextOfTotale()+cl.chiediConto());

					if(r.getElementOfPiatti(i).getQuantita()==0)
					{
						rg.azzeraValueC();
					}

					rg.setMaxOfValueC(r.getElementOfPiatti(i).getQuantita());
					rg.setValueOfValueC(0);
				}
			}


		});
		rg.getChiediContoButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cl.getSizeOfOrdini()==0) {
					rg.popUpErrore("Prima devi ordinare");
				}
				else {
					r.rimuoviCliente(cl);
					rg.sceltaPersona();
					rs.cancellaPrenotazione(cl.getNome());
					//riazzero gli elementi per un prossimo cliente
					cl=null;
					rg.setTextOfTotale(rg.getDefaultTextOfTotale());
				}
			}
		});	
	}
}