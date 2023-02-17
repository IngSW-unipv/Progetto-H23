package it.unipv.ingsfw.view;

import java.awt.BorderLayout;

import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

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

import it.unipv.ingsfw.view.ourComponents.OurButton;
import it.unipv.ingsfw.view.ourComponents.OurLabel;
import it.unipv.ingsfw.view.ourComponents.OurPanel;
import it.unipv.ingsfw.view.ourComponents.OurSpinner;
import it.unipv.ingsfw.view.ourComponents.OurTextField;

public class DipendenteGui {

	private JPanel panel,panel2;
	private JPasswordField passwordRistorante;
	private JButton prenota,preparaTutto, tornaIndietroButton, aggiungi, vediOrdiniButton, aggiungiQuantitaButton, aggiungiPrenotazioneButton;
	private JTextArea ordini;
	private JScrollPane scroll;
	private OurLabel lab;
	protected GridBagConstraints  gbc;
	private JSpinner clienteNoPrenotato;
	private OurSpinner quantitySpinner;
	private SpinnerNumberModel value;
	private JTextField nomeCliente, nomePiattoField;
	private Border bordo;

	public DipendenteGui(){

		bordo=BorderFactory.createEmptyBorder(0,10,10,10);
		ImageIcon img = new ImageIcon("images/icons8.png");
		passwordRistorante=new JPasswordField();
		vediOrdiniButton = new  OurButton("Vedi ordini");
		aggiungiQuantitaButton = new OurButton("Aggiungi quantita`");
		aggiungiPrenotazioneButton =  new OurButton("Aggiungi prenotazione");
		preparaTutto = new OurButton ("Prepara tutti gli ordini");
		tornaIndietroButton = new JButton ();
		tornaIndietroButton.setOpaque(false);
		tornaIndietroButton.setContentAreaFilled(false);
		tornaIndietroButton.setBorderPainted(false);
		tornaIndietroButton.setIcon(img);
		prenota = new OurButton("Prenota il cliente");
		ordini=new JTextArea(20, 25);
		ordini.setEditable(false);
		scroll = new JScrollPane(ordini);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}

	public JPanel identificaDipendente() {
		//refreshPanel();
		//panel.setVisible(false);
		createPanel("b");
		//panel.removeAll();
		panel.setPreferredSize(new Dimension(500, 500));
		lab=new OurLabel("Inserisci la password del ristorante", SwingConstants.CENTER);
		lab.setPreferredSize(new Dimension(50,100));
		passwordRistorante.setPreferredSize(new Dimension(200,50));
		//panel.setLayout (new BorderLayout());
		panel.add(passwordRistorante,BorderLayout.SOUTH);
		panel.add(lab, BorderLayout.NORTH);
		//panel.add(panel2, BorderLayout.CENTER);
		return panel;
	}

	public JPanel operazioniDipendente() {
		//refreshPanel();
		createPanel("g");
		//p.setLayout(new GridBagLayout());

		gbc.gridwidth = GridBagConstraints.REMAINDER;        //senza questo li allinea in riga              
		gbc.fill = GridBagConstraints.HORIZONTAL; 		//bordi bottoni allineati (prova vertical per capire)

		lab = new OurLabel("Cosa vuoi fare?", SwingConstants.CENTER);
		gbc.insets = new Insets(120, 0, 10, 0);
		panel.add(lab, gbc);
		gbc.insets = new Insets(30, 0, 10, 0);
		panel.add(aggiungiQuantitaButton, gbc);
		gbc.insets = new Insets(0, 0, 10, 0);

		panel.add(vediOrdiniButton, gbc);
		gbc.insets = new Insets(0, 0, 10, 0);

		panel.add(aggiungiPrenotazioneButton, gbc);
		gbc.insets = new Insets(0, 0, 10, 0);

		//		gbc.fill = GridBagConstraints.LINE_END;
		//		gbc.gridx = 1;
		//		gbc.gridy = 4;
		//		gbc.gridwidth = 1;
		//		gbc.anchor = GridBagConstraints.LINE_END;
		//		//panel.add(tornaIndietroButton, gbc);
		//gbc.weighty = 10;
		//		f.add(p);
		//		f.setVisible(true);
		return panel;
	}


