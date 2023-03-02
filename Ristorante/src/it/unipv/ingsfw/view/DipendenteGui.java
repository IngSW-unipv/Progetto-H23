package it.unipv.ingsfw.view;

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

	private String defaultTextOfLabPosti,defaultTextOfLabClientiPrenotati;
	private JPanel panel, statusPanel;
	private JPasswordField passwordRistorante;
	private JButton prenotaButton, preparaTuttoButton, backButton, aggiornaQuantitaButton, vediOrdiniButton, aggiungiQuantitaButton, aggiungiPrenotazioneButton, homeButton, vediPrenotazioniButton;
	private JTextArea ordini, prenotazioni;
	private JScrollPane scroll;
	private JLabel label,labelPosti, labelClientiPrenotati;
	protected GridBagConstraints  gbc;
	private JSpinner clienteNoPrenotatoSpinner, quantitySpinner;
	private SpinnerNumberModel spinnerValue;
	private JTextField nomeClienteField, nomePiattoField;
	private Border bordo;

	public DipendenteGui(){

		bordo=BorderFactory.createEmptyBorder(0,10,10,10);

		passwordRistorante=new JPasswordField();
		vediOrdiniButton = new  OurButton("Vedi ordini");
		vediPrenotazioniButton = new OurButton("Vedi prenotazioni");
		aggiungiQuantitaButton = new OurButton("Aggiungi quantita`");
		aggiungiPrenotazioneButton =  new OurButton("Aggiungi prenotazione");
		preparaTuttoButton = new OurButton ("Prepara tutti gli ordini");
		backButton = new BackButton ();
		homeButton = new BackButton();
		spinnerValue = new SpinnerNumberModel (1, 1, 1, 1);
		clienteNoPrenotatoSpinner = new OurSpinner(spinnerValue);
		nomeClienteField=new OurTextField();
		prenotaButton = new OurButton("Prenota il cliente");

		ordini=new JTextArea(18, 25);
		ordini.setEditable(false);

		prenotazioni=new JTextArea(20, 25);
		prenotazioni.setEditable(false);

		aggiornaQuantitaButton = new OurButton("Aggiorna quantita`");
		nomePiattoField = new OurTextField();
		quantitySpinner = new OurSpinner(spinnerValue);
		defaultTextOfLabPosti="Posti liberi: ";
		labelPosti=new OurLabel(defaultTextOfLabPosti);
		defaultTextOfLabClientiPrenotati="Clienti prenotati: ";
		labelClientiPrenotati = new OurLabel(defaultTextOfLabClientiPrenotati);
	}


	public JPanel identificaDipendente() {
		createPanel();

		label=new OurLabel("INSERISCI LA PASSWORD DEL RISTORANTE", SwingConstants.CENTER, Color.RED);
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
		panel.add(label,gbc);

		return panel;
	}

	public JPanel addStatusPanel() {
		statusPanel= new OurPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		statusPanel.add(labelPosti, gbc);
		statusPanel.add(labelClientiPrenotati, gbc);
		return statusPanel;
	}

	public JPanel operazioniDipendente() {
		createPanel();
		label = new OurLabel("OPERAZIONI DISPONIBILI", SwingConstants.CENTER, Color.RED);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 100, 55, 0);

		gbc.anchor=GridBagConstraints.PAGE_END;
		panel.add(addStatusPanel(), gbc);

		gbc.gridwidth = 2;        
		gbc.fill = GridBagConstraints.HORIZONTAL;         

		gbc.gridx = 0;
		gbc.insets = new Insets(0, 400, 10, 0);


		gbc.gridy = 2;
		panel.add(aggiungiQuantitaButton, gbc);
		gbc.gridy = 3;
		panel.add(vediOrdiniButton, gbc);
		gbc.gridy = 4;
		panel.add(vediPrenotazioniButton, gbc);


		gbc.insets = new Insets(0, 400, 30, 0);
		gbc.gridy = 1;
		panel.add(label, gbc);

		gbc.insets = new Insets(0, 400, 120, 0);
		gbc.gridy = 5;
		panel.add(aggiungiPrenotazioneButton, gbc);   

		return panel;
	}

	public JPanel aggiungiPrenotazione(int max) {
		createPanel();
		label=new OurLabel("AGGIUNGI NUOVA PRENOTAZIONE", SwingConstants.CENTER, Color.RED);
		OurLabel lab2 = new OurLabel("Nome cliente: ", Color.BLACK);
		OurLabel lab3 = new OurLabel("Posti da riservare: ", Color.BLACK);

		clienteNoPrenotatoSpinner.setPreferredSize(new Dimension(60, 40));;
		nomeClienteField.setPreferredSize(new Dimension(200,50));
		spinnerValue.setMaximum(max);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth= 3;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.insets = new Insets(150, 120, 0, 0);
		panel.add(label, gbc);


		gbc.insets = new Insets(10, 120, 0, 0);
		gbc.gridwidth= 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_END;
		panel.add(lab2, gbc);

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
		panel.add(nomeClienteField, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_START;
		panel.add(clienteNoPrenotatoSpinner, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(10, 120, 0, 0);
		gbc.gridwidth= 3;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		panel.add(prenotaButton,gbc);

		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(10, 0, 40, 0);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		panel.add(backButton,gbc);

		return panel;
	}

	public JPanel addDish() {
		createPanel();
		//massimo impostato a 999
		spinnerValue.setMaximum(999);
		spinnerValue.setMinimum(1);
		label = new OurLabel("AGGIORNA QUANTITA` PIATTO", SwingConstants.CENTER, Color.RED);
		OurLabel lab1 = new OurLabel("Nome piatto: ", Color.BLACK);
		OurLabel lab3 = new OurLabel("Quantita`: ", Color.BLACK);
		quantitySpinner.setPreferredSize(new Dimension(60, 40));
		nomePiattoField.setPreferredSize(new Dimension(200, 40));
		aggiornaQuantitaButton.setPreferredSize(new Dimension(300, 50));

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth= 3;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.insets = new Insets(150, 120, 0, 0);
		panel.add(label, gbc);

		gbc.insets = new Insets(10, 120, 0, 0);
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
		gbc.insets = new Insets(10, 120, 0, 0);
		gbc.gridwidth= 3;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		panel.add(aggiornaQuantitaButton,gbc);

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
		createPanel();
		scroll = new JScrollPane(ordini);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		label=new OurLabel("ORDINI IN ARRIVO", SwingConstants.CENTER, Color.RED);
		ordini.setText(testoOrdini);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth= 3;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.insets = new Insets(20, 40, 10, 0);
		panel.add(label, gbc);

		gbc.gridwidth= 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		panel.add(scroll, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(preparaTuttoButton,gbc);

		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(10, 0, 10, 0);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		
		panel.add(backButton,gbc);
		return panel;
	}

	public JPanel vediPrenotazioni(String testoPrenotazioni) {
		createPanel();

		label=new OurLabel("CLIENTI PRENOTATI", SwingConstants.CENTER, Color.RED);
		scroll = new JScrollPane(prenotazioni);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		prenotazioni.setText(testoPrenotazioni);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth= 3;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.insets = new Insets(20, 40, 10, 0);
		panel.add(label, gbc);

		gbc.gridwidth= 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;

		panel.add(scroll, gbc);

		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(10, 0, 10, 0);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		panel.add(backButton,gbc);
		
		return panel;
	}

	public void createPanel() {
		panel = new OurPanel(new GridBagLayout());
		gbc = new GridBagConstraints();
		panel.setBorder(bordo);
	}

	public JLabel getLabPosti() {
		return labelPosti;
	}

	public JLabel getLabClientiPrenotati() {
		return labelClientiPrenotati;
	}


	public JPasswordField getPasswordRistorante() {
		return passwordRistorante;
	}

	public JButton getPrenotaButton() {
		return prenotaButton;
	}

	public JButton getPreparaTutto() {
		return preparaTuttoButton;
	}

	public JButton getTornaIndietroButton() {
		return backButton;
	}

	public JButton getHomeButton() {
		return homeButton;
	}

	public JButton getAggiornaQuantitaButton() {
		return aggiornaQuantitaButton;
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

	public JSpinner getClienteNoPrenotato() {
		return clienteNoPrenotatoSpinner;
	}

	public JSpinner getQuantitySpinner() {
		return quantitySpinner;
	}

	public SpinnerNumberModel getSpinnerValue() {
		return spinnerValue;
	}

	public JTextField getNomeClienteField() {
		return nomeClienteField;
	}

	public JTextField getNomePiattoField() {
		return nomePiattoField;
	}

	public JTextArea getPrenotazioniArea() {
		return prenotazioni;
	}

	public String getDefaultTextOfLabPosti() {
		return defaultTextOfLabPosti;
	}

	public String getDefaultTextOfLabClientiPrenotati() {
		return defaultTextOfLabClientiPrenotati;
	}

}