package it.unipv.ingsfw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.ingsfw.model.persone.Cliente;
import it.unipv.ingsfw.model.persone.Dipendente;
import it.unipv.ingsfw.model.ristorante.Ristorante;
import it.unipv.ingsfw.view.RistoranteGui;

public class DipendenteController {

	private RistoranteGui rg;
	private Ristorante r;
	//attributi ausiliari
	Dipendente d;

	public DipendenteController(RistoranteGui rg, Ristorante r) {
		super();
		this.r=r;
		this.rg=rg;
		this.setDipendenteListeners();
	}

	private void setDipendenteListeners() {
		
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
				//				for (Cliente c1: r.getClienti()) {
				//					System.out.println(c1); 
				//				}
			}
		});
	}
}
