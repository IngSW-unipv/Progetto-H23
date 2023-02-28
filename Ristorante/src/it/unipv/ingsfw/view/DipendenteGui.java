package it.unipv.ingsfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import it.unipv.ingsfw.view.ourComponents.BackButton;
import it.unipv.ingsfw.view.ourComponents.OurButton;
import it.unipv.ingsfw.view.ourComponents.OurLabel;
import it.unipv.ingsfw.view.ourComponents.OurPanel;
import it.unipv.ingsfw.view.ourComponents.OurSpinner;
import it.unipv.ingsfw.view.ourComponents.OurTextField;

public class DipendenteGui {

	private JPanel panel,panel2;
	private JPasswordField passwordRistorante;
	private JButton prenota,preparaTutto, backButton, aggiungi, vediOrdiniButton, aggiungiQuantitaButton, aggiungiPrenotazioneButton, homeButton, vediPrenotazioniButton;
	private JTextArea ordini, prenotazioni;
	private JScrollPane scroll;
	private JLabel lab,labPosti, labClientiPrenotati;
	protected GridBagConstraints  gbc;
	private JSpinner clienteNoPrenotato;
	private JSpinner quantitySpinner;
	private SpinnerNumberModel value;
	private JTextField nomeCliente, nomePiattoField;
	private Border bordo;

	public DipendenteGui(){

		bordo=BorderFactory.createEmptyBorder(0,10,10,10);
		
		passwordRistorante=new JPasswordField();
		vediOrdiniButton = new  OurButton("Vedi ordini");
		vediPrenotazioniButton = new OurButton("Vedi prenotazioni");
		aggiungiQuantitaButton = new OurButton("Aggiungi quantita`");
		aggiungiPrenotazioneButton =  new OurButton("Aggiungi prenotazione");
		preparaTutto = new OurButton ("Prepara tutti gli ordini");
		backButton = new BackButton ();
		homeButton = new BackButton();
		value = new SpinnerNumberModel (1, 1, 1, 1);
		clienteNoPrenotato = new OurSpinner(value);
		nomeCliente=new OurTextField();
		prenota = new OurButton("Prenota il cliente");
		
		ordini=new JTextArea(20, 25);
		ordini.setEditable(false);
		
		prenotazioni=new JTextArea(20, 25);
		prenotazioni.setEditable(false);
		
		aggiungi = new OurButton("Aggiorna quantita`");
		nomePiattoField = new OurTextField();
		quantitySpinner = new OurSpinner(value);
		labPosti=new OurLabel("Posti liberi: ");
		labClientiPrenotati = new OurLabel("Clienti prenotati: ");
	}


	public JPanel identificaDipendente() {
		createPanel("g");

		lab=new OurLabel("INSERISCI LA PASSWORD DEL RISTORANTE", SwingConstants.CENTER, Color.RED);
		OurLabel lab2 = new OurLabel("Password:", Color.BLACK);

		passwordRistorante.setPreferredSize(new Dimension(200,50));

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(0, 70, 200, 0);
		panel.add(lab2, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 10, 200, 0);
		panel.add(passwordRistorante,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(10, 0, 0, 0);
		panel.add(homeButton, gbc);

		gbc.insets = new Insets(200, 150, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(lab,gbc);

		return panel;
	}

	public JPanel operazioniDipendente() {
		createPanel("g");
		lab = new OurLabel("COSA VUOI FARE?", SwingConstants.CENTER, Color.RED);
		panel2= new OurPanel(new GridBagLayout());
		GridBagConstraints gbcTemp = new GridBagConstraints();
		gbcTemp.gridwidth = GridBagConstraints.REMAINDER;
		panel2.add(labPosti, gbcTemp);
		panel2.add(labClientiPrenotati, gbcTemp);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 100, 80, 0);

		gbc.anchor=GridBagConstraints.PAGE_END;
		panel.add(panel2, gbc);

		gbc.gridwidth = 2;        //senza questo li allinea in riga
		gbc.fill = GridBagConstraints.HORIZONTAL;         //bordi bottoni allineati (prova vertical per capire)

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 400, 10, 0);
		gbc.gridy = 1;
		panel.add(lab, gbc);

		gbc.gridy = 2;
		panel.add(aggiungiQuantitaButton, gbc);
		gbc.gridy = 3;
		panel.add(vediOrdiniButton, gbc);
//		
//		gbc.gridy =4;
//		panel.add(vediPrenotazioniButton, gbc);
//		
		gbc.insets = new Insets(0, 400, 120, 0);
		gbc.gridy = 4;
		panel.add(aggiungiPrenotazioneButton, gbc);   

		return panel;
	}

	public JPanel aggiungiPrenotazione(int max) {
		createPanel("g");
		JPanel panel3 = new OurPanel(new BorderLayout());
		lab=new OurLabel("NUOVA PRENOTAZIONE", SwingConstants.CENTER, Color.RED);
		OurLabel lab2 = new OurLabel("Nome cliente:     ", Color.BLACK);
		OurLabel lab3 = new OurLabel("Posti da riservare:     ", Color.BLACK);

		clienteNoPrenotato.setPreferredSize(new Dimension(60, 40));
		nomeCliente.setPreferredSize(new Dimension(200,50));
		value.setMaximum(max);

		gbc.gridwidth = GridBagConstraints.REMAINDER;        //senza questo li allinea in riga
		gbc.fill = GridBagConstraints.HORIZONTAL;         //bordi bottoni allineati (prova vertical per capire)

		gbc.insets = new Insets(0, 230, 10, 0);
		panel.add(lab, gbc);

		panel2.add(lab2, BorderLayout.CENTER);
		panel2.add(nomeCliente, BorderLayout.EAST);
		panel3.add(lab3, BorderLayout.CENTER);
		panel3.add(clienteNoPrenotato, BorderLayout.EAST);

		gbc.insets = new Insets(0, 230, 10, 0);
		panel.add(panel2, gbc);
		panel.add(panel3, gbc);
		panel.add(prenota, gbc);

		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.PAGE_END;
		panel.add(backButton, gbc);
		gbc.insets = new Insets(0, 0, 10, 0);

		return panel;
	}

	public JPanel addDish() {
		createPanel("g");
		//massimo impostato a 999
		value.setMaximum(999);
		value.setMinimum(1);
		lab = new OurLabel("AGGIORNA QUANTITA` PIATTO", SwingConstants.CENTER, Color.RED);
		OurLabel lab1 = new OurLabel("Nome piatto: ", Color.BLACK);
		OurLabel lab3 = new OurLabel("Quantita`: ", Color.BLACK);
		quantitySpinner.setPreferredSize(new Dimension(70, 30));
		nomePiattoField.setPreferredSize(new Dimension(200, 40));
		aggiungi.setPreferredSize(new Dimension(300, 50));

		panel2.add(aggiungi, BorderLayout.NORTH);
		panel2.add(backButton, BorderLayout.LINE_END);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth= 3;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.insets = new Insets(100, 230, 0, 0);
		panel.add(lab, gbc);

		gbc.insets = new Insets(10, 230, 0, 0);
		gbc.gridwidth= 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_END;
		panel.add(lab1, gbc);

		gbc.gridwidth= 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_END;
		panel.add(lab3, gbc);

		gbc.insets = new Insets(10, 10, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_START;
		panel.add(nomePiattoField, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_START;
		panel.add(quantitySpinner, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(10, 230, 0, 0);
		gbc.gridwidth= 3;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		panel.add(aggiungi,gbc);

		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(10, 0, 40, 0);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		panel.add(backButton,gbc);

		return panel;
	}

	public JPanel vediOrdini(String testoOrdini) {
		createPanel("g");
		scroll = new JScrollPane(ordini);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		lab=new OurLabel("ORDINI IN ARRIVO", SwingConstants.CENTER, Color.RED);
		ordini.setText(testoOrdini);

		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panel2.add(preparaTutto, BorderLayout.NORTH);
		panel2.add(backButton, BorderLayout.LINE_END);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth= 3;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.insets = new Insets(20, 40, 10, 0);
		panel.add(lab, gbc);

		gbc.gridwidth= 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;

		panel.add(scroll, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(panel2,gbc);
		return panel;
	}
	
	public JPanel vediPrenotazioni(String testoPrenotazioni) {
		createPanel("g");

		lab=new OurLabel("CLIENTI PRENOTATI", SwingConstants.CENTER, Color.RED);
		scroll = new JScrollPane(prenotazioni);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		prenotazioni.setText(testoPrenotazioni);

		gbc.gridwidth = GridBagConstraints.REMAINDER;
//		panel2.add(preparaTutto, BorderLayout.NORTH);
		panel2.add(backButton, BorderLayout.LINE_END);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth= 3;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.insets = new Insets(20, 40, 10, 0);
		panel.add(lab, gbc);

		gbc.gridwidth= 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;

		panel.add(scroll, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(panel2,gbc);
		return panel;
	}

	public void createPanel (String p1) {

		if (p1.equals("g")) {
			panel = new OurPanel(new GridBagLayout());
			gbc = new GridBagConstraints();
		}
		else if (p1.equals("b")){
			panel = new OurPanel(new BorderLayout());
		}
		panel.setBorder(bordo);
		panel2 = new OurPanel(new BorderLayout());
	}

	public JLabel getLabPosti() {
		return labPosti;
	}

	public JLabel getLabClientiPrenotati() {
		return labClientiPrenotati;
	}

	
	public JPanel getPanel() {
		return panel;
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public JPasswordField getPasswordRistorante() {
		return passwordRistorante;
	}

	public JButton getPrenota() {
		return prenota;
	}

	public JButton getPreparaTutto() {
		return preparaTutto;
	}

	public JButton getTornaIndietroButton() {
		return backButton;
	}
	
	public JButton getHomeButton() {
		return homeButton;
	}

	public JButton getAggiungi() {
		return aggiungi;
	}

	public JButton getVediPrenotazioniButton() {
		return vediPrenotazioniButton;
	}
	
	public JButton getVediOrdiniButton() {
		return vediOrdiniButton;
	}

	public JButton getAggiungiQuantitaButton() {
		return aggiungiQuantitaButton;
	}

	public JButton getAggiungiPrenotazioneButton() {
		return aggiungiPrenotazioneButton;
	}

	public JTextArea getOrdini() {
		return ordini;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public JLabel getLab() {
		return lab;
	}

	public GridBagConstraints getGbc() {
		return gbc;
	}

	public JSpinner getClienteNoPrenotato() {
		return clienteNoPrenotato;
	}

	public JSpinner getQuantitySpinner() {
		return quantitySpinner;
	}

	public SpinnerNumberModel getValue() {
		return value;
	}

	public JTextField getNomeCliente() {
		return nomeCliente;
	}

	public JTextField getNomePiattoField() {
		return nomePiattoField;
	}
	
	public JTextArea getPrenotazioniArea() {
		return prenotazioni;
	}
	
	public Border getBordo() {
		return bordo;
	}

}