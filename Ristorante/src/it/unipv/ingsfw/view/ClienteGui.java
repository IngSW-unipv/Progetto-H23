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

public class ClienteGui {

	private JButton noPrenotazioneButton,aLaCarteButton,ayceButton,sceltaMenuButton, addButton;

	private JPanel p,p2;
	private JLabel lab;
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

		p=new OurPanel();
		p2= new OurPanel();
		gbc= new GridBagConstraints();
		bordo=BorderFactory.createEmptyBorder(0,10,10,10);
		listModel = new DefaultListModel();


		p.setBorder(bordo);
		//f.add(p);

		noPrenotazioneButton= new OurButton("Non sei prenotato?");
		aLaCarteButton=new OurButton("A La Carte");
		ayceButton=new OurButton("All you can eat");
		sceltaMenuButton = new OurButton("Vai alla scelta del menu");
		value = new SpinnerNumberModel (0, 0, 0, 1);

	}

	public JPanel identificaCliente() {

		lab=new OurLabel("Inserisci il nome della prenotazione", SwingConstants.CENTER);
		lab.setPreferredSize(new Dimension(50,100));
		nomeClienteField=new JTextField();
		nomeClienteField.setFont(new Font("Italic", Font.ITALIC, 20));
		nomeClienteField.setPreferredSize(new Dimension(200,50));

		//noPrenotazioneButton= new OurButton("Non sei prenotato?");
		noPrenotazioneButton.setPreferredSize(new Dimension(200,50));

		p.setLayout (new BorderLayout());
		p2.add(nomeClienteField,BorderLayout.CENTER);
		p.add(lab, BorderLayout.NORTH);
		p.add(noPrenotazioneButton,BorderLayout.SOUTH);
		p.add(p2, BorderLayout.CENTER);
		return p;

	}

	public JPanel clienteNoPrenotato(int max) {
		//refreshPanel();
		
		p2.setLayout(new GridBagLayout());
		//p2.setBorder(BorderFactory.createLoweredBevelBorder());
		//p2.setPreferredSize(new Dimension(500, 300));
		lab=new OurLabel("TAVOLO SENZA PRENOTAZIONE", SwingConstants.CENTER);
		lab.setForeground(Color.RED);
		OurLabel lab2 = new OurLabel("Inserisci numero posti:");
		value = new SpinnerNumberModel (0, 0, max, 1);
		clienteNoPrenotato = new OurSpinner(value);

		clienteNoPrenotato.setPreferredSize(new Dimension(60, 35));
		sceltaMenuButton = new OurButton("Vai alla scelta del menu");

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(30, 0, 0, 0);
		p2.add(lab2, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(30, 5, 0, 0);
		p2.add(clienteNoPrenotato,gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.1;
		gbc.weighty = 0.2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.PAGE_START;
		p2.add(sceltaMenuButton, gbc);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;

		p2.add(lab,gbc);
		//f.add(p2);
		//f.setVisible(true);
		return p;
	}

	public JPanel scegliMenu() {

		p.setLayout(new BorderLayout());
		lab=new OurLabel("Scegli tipo di menu", SwingConstants.CENTER);
		lab.setPreferredSize(new Dimension(50,100));
		aLaCarteButton.setPreferredSize(new Dimension(200,400/6));
		ayceButton.setPreferredSize(new Dimension(200,400/6));
		
		//p.setOpaque(false);
		p2.setOpaque(false);
		p.add(lab,BorderLayout.NORTH);
		p2.add(aLaCarteButton,BorderLayout.EAST);
		p2.add(ayceButton,BorderLayout.WEST);
		p.add(p2,BorderLayout.CENTER);
		p.setBackground(new Color(0,0,0, 160));
		
		
		//p.add(clienteButton,BorderLayout.EAST);
		//p.add(dipendenteButton,BorderLayout.WEST);
		//f.add(p);
	//	f.setVisible(true);
		return p;
	}
	
	public JPanel scegliMenu2() {
		//p.setBackground(new Color(0, 0, 0, 110));
		p.setOpaque(false);
		p.setLayout(new GridBagLayout());
		p.setPreferredSize(new Dimension (600, 590));
		lab=new OurLabel("Scegli tipo di menu");
		//lab.setPreferredSize(new Dimension(100,100));
		aLaCarteButton.setPreferredSize(new Dimension(200,400/6));
		ayceButton.setPreferredSize(new Dimension(200,400/6));
		
	
		gbc.gridx = 0;
		gbc.gridy = 0;
//		gbc.weightx = 0.1;
//		gbc.weighty = 0.1;
		gbc.gridwidth = 2;
//		gbc.insets = new Insets(0, 0, 0, 0);

		//gbc.anchor = GridBagConstraints.PAGE_START;
		p.add(lab, gbc);	
		gbc.insets = new Insets(30, 0, 0, 0);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
//		gbc.weightx = 0.0;
//		gbc.weighty = 0.0;
		p.add(aLaCarteButton, gbc);
//		gbc.weightx = 0.0;
//		gbc.weighty = 0.0;
		gbc.insets = new Insets(30, 10, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
//		gbc.anchor = GridBagConstraints.LINE_END;
		p.add(ayceButton,gbc);
		
		
		
		//p.add(clienteButton,BorderLayout.EAST);
		//p.add(dipendenteButton,BorderLayout.WEST);
		//f.add(p);
	//	f.setVisible(true);
		return p;
	}

	public void inviaOrdine(/*ArrayList<String> piatti*/) {
		p = new JPanel(new GridBagLayout());

		lab = new OurLabel("Scegli cosa desideri ordinare");


		//listModel.addAll(piatti);
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");
		listModel.addElement("Pizza margherita");

		piattiMenu = new JList(listModel);
		scroll = new JScrollPane(piattiMenu);

		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


		quantPiattoSpinner = new OurSpinner(value);
		addButton = new OurButton("Aggiungi piatti all'ordine");

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor =  GridBagConstraints.LINE_START;
		p.add(scroll, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor =  GridBagConstraints.LINE_END;
		p.add(quantPiattoSpinner,gbc);
		f.add(p);
		f.setVisible(true);



	}


}
