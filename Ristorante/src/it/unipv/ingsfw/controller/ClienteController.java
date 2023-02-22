package it.unipv.ingsfw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import it.unipv.ingsfw.model.menu.ALaCarte;
import it.unipv.ingsfw.model.menu.AYCE;
import it.unipv.ingsfw.model.persone.Cliente;
import it.unipv.ingsfw.model.ristorante.Ristorante;
import it.unipv.ingsfw.view.RistoranteGui;

public class ClienteController {

	private RistoranteGui rg;
	private Ristorante r;

	//attributi temporanei per aiutarci nella risoluzione di listeners
	String s,tmp;
	int i;
	Cliente c,daiMenu;
	public ClienteController(RistoranteGui rg, Ristorante r) {
		super();
		this.r=r;
		this.rg=rg;
		this.setClienteListeners();
	}

	private void setClienteListeners() {

		rg.getNomeClienteField().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				s = rg.getNomeClienteField().getText();
				if (r.getPrenotazioni().containsKey(s)) {
					tmp = s;
					for(Cliente c : r.getClienti()) {
						if (c.getNome().equals(tmp)) {
							c.setIdentificato(true);
						}
					}
					rg.scegliMenuR();
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
				}

			}
		});

		rg.getSceltaMenuButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				/*Cliente*/ c = r.prenotaClientenoPrenotazione((int)rg.getClienteNoPrenotato().getValue());
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
						rg.getValueC().setValue(rg.getValueC().getMinimum());
						rg.getValueC().setMaximum(quant.get(i));
					}
				}
			}
		});

		rg.getinviaOrdineButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*int*/ i=rg.getPiattiMenu().getSelectedIndex();

				//aggiungere eccezione
				if(rg.getPiattiMenu().getSelectedValue()==null)
				{
					rg.popUpErrore("Seleziona un piatto!");
				}

				else if(r.getPiatti().get(i).getQuantita()==0) {

					rg.popUpErrore("Piatto finito!");

				}
				else if ((int)rg.getValueC().getValue() == 0) {
					rg.popUpErrore("Seleziona una quantità valida");
				}
				else {
					for(Cliente c : r.getClienti()) {
						if(tmp.equals(c.getNome()))
							daiMenu=c;
					}

					try {
						//creo l'ordine per quel cliente
						daiMenu.creaOrdine(r.getPiatti().get(i), (int)rg.getQuantPiattoSpinner().getValue());

					} catch (IOException e1) {
						e1.printStackTrace();
					}

					rg.getTotale().setText("Totale :"+daiMenu.chiediConto());
					if(r.getPiatti().get(i).getQuantita()==0)
					{
						rg.azzeraValueC();
					}
					rg.getValueC().setMaximum(r.getPiatti().get(i).getQuantita());
					rg.getValueC().setValue(0);
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
					System.out.println(r.getPostiLiberi());
					// aggiungere pagina di fine
				}


			}
		});
		
	}
}
