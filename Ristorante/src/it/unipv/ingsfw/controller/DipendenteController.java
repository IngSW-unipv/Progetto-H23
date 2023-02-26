package it.unipv.ingsfw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.ingsfw.model.RistoranteSingleton;
import it.unipv.ingsfw.model.alimenti.IPiatto;
import it.unipv.ingsfw.model.persone.Cliente;
import it.unipv.ingsfw.model.persone.Dipendente;
import it.unipv.ingsfw.model.ristorante.IRistorante;
import it.unipv.ingsfw.model.ristorante.Ristorante;
import it.unipv.ingsfw.view.IRistoranteGUI;
import it.unipv.ingsfw.view.RistoranteGui;

public class DipendenteController {

	private IRistoranteGUI rg;
	private RistoranteSingleton rs;
	private IRistorante r;
	//attributi ausiliari
	Dipendente d;
	boolean triggered;

	public DipendenteController(IRistoranteGUI rg, RistoranteSingleton rs) {
		super();
		this.rs=rs;
		r=rs.getRistorante();
		this.rg=rg;
		this.setDipendenteListeners();
	}

	private void setDipendenteListeners() {

		rg.getPasswordRistorante().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				char[] c=rg.getPasswordOfPasswordRistorante();
				String s=new String(c);

				if(s.equals(r.getPassword())) {
					
					//dipendente preso dal main per mostrare gli ordini arrivati
					d=r.getDipendenteByNome("Bruno");
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
				if(r.getPostiLiberi()==0)
				{
					rg.popUpErrore("Non puoi aggiungere prenotazioni,posti finiti");
				}
				else
				{
					rg.aggiungiPrenotazioneR(rs.getRistorante().getPostiLiberi());
				}
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
				rg.vediOrdiniR(d.getStringOrdini());
			}
		});

		rg.getPreparaTuttoButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				d.getStringOrdini();
				d.preparaOrdine();
				rg.setTextOfOrdini(d.getStringOrdini());
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

				if(rg.getTextOfClienteDaPrenotare().isEmpty())
				{
					rg.popUpErrore("Inserisci un nome per il cliente");
				}

				else if(rg.getValueOfValueD()==0)
				{
					rg.popUpErrore("Inserisci un numero valido per la prenotazione del cliente");
				}

				else if(r.getPrenotazioni().containsKey(rg.getTextOfClienteDaPrenotare())) {

					rg.popUpErrore("Nome già inserito");
				}
				else {

					r.prenotaCliente(new Cliente(rg.getTextOfClienteDaPrenotare()), rg.getValueOfClienteNoPrenotatoD());
					rg.setMaxOfValueD(r.getPostiLiberi());
					rg.setValueOfValueD(0);
					rg.setTextOfClienteDaPrenotare("");
				}
			}
		});

		rg.getAggiungi().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				triggered=true;
				
				for(IPiatto p:r.getPiatti()) {
					
					if(p.getNome().equals(rg.getTextOfNomePiattoField())) {
						
						p.setQuantita(p.getQuantita()+rg.getValueOfQuantitySpinner());
						triggered=false;
					}
				}

				if(triggered)
				{
					rg.popUpErrore("Piatto inesistente");

				}
				triggered=true;
				rg.setValueOfValueD(1);
				rg.setTextOfNomePiattoField("");
				rs.aggiornaPiatti();		
			}
		});
	}
}