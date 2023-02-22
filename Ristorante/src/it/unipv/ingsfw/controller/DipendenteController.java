package it.unipv.ingsfw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.ingsfw.model.alimenti.IPiatto;
import it.unipv.ingsfw.model.persone.Cliente;
import it.unipv.ingsfw.model.persone.Dipendente;
import it.unipv.ingsfw.model.ristorante.Ristorante;
import it.unipv.ingsfw.view.RistoranteGui;

public class DipendenteController {

	private RistoranteGui rg;
	private Ristorante r;
	//attributi ausiliari
	Dipendente d;
	boolean triggered;

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
					//d = r.creaDipendente("Dipendente");
				d=r.getDipendenteByNome("Paolo");
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
				rg.vediOrdiniR(d.getStringOrdini());
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

				if(rg.getClienteDaPrenotare().getText().isEmpty())
				{
					rg.popUpErrore("Inserisci un nome per il cliente");
				}
				else if((int)rg.getValueD().getValue()==0)
				{
					rg.popUpErrore("Inserisci un numero valido per la prenotazione del cliente");
				}

				else if(r.getPrenotazioni().containsKey(rg.getClienteDaPrenotare().getText())){

					rg.popUpErrore("Nome già inserito");
				}
				else {
					r.stampaPrenotazioni();
					System.out.println("\n");
					r.prenotaCliente(new Cliente(rg.getClienteDaPrenotare().getText()), (int)rg.getClienteNoPrenotatoD().getValue());
					r.stampaPrenotazioni();
					System.out.println("\n\n\n\n");
					rg.getValueD().setMaximum(r.getPostiLiberi());
					rg.getValueD().setValue(0);
				}
			}
		});

		rg.getAggiungi().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				triggered=true;
				r.stampaPiatti();
				for(IPiatto p:r.getPiatti()) {
					if(p.getNome().equals(rg.getNomePiattoField().getText())) {
						p.setQuantita(p.getQuantita()+(int)rg.getQuantitySpinner().getValue());
						triggered=false;
					}
				}
				
				if(triggered)
				{
					rg.popUpErrore("Piatto inesistente");
					
				}
				triggered=true;
				//if(p.getNome().equals(rg.getNomePiattoField().getText()))
				r.stampaPiatti();
				rg.getValueD().setValue(1);
			}
		});

	}
}