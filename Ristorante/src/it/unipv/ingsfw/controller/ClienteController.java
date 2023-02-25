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
import it.unipv.ingsfw.model.ristorante.Ristorante;
import it.unipv.ingsfw.view.IRistoranteGUI;
import it.unipv.ingsfw.view.RistoranteGui;

public class ClienteController {

	private IRistoranteGUI rg;
	private RistoranteSingleton rs;

	//attributi temporanei per aiutarci nella risoluzione di listeners
	String s,tmp;
	int i;
	Cliente c,daiMenu;
	public ClienteController(IRistoranteGUI rg, RistoranteSingleton r) {
		super();
		this.rs=r;
		this.rg=rg;
		this.setClienteListeners();
	}

	private void setClienteListeners() {

		rg.getNomeClienteField().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//s = rg.getNomeClienteField().getText();
				s=rg.getTextNomeClienteField();
				if (rs.getRistorante().getPrenotazioni().containsKey(s)) {
					tmp = s;
					for(Cliente c : rs.getRistorante().getClienti()) {
						if (c.getNome().equals(tmp)) {
							c.setIdentificato(true);
						}
					}
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
				if (rs.getRistorante().getPostiLiberi() == 0)
					rg.popUpErrore("Posti finiti, ci dispiace");
				else {
					rg.clienteNoPrenotatoR(rs.getRistorante().getPostiLiberi());
					rg.setTextOfNomeClienteField("");
				}

			}
		});

		rg.getSceltaMenuButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				///*Cliente*/ c = r.prenotaClientenoPrenotazione((int)rg.getClienteNoPrenotato().getValue());
				c=rs.getRistorante().prenotaClientenoPrenotazione(rg.getValueClienteNoPrenotato());
				tmp = c.getNome();
				rg.scegliMenuR();


			}
		});

		rg.getAyceButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Cliente c : rs.getRistorante().getClienti()) {
					if (c.getNome().equals(tmp)) {
						c.scegliMenu(new AYCE(rs.getRistorante().getConto()));
						rg.inviaOrdineR(rs.getRistorante().getArrayNomeePrezzoPiatti(),rs.getRistorante().getArrayQuantitaPiatti());
					}
				}
			}
		});

		rg.getALaCaButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Cliente c : rs.getRistorante().getClienti()) {
					if (c.getNome().equals(tmp)) {
						c.scegliMenu(new ALaCarte());
						rg.inviaOrdineR(rs.getRistorante().getArrayNomeePrezzoPiatti(),rs.getRistorante().getArrayQuantitaPiatti());
					}
				}
			}
		});

		rg.getPiattiMenu().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {

				ArrayList<String> nome=rs.getRistorante().getArrayNomeePrezzoPiatti();
				ArrayList<Integer> quant=rs.getRistorante().getArrayQuantitaPiatti();

				for(int i=0;i<nome.size();i++) {
					if(nome.get(i).equals(rg.getPiattiMenu().getSelectedValue()))
					{
						//rg.getValueC().setValue(rg.getValueC().getMinimum());
						rg.setValueOfValueC(rg.getMinimumOfValueC());
						//rg.getValueC().setMaximum(quant.get(i));
						rg.setMaxOfValueC(quant.get(i));
					}
				}
			}
		});

		rg.getinviaOrdineButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				///*int*/ i=rg.getPiattiMenu().getSelectedIndex();
				i=rg.getSelectedIndexOfPiattiMenu();

				//aggiungere eccezione
				//if(rg.getPiattiMenu().getSelectedValue()==null)
				if(rg.getSelectedValueOfPiattiMenu()==null)
				{
					rg.popUpErrore("Seleziona un piatto!");
				}

				//else if(r.getPiatti().get(i).getQuantita()==0) {
				else if(rs.getRistorante().getElementOfPiatti(i).getQuantita()==0) {

					rg.popUpErrore("Piatto finito!");

				}
				//else if ((int)rg.getValueC().getValue() == 0) {
				else if (rg.getValueOfValueC()==0) {
					rg.popUpErrore("Seleziona una quantità valida");
				}
				else {
					for(Cliente c : rs.getRistorante().getClienti()) {
						if(tmp.equals(c.getNome()))
							daiMenu=c;
					}

					try {
						//creo l'ordine per quel cliente
						//daiMenu.creaOrdine(r.getPiatti().get(i), (int)rg.getQuantPiattoSpinner().getValue());
						daiMenu.creaOrdine(rs.getRistorante().getElementOfPiatti(i), rg.getValueOfQuantPiattoSpinner());

					} catch (IOException e1) {
						e1.printStackTrace();
					}

					//rg.getTotale().setText("Totale :"+daiMenu.chiediConto());
					rg.setTextOfTotale("Totale :"+daiMenu.chiediConto());
					//if(r.getPiatti().get(i).getQuantita()==0)
					if(rs.getRistorante().getElementOfPiatti(i).getQuantita()==0)
					{
						rg.azzeraValueC();
					}
					//rg.getValueC().setMaximum(r.getPiatti().get(i).getQuantita());
					rg.setMaxOfValueC(rs.getRistorante().getElementOfPiatti(i).getQuantita());
					//rg.getValueC().setValue(0);
					rg.setValueOfValueC(0);
				}
			}


		});
		rg.getChiediContoButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (daiMenu == null) {
					rg.popUpErrore("Prima devi ordinare");
				}
				else {
					rs.getRistorante().rimuoviCliente(daiMenu);
					System.out.println(rs.getRistorante().getPostiLiberi());
					rg.sceltaPersona();
					
					//rs.cancellaPrenotazione(daiMenu.getNome());
					//riazzero gli elementi per un prossimo cliente
					c=null;
					daiMenu=null;
					rg.setTextOfTotale("Totale :");
					// aggiungere pagina di fine
				}
			}
		});	
	}
}