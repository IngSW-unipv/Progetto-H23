package it.unipv.ingsfw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import it.unipv.ingsfw.jdbc.bean.IPrenotazioneDAO;
import it.unipv.ingsfw.jdbc.bean.PrenotazioneDAO;
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
	private IRistorante r;
	private RistoranteSingleton rs;

	//attributi temporanei per aiutarci nella risoluzione di listeners
	String tmp;
	int i;
	Cliente c,daiMenu;
	public ClienteController(IRistoranteGUI rg, RistoranteSingleton rs) {
		super();
		this.rs=rs;
		r=rs.getRistorante();
		this.rg=rg;
		this.setClienteListeners();
	}

	private void setClienteListeners() {

		rg.getNomeClienteField().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//s = rg.getNomeClienteField().getText();
				String s=rg.getTextNomeClienteField();
				if (r.getPrenotazioni().containsKey(s)) {
					tmp = s;

					ArrayList<String> nomiClienti=rs.selezionaNomi();

					for(int i=0;i<nomiClienti.size();i++) {

						if(nomiClienti.get(i).equals(tmp)) {
							Cliente cl=new Cliente(nomiClienti.get(i));
							r.getClienti().add(cl);
						}
					}
					for(Cliente c : r.getClienti()) {
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
				if (r.getPostiLiberi() == 0)
					rg.popUpErrore("Posti finiti, ci dispiace");
				else {
					rg.clienteNoPrenotatoR(r.getPostiLiberi());
					rg.setTextOfNomeClienteField("");
				}

			}
		});

		rg.getSceltaMenuButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				c=r.prenotaClientenoPrenotazione(rg.getValueClienteNoPrenotato());
				tmp = c.getNome();
				rg.scegliMenuR();
			}
		});

		rg.getAyceButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Cliente c : r.getClienti()) {
					if (c.getNome().equals(tmp)) {
						c.scegliMenu(new AYCE(r.getConto()));
						rg.inviaOrdineR(r.getArrayNomeePrezzoPiatti(),r.getArrayQuantitaPiatti());
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
						rg.inviaOrdineR(r.getArrayNomeePrezzoPiatti(),r.getArrayQuantitaPiatti());
					}
				}
			}
		});

		rg.getPiattiMenu().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {

				ArrayList<String> nome=r.getArrayNomeePrezzoPiatti();
				ArrayList<Integer> quant=r.getArrayQuantitaPiatti();

				for(int i=0;i<nome.size();i++) {
					if(nome.get(i).equals(rg.getPiattiMenu().getSelectedValue()))
					{
						rg.setValueOfValueC(rg.getMinimumOfValueC());
						rg.setMaxOfValueC(quant.get(i));
					}
				}
			}
		});

		rg.getinviaOrdineButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				i=rg.getSelectedIndexOfPiattiMenu();

				if(rg.getSelectedValueOfPiattiMenu()==null)
				{
					rg.popUpErrore("Seleziona un piatto!");
				}

				else if(r.getElementOfPiatti(i).getQuantita()==0) {

					rg.popUpErrore("Piatto finito!");

				}
				else if (rg.getValueOfValueC()==0) {
					rg.popUpErrore("Seleziona una quantità valida");
				}
				else {
					for(Cliente c : r.getClienti()) {
						if(tmp.equals(c.getNome()))
							daiMenu=c;
					}
					try {
						daiMenu.creaOrdine(r.getElementOfPiatti(i), rg.getValueOfQuantPiattoSpinner());
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					rg.setTextOfTotale("Totale :"+daiMenu.chiediConto());

					if(r.getElementOfPiatti(i).getQuantita()==0)
					{
						rg.azzeraValueC();
					}

					rg.setMaxOfValueC(r.getElementOfPiatti(i).getQuantita());
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
					r.rimuoviCliente(daiMenu);
					rg.sceltaPersona();
					rs.cancellaPrenotazione(daiMenu.getNome());
					//riazzero gli elementi per un prossimo cliente
					c=null;
					daiMenu=null;
					rg.setTextOfTotale("Totale :");
					rs.aggiornaPiatti();
				}
			}
		});	
	}
}