package it.unipv.ingsfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
	private JFrame f;
	private Border bordo;
	
	public DipendenteGui(){
		
		f=new JFrame();
		f.setSize(1220, 640);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //aggiungere salvare piatti e prenotazioni in db
		panel=new JPanel();
		panel2= new JPanel();
		gbc = new GridBagConstraints();
		bordo=BorderFactory.createEmptyBorder(0,10,10,10);
		//p.setLayout(new BorderLayout());
		panel.setBorder(bordo);
		f.add(panel);
		passwordRistorante=new JPasswordField();
		//tornaIndietroButton = new OurButton ("Torna indietro");
		ImageIcon img = new ImageIcon("images/icons8.png");
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
		preparaTutto = new OurButton ("Prepara tutti gli ordini");
	}

	public void identificaDipendente() {
		//refreshPanel();
		
		
		lab=new OurLabel("Inserisci la password del ristorante", SwingConstants.CENTER);
		lab.setPreferredSize(new Dimension(50,100));
		passwordRistorante.setPreferredSize(new Dimension(200,50));

		panel.setLayout (new BorderLayout());
		panel2.add(passwordRistorante,BorderLayout.CENTER);
		panel.add(lab, BorderLayout.NORTH);
		panel.add(panel2, BorderLayout.CENTER);
		f.add(panel);
		f.setVisible(true);
	}
	
	/*public void identificaDipendente2() {
		//refreshPanel();
		
		f.setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("C:\\Users\\gabri\\Desktop\\sfondo-riga-ricette.png"));
        panel.add(background);
        background.setLayout(new BorderLayout());
		lab=new OurLabel("Inserisci la password del ristorante", SwingConstants.CENTER);
		lab.setPreferredSize(new Dimension(50,100));
		passwordRistorante.setPreferredSize(new Dimension(200,50));

		//p.setLayout (new BorderLayout());
		background.add(passwordRistorante,BorderLayout.CENTER);
		background.add(lab, BorderLayout.NORTH);
		//p.add(p2, BorderLayout.CENTER);
		//background.add(p, BorderLayout.CENTER);
		panel.add(background, BorderLayout.CENTER);
		f.add(panel);
		f.setVisible(true);
	}*/

	public JPanel operazioniDipendente() {
		//refreshPanel();

		//p.setLayout(new GridBagLayout());
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;        //senza questo li allinea in riga              
		gbc.fill = GridBagConstraints.HORIZONTAL; 		//bordi bottoni allineati (prova vertical per capire)
		panel = new JPanel(new GridBagLayout());
		vediOrdiniButton = new  OurButton("Vedi ordini");
		lab = new OurLabel("Cosa vuoi fare?", SwingConstants.CENTER);
		aggiungiQuantitaButton = new OurButton("Aggiungi quantita`");
		aggiungiPrenotazioneButton =  new OurButton("Aggiungi prenotazione");
		gbc.insets = new Insets(120, 0, 10, 0);
		panel.add(lab, gbc);
		gbc.insets = new Insets(30, 0, 10, 0);
		panel.add(aggiungiQuantitaButton, gbc);
		gbc.insets = new Insets(0, 0, 10, 0);

		panel.add(vediOrdiniButton, gbc);
		gbc.insets = new Insets(0, 0, 10, 0);

		panel.add(aggiungiPrenotazioneButton, gbc);
		gbc.insets = new Insets(0, 0, 10, 0);
		
		gbc.fill = GridBagConstraints.LINE_END;
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		panel.add(tornaIndietroButton, gbc);
		panel.setOpaque(false);
		
		//gbc.weighty = 10;
//		f.add(p);
//		f.setVisible(true);
		return panel;
	}

	
	public void aggiungiPrenotazione(int max) {
		
		lab=new OurLabel("Inserisci nome cliente e posti", SwingConstants.CENTER);
		value = new SpinnerNumberModel (0, 0, max, 1);
		clienteNoPrenotato = new OurSpinner(value);
		clienteNoPrenotato.setPreferredSize(new Dimension(60, 40));
		nomeCliente=new OurTextField();
		nomeCliente.setPreferredSize(new Dimension(200,50));

		
		panel.setLayout(new GridBagLayout());

		gbc.gridwidth = GridBagConstraints.REMAINDER;        //senza questo li allinea in riga
		//gbc.anchor = GridBagConstraints.EAST;                
		gbc.fill = GridBagConstraints.HORIZONTAL; 		//bordi bottoni allineati (prova vertical per capire)
		panel = new JPanel(new GridBagLayout());
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

		gbc.anchor = GridBagConstraints.PAGE_END;
		panel.add(tornaIndietroButton, gbc);
		

		//gbc.weighty = 10;
		f.add(panel);
		f.setVisible(true);


	}
	
	public JPanel addDish() {
		
		panel = new JPanel(new GridBagLayout());
		panel.setOpaque(false);
		//panel.setBackground(new Color(0, 0, 0, 0));
		//panel.setBorder(BorderFactory.createLoweredBevelBorder());
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
		
		
//		//p.add(p2, BorderLayout.WEST);
//		f.add(p, BorderLayout.CENTER);
//		f.setVisible(true);
		return panel;
	}
	public void vediOrdini() {
		
		
		lab=new OurLabel("Ordini in arrivo", SwingConstants.CENTER);
		preparaTutto = new OurButton ("Prepara tutti gli ordini");
		/*ImageIcon img = new ImageIcon("C:\\Users\\gabri\\Downloads\\icons8.png");
		tornaIndietroButton = new JButton ();
		tornaIndietroButton.setOpaque(false);
		tornaIndietroButton.setContentAreaFilled(false);
		tornaIndietroButton.setBorderPainted(false);
		tornaIndietroButton.setIcon(img);
		//tornaIndietroButton.setPreferredSize(new Dimension(51, 51));
		*/
		
		panel = new JPanel(new GridBagLayout());
		//p.setLayout(new BorderLayout());
		panel2.setLayout(new BorderLayout());
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
		gbc.anchor = GridBagConstraints.LINE_START;
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

		f.add(panel);
		f.setVisible(true);	
		
	}
	
	
}
