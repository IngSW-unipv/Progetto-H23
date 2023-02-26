package it.unipv.ingsfw.controller;

import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import it.unipv.ingsfw.model.RistoranteSingleton;
import it.unipv.ingsfw.model.menu.ALaCarte;
import it.unipv.ingsfw.model.menu.AYCE;
import it.unipv.ingsfw.model.persone.Cliente;
import it.unipv.ingsfw.model.persone.Dipendente;
import it.unipv.ingsfw.model.ristorante.IRistorante;
import it.unipv.ingsfw.model.ristorante.Ristorante;
import it.unipv.ingsfw.view.*;

public class RistoranteController {
	
	private IRistoranteGUI rg;
	private RistoranteSingleton rs;
	private IRistorante r;
	//private Dipendente d;
	private ClienteController cc;
	private DipendenteController dc;
	//private String tmp;

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