	public JPanel aggiungiPrenotazione(int max) {

		createPanel("g");

		lab=new OurLabel("Inserisci nome cliente e posti", SwingConstants.CENTER);
		value = new SpinnerNumberModel (0, 0, max, 1);
		clienteNoPrenotato = new OurSpinner(value);
		clienteNoPrenotato.setPreferredSize(new Dimension(60, 40));
		nomeCliente=new OurTextField();
		nomeCliente.setPreferredSize(new Dimension(200,50));

		//panel.setLayout(new GridBagLayout());

		gbc.gridwidth = GridBagConstraints.REMAINDER;        //senza questo li allinea in riga
		//gbc.anchor = GridBagConstraints.EAST;                
		gbc.fill = GridBagConstraints.HORIZONTAL; 		//bordi bottoni allineati (prova vertical per capire)

		//gbc.anchor = GridBagConstraints.WEST;

		panel2.add(lab, BorderLayout.WEST);

		panel.add(lab, gbc);

		panel2.add(nomeCliente, BorderLayout.CENTER);
		panel2.add(clienteNoPrenotato, BorderLayout.EAST);

		gbc.insets = new Insets(0, 0, 10, 0);
		panel.add(panel2, gbc);
		gbc.insets = new Insets(0, 0, 10, 0);
		panel.add(prenota, gbc);
		gbc.insets = new Insets(0, 0, 10, 0);

		panel.add(tornaIndietroButton, gbc);
		gbc.insets = new Insets(0, 0, 10, 0);

		gbc.anchor = GridBagConstraints.PAGE_END;
		panel.add(tornaIndietroButton, gbc);

		return panel;
	}

	public JPanel addDish() {

		createPanel("g");
		panel.setPreferredSize(new Dimension(500, 300));
		lab = new OurLabel("Aggiungi un piatto");
		OurLabel lab1 = new OurLabel("Nome piatto: ");
		OurLabel lab3 = new OurLabel("Quantità: ");
		quantitySpinner = new OurSpinner();
		quantitySpinner.setPreferredSize(new Dimension(60, 30));
		nomePiattoField = new OurTextField();
		nomePiattoField.setPreferredSize(new Dimension(200, 40));
		aggiungi = new OurButton("Aggiungi");
		aggiungi.setPreferredSize(new Dimension(200, 50));

		gbc.insets = new Insets(20, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_END;
		panel.add(lab1, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_START;
		panel.add(nomePiattoField, gbc);

		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_END;
		panel.add(lab3, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_START;
		panel.add(quantitySpinner, gbc);

		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_END;
		panel.add(tornaIndietroButton, gbc);

		gbc.insets = new Insets(40, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.PAGE_START;
		panel.add(aggiungi, gbc);

		gbc.insets = new Insets(20, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth = 2;
		panel.add(lab, gbc);

		return panel;
	}

	public JPanel vediOrdini() {
		createPanel("g");

		lab=new OurLabel("Ordini in arrivo", SwingConstants.CENTER);
		preparaTutto = new OurButton ("Prepara tutti gli ordini");

		//p.setLayout(new BorderLayout());
		//panel2.setLayout(new BorderLayout());
		panel2.add(preparaTutto, BorderLayout.NORTH);
		panel2.add(tornaIndietroButton, BorderLayout.LINE_END);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 20, 0, 0);
		//p.add(lab, gbc);
		panel.add(scroll, gbc);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(panel2,gbc);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth= 2;
		gbc.anchor = GridBagConstraints.PAGE_START;
		panel.add(lab, gbc);

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
		return tornaIndietroButton;
	}

	public JButton getAggiungi() {
		return aggiungi;
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

	public OurLabel getLab() {
		return lab;
	}

	public GridBagConstraints getGbc() {
		return gbc;
	}

	public JSpinner getClienteNoPrenotato() {
		return clienteNoPrenotato;
	}

	public OurSpinner getQuantitySpinner() {
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

	public Border getBordo() {
		return bordo;
	}



}
