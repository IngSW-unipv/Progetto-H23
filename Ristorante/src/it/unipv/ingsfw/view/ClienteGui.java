package it.unipv.ingsfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
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

public class ClienteGui {

	private JButton noPrenotazioneButton,aLaCarteButton,ayceButton,sceltaMenuButton, addButton,inviaOrdineButton;
	private JPanel panel,internalPanel;
	private JLabel lab,totale;
	private JSpinner clienteNoPrenotato, quantPiattoSpinner;
	private SpinnerNumberModel value;
	private JFrame f;
	private Border bordo;
	private GridBagConstraints gbc;
	private JTextField nomeClienteField;
	private JList piattiMenu;
	private DefaultListModel listModel;
	private JScrollPane scroll;

	public ClienteGui() {
		f=new JFrame();
		f.setSize(800, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //aggiungere salvare piatti e prenotazioni in db

		panel=new OurPanel();
		internalPanel= new OurPanel();
		internalPanel = new OurPanel(new BorderLayout());
		
		bordo=BorderFactory.createEmptyBorder(0,10,10,10);

		panel.setBorder(bordo);
		//f.add(p);
		
		nomeClienteField=new OurTextField();
		noPrenotazioneButton= new OurButton("Non sei prenotato?");
		aLaCarteButton=new OurButton("A La Carte");
		ayceButton=new OurButton("All you can eat");
		totale=new OurLabel("Totale: ", SwingConstants.CENTER);
		inviaOrdineButton=new OurButton("Aggiungi Piatto");
		
		sceltaMenuButton = new OurButton("Vai alla scelta del menu");
		value = new SpinnerNumberModel (0, 0, 1, 1);
		clienteNoPrenotato = new OurSpinner(value);
		quantPiattoSpinner = new OurSpinner(value);
		//clienteNoPrenotato.setEditor(new JSpinner.DefaultEditor(clienteNoPrenotato));
		listModel = new DefaultListModel();
		piattiMenu = new JList(listModel);
	}

	public JPanel identificaCliente() {

		createPanel("b");
		lab=new OurLabel("Inserisci il nome della prenotazione", SwingConstants.CENTER);
		lab.setPreferredSize(new Dimension(50,100));
		nomeClienteField.setFont(new Font("Italic", Font.ITALIC, 20));
		nomeClienteField.setPreferredSize(new Dimension(200,50));

		//noPrenotazioneButton= new OurButton("Non sei prenotato?");
		noPrenotazioneButton.setPreferredSize(new Dimension(200,50));

		//panel.setLayout (new BorderLayout());
		//panel = new OurPanel(new BorderLayout());
		
		
		internalPanel.add(nomeClienteField,BorderLayout.CENTER);
		panel.add(lab, BorderLayout.NORTH);
		panel.add(noPrenotazioneButton,BorderLayout.SOUTH);
		panel.add(internalPanel, BorderLayout.CENTER);
		return panel;

	}

	

	public JPanel clienteNoPrenotato(int max) {
		//refreshPanel();
		
		createPanel("g");
		value.setValue(1);
		value.setMinimum(1);
		value.setMaximum(max);
		lab=new OurLabel("TAVOLO SENZA PRENOTAZIONE", SwingConstants.CENTER);
		//lab.setForeground(Color.RED);
		OurLabel lab2 = new OurLabel("Inserisci numero posti:");
		lab2.setForeground(Color.BLACK);
		
		clienteNoPrenotato.setPreferredSize(new Dimension(60, 35));
		

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(30, 0, 0, 0);
		panel.add(lab2, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(30, 5, 0, 0);
		panel.add(clienteNoPrenotato,gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.1;
		gbc.weighty = 0.2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.PAGE_START;
		panel.add(sceltaMenuButton, gbc);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;

		panel.add(lab,gbc);
		//f.add(p2);
		//f.setVisible(true);
		return panel;
	}

	public JPanel scegliMenu() {
		createPanel("b");
		internalPanel = new OurPanel();
//		panel.setLayout(new BorderLayout());
		lab=new OurLabel("Scegli tipo di menu", SwingConstants.CENTER);
		lab.setPreferredSize(new Dimension(50,100));
		aLaCarteButton.setPreferredSize(new Dimension(250,400/6));
		ayceButton.setPreferredSize(new Dimension(250,400/6));
		
		panel.add(lab,BorderLayout.NORTH);
		internalPanel.add(aLaCarteButton);
		internalPanel.add(ayceButton);
		panel.add(internalPanel,BorderLayout.CENTER);
		
		return panel;
	}
	
//	public JPanel scegliMenu2() {
//		//p.setBackground(new Color(0, 0, 0, 110));
//		panel.setOpaque(false);
//		panel.setLayout(new GridBagLayout());
//		panel.setPreferredSize(new Dimension (600, 590));
//		lab=new OurLabel("Scegli tipo di menu");
//		//lab.setPreferredSize(new Dimension(100,100));
//		aLaCarteButton.setPreferredSize(new Dimension(200,400/6));
//		ayceButton.setPreferredSize(new Dimension(200,400/6));
//		
//	
//		gbc.gridx = 0;
//		gbc.gridy = 0;
////		gbc.weightx = 0.1;
////		gbc.weighty = 0.1;
//		gbc.gridwidth = 2;
////		gbc.insets = new Insets(0, 0, 0, 0);
//
//		//gbc.anchor = GridBagConstraints.PAGE_START;
//		panel.add(lab, gbc);	
//		gbc.insets = new Insets(30, 0, 0, 0);
//		gbc.anchor = GridBagConstraints.LINE_END;
//		gbc.gridwidth = 1;
//		gbc.gridx = 0;
//		gbc.gridy = 1;
////		gbc.weightx = 0.0;
////		gbc.weighty = 0.0;
//		panel.add(aLaCarteButton, gbc);
////		gbc.weightx = 0.0;
////		gbc.weighty = 0.0;
//		gbc.insets = new Insets(30, 10, 0, 0);
//		gbc.gridx = 1;
//		gbc.gridy = 1;
//		gbc.anchor = GridBagConstraints.LINE_START;
////		gbc.anchor = GridBagConstraints.LINE_END;
//		panel.add(ayceButton,gbc);
//		
//		
//		
//		//p.add(clienteButton,BorderLayout.EAST);
//		//p.add(dipendenteButton,BorderLayout.WEST);
//		//f.add(p);
//	//	f.setVisible(true);
//		return panel;
//	}

	public JPanel inviaOrdine(ArrayList<String> nomi, ArrayList<Integer> quantita) {
		createPanel("g");
		value.setValue(0);
		value.setMinimum(0);

		lab = new OurLabel("Scegli cosa desideri ordinare");

		for(String p: nomi) {
			listModel.addElement(p);
		}
		
//		for(int max:quantita) {
//			value.setMaximum(max);
//		}
		piattiMenu.setModel(listModel);
		piattiMenu.setPreferredSize(new Dimension(400,200));
		scroll = new JScrollPane(piattiMenu);

		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		addButton = new OurButton("Aggiungi piatti all'ordine");

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor =  GridBagConstraints.LINE_START;
		panel.add(scroll, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor =  GridBagConstraints.LINE_END;
		panel.add(quantPiattoSpinner,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor =  GridBagConstraints.CENTER;
		panel.add(inviaOrdineButton,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor =  GridBagConstraints.CENTER;
		panel.add(totale,gbc);
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
		internalPanel = new OurPanel(new BorderLayout());
	}


	public JButton getNoPrenotazioneButton() {
		return noPrenotazioneButton;
	}

	public JButton getaLaCarteButton() {
		return aLaCarteButton;
	}

	public JButton getAyceButton() {
		return ayceButton;
	}

	public JButton getSceltaMenuButton() {
		return sceltaMenuButton;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JPanel getP() {
		return panel;
	}

	public JPanel getP2() {
		return internalPanel;
	}

	public JLabel getLab() {
		return lab;
	}

	public JSpinner getClienteNoPrenotato() {
		return clienteNoPrenotato;
	}

	public JSpinner getQuantPiattoSpinner() {
		return quantPiattoSpinner;
	}

	public SpinnerNumberModel getValue() {
		return value;
	}

	public JFrame getF() {
		return f;
	}

	public Border getBordo() {
		return bordo;
	}

	public GridBagConstraints getGbc() {
		return gbc;
	}

	public JTextField getNomeClienteField() {
		return nomeClienteField;
	}

	public JList getPiattiMenu() {
		return piattiMenu;
	}

	public DefaultListModel getListModel() {
		return listModel;
	}

	public JScrollPane getScroll() {
		return scroll;
	}
	
	public JLabel getTotale() {
		return totale;
	}
	
	public JButton getinviaOrdineButton() {
		return inviaOrdineButton;
	}
}
