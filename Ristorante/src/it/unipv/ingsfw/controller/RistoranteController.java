package it.unipv.ingsfw.controller;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import it.unipv.ingsfw.model.menu.ALaCarte;
import it.unipv.ingsfw.model.menu.AYCE;
import it.unipv.ingsfw.model.persone.Cliente;
import it.unipv.ingsfw.model.persone.Dipendente;
import it.unipv.ingsfw.model.ristorante.Ristorante;
import it.unipv.ingsfw.view.RistoranteGui;

public class RistoranteController {
	private RistoranteGui rg;
	private Ristorante r;
	private Dipendente d;
	private String tmp;
	//private int i;

	public RistoranteController(RistoranteGui rg,Ristorante r) {
		super();
		this.rg = rg;
		this.r=r;
		// int i = 1:
		setListeners();
	}

	public void setListeners() {

		rg.getStartButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rg.sceltaPersona();
			}
		});

		rg.getClienteButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rg.identificaClienteR();
			}
		});

		rg.getDipendenteButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rg.identificaDipendenteR();
			}
		});

		rg.getPasswordRistorante().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				char []c=rg.getPasswordRistorante().getPassword();
				String s=new String(c);

				if(s.equals(r.getPassword())) {
					d = r.creaDipendente("Dipendente");
					d.setIdentificato(true);
					rg.operazioniDipendenteR();
				}
				else {
					rg.popUpErrore("password errata");
				}
			}
		});

		rg.getAggiungiPrenotazioneButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rg.aggiungiPrenotazioneR(r.getPostiLiberi());
			}
		});

		rg.getAggiungiQuantitaButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rg.addDishR();
			}
		});

		rg.getVediOrdiniButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rg.vediOrdiniR();
			}
		});

		rg.getTornaIndietroButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rg.operazioniDipendenteR();
			}
		});

		rg.getPrenotaClienteButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				r.prenotaCliente(new Cliente(rg.getClienteDaPrenotare().getText()), (int)rg.getClienteNoPrenotatoD().getValue());
				for (Cliente c1: r.getClienti()) {
					System.out.println(c1); 
				}
			}
		});

		rg.getNomeClienteField().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = rg.getNomeClienteField().getText();
				if (r.getPrenotazioni().containsKey(s)) {
					tmp = s;
					for(Cliente c : r.getClienti()) {
						if (c.getNome().equals(tmp)) {
							c.setIdentificato(true);
						}
					}

					//Cliente c = new Cliente(s);
					//c.setIdentificato(true);
					//					for (Cliente c1: r.getClienti()) {
					//						System.out.println(c1);;
					//					}
					rg.scegliMenuR();
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
					//					Cliente c = new Cliente("Tavolo" + i);
					//					i++;
					//					c.setIdentificato(true);
					//					r.getClienti().add(c);
					rg.clienteNoPrenotatoR(r.getPostiLiberi());
				}

			}
		});

		rg.getSceltaMenuButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				r.prenotaClientenoPrenotazione((int)rg.getClienteNoPrenotato().getValue());
				//r.setPostiLiberi(r.getPostiLiberi()-(int)rg.getClienteNoPrenotato().getValue());
				System.out.println(r.getPostiLiberi());
				rg.scegliMenuR();
				for (Cliente c: r.getClienti()) {
					System.out.println(c);
				}


			}
		});

		rg.getAyceButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Cliente c : r.getClienti()) {
					if (c.getNome().equals(tmp)) {
						c.scegliMenu(new AYCE(r.getConto()));
						rg.inviaOrdineR(r.getArrayNomePiatti(),r.getArrayQuantitaPiatti());
					}
				}
			}
		});

		rg.getALaCaButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Cliente c : r.getClienti()) {
					if (c.getNome().equals(tmp)) {
						c.scegliMenu(new ALaCarte());
						rg.inviaOrdineR(r.getArrayNomePiatti(),r.getArrayQuantitaPiatti());
					}
				}
			}
		});

		rg.getPiattiMenu().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {

				ArrayList<String> nome=r.getArrayNomePiatti();
				ArrayList<Integer> quant=r.getArrayQuantitaPiatti();
				
				for(int i=0;i<nome.size();i++) {
					if(nome.get(i).equals(rg.getPiattiMenu().getSelectedValue()))
					{
						rg.getValueC().setValue(rg.getValueC().getMinimum());
						rg.getValueC().setMaximum(quant.get(i));
					}
				}
			}
		});

	}
}
