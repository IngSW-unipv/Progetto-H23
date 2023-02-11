package it.unipv.ingsfw.controller;

import java.awt.event.*;

import it.unipv.ingsfw.view.RistoranteGui;

public class RistoranteController {
	private RistoranteGui rg;

	public RistoranteController(RistoranteGui rg) {
		super();
		this.rg = rg;
		//setListeners();
	}

	/* public void setListeners() {
		 rg.getStartButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rg.sceltaPersona();
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
