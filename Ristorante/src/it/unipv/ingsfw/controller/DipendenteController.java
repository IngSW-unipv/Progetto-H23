package it.unipv.ingsfw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.ingsfw.model.RistoranteSingleton;
import it.unipv.ingsfw.model.alimenti.IPiatto;
import it.unipv.ingsfw.model.persone.Cliente;
import it.unipv.ingsfw.model.persone.Dipendente;
import it.unipv.ingsfw.model.ristorante.IRistorante;
import it.unipv.ingsfw.view.IRistoranteGUI;

public class DipendenteController {

	private IRistoranteGUI rg;
	private RistoranteSingleton rs;
	private IRistorante r;
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
					//d.setIdentificato(true);
					
					rg.operazioniDipendenteR();
					rg.getPostiLiberiLabel().setText("Posti liberi: "+r.getPostiLiberi());
					rg.getClientiPrenotatiLabel().setText("Tavoli prenotati: "+ r.getPrenotazioni().size());
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
		
//		rg.getVediPrenotazioniButton().addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println(r.prenotazioni());
//				rg.getPrenotazioniArea().setText("");
//				rg.vediPrenotazioniR(r.prenotazioni());	
//			}
//		});

		rg.getPreparaTuttoButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				d.getStringOrdini();
				d.preparaOrdine();
				rg.setTextOfOrdini(d.getStringOrdini());
			}
		});

		rg.getHomeButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				rg.sceltaPersona();
			}
		});
		
		rg.getTornaIndietroButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rg.operazioniDipendenteR();
				rg.getPostiLiberiLabel().setText("Posti liberi: "+r.getPostiLiberi());
				rg.getClientiPrenotatiLabel().setText("Tavoli prenotati "+ r.getPrenotazioni().size());
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

					rg.popUpErrore("Nome gi� inserito");
				}
				else {

					r.prenotaCliente(new Cliente(rg.getTextOfClienteDaPrenotare()), rg.getValueOfClienteNoPrenotatoD());
					rs.inserisciCliente(rg.getTextOfClienteDaPrenotare(), rg.getValueOfClienteNoPrenotatoD());
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
						rs.aggiungiQuantita(p, p.getQuantita());
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
			}
		});
	}
}