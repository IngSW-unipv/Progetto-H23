package it.unipv.ingsfw.controller;

import java.awt.event.*;

import it.unipv.ingsfw.model.RistoranteSingleton;
import it.unipv.ingsfw.model.ristorante.IRistorante;
import it.unipv.ingsfw.view.*;

public class RistoranteController {

	private IRistoranteGUI rg;
	private RistoranteSingleton rs;
	private IRistorante r;
	private ClienteController cc;
	private DipendenteController dc;

	public RistoranteController(IRistoranteGUI rg, RistoranteSingleton rs) {
		super();
		this.rg = rg;
		this.rs=rs;
		r=rs.getRistorante();
		this.cc=new ClienteController(rg,rs);
		this.dc=new DipendenteController(rg,rs);
		setListeners();
	}

	private void setListeners() {

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
	}
}
