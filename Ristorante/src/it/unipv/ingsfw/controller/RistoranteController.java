package it.unipv.ingsfw.controller;

import java.awt.event.*;

import it.unipv.ingsfw.model.ristorante.Ristorante;
import it.unipv.ingsfw.view.RistoranteGui;

public class RistoranteController {
	private RistoranteGui rg;
	private Ristorante r;

	public RistoranteController(RistoranteGui rg,Ristorante r) {
		super();
		this.rg = rg;
		this.r=r;
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
	}
	/*rg.getPasswordRistorante().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ciao");
			}

		});

		rg.getSceltaMenuButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(rg.getClienteNoPrenotato().getValue());

			}
		});

		rg.getPrenota().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(rg.getNomeCliente().getText() +  " " + rg.getClienteNoPrenotato().getValue());

			}
		});
	} */
}
