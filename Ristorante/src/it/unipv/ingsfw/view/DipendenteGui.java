package it.unipv.ingsfw.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
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
	
	private JPanel p,p2;
	private JPasswordField passwordRistorante;
	private JButton prenota,preparaTutto, indietro;
	private JTextArea ordini;
	private JScrollPane scroll;
	private OurLabel lab;
	protected GridBagConstraints  gbc;
	private JSpinner clienteNoPrenotato;
	private SpinnerNumberModel value;
	private JTextField nomeCliente;
	private JFrame f;
	private Border bordo;
	
	public DipendenteGui(){
		
		f=new JFrame();
		f.setSize(800, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //aggiungere salvare piatti e prenotazioni in db
		p=new JPanel();
		p2= new JPanel();
		bordo=BorderFactory.createEmptyBorder(0,10,10,10);
		//p.setLayout(new BorderLayout());
		p.setBorder(bordo);
		f.add(p);
		passwordRistorante=new JPasswordField();
		prenota = new OurButton("Prenota il cliente");
		ordini=new JTextArea("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nHHHHHHHHHHHHHHHHHHHH"
				+ "HHHHHHHHHHHHHHH");
		scroll = new JScrollPane(ordini);
		preparaTutto = new OurButton ("Prepara tutti gli ordini");
	}

	public JPanel identificaDipendente() {
		//refreshPanel();

		lab=new OurLabel("Inserisci la password del ristorante", SwingConstants.CENTER);
		lab.setPreferredSize(new Dimension(50,100));
		passwordRistorante.setPreferredSize(new Dimension(200,50));

		p.setLayout (new BorderLayout());
		p2.add(passwordRistorante,BorderLayout.CENTER);
		p.add(lab, BorderLayout.NORTH);
		p.add(p2, BorderLayout.CENTER);
		//f.add(p);
		//f.setVisible(true);
		return p;
	}

	public void operazioniDipendente() {
		//refreshPanel();

		p.setLayout(new GridBagLayout());

		gbc.gridwidth = GridBagConstraints.REMAINDER;        //senza questo li allinea in riga
		//gbc.anchor = GridBagConstraints.WEST;
		//gbc.anchor = GridBagConstraints.EAST;                
		gbc.fill = GridBagConstraints.HORIZONTAL; 		//bordi bottoni allineati (prova vertical per capire)
		p = new JPanel(new GridBagLayout());
		gbc.insets = new Insets(0, 0, 10, 0);
		p.add(new OurButton("Aggiungi Quantità"), gbc);
		gbc.insets = new Insets(0, 0, 10, 0);

		p.add(new OurButton("Vedi Ordini"), gbc);
		gbc.insets = new Insets(0, 0, 10, 0);

		p.add(new OurButton("Aggiungi Prenotazione"), gbc);
		gbc.insets = new Insets(0, 0, 10, 0);

		p.add(new OurButton("Esci"), gbc);

		//gbc.weighty = 10;
		//add(p, gbc);
		//setVisible(true);
	}

	public void aggiungiPrenotazione(int max) {
		//refreshPanel();

		lab=new OurLabel("Inserisci nome cliente e posti", SwingConstants.CENTER);
		value = new SpinnerNumberModel (0, 0, max, 1);

		clienteNoPrenotato = new OurSpinner(value);
		clienteNoPrenotato.setPreferredSize(new Dimension(60, 40));
		nomeCliente=new JTextField();
		nomeCliente.setPreferredSize(new Dimension(200,50));

		indietro = new OurButton ("Torna indietro");
		p.setLayout(new GridBagLayout());

		gbc.gridwidth = GridBagConstraints.REMAINDER;        //senza questo li allinea in riga
		//gbc.anchor = GridBagConstraints.EAST;                
		gbc.fill = GridBagConstraints.HORIZONTAL; 		//bordi bottoni allineati (prova vertical per capire)
		p = new JPanel(new GridBagLayout());
		//gbc.anchor = GridBagConstraints.WEST;

		p2.add(lab, BorderLayout.WEST);


		p.add(lab, gbc);

		p2.add(nomeCliente, BorderLayout.CENTER);
		p2.add(clienteNoPrenotato, BorderLayout.EAST);


		gbc.insets = new Insets(0, 0, 10, 0);
		p.add(p2, gbc);
		gbc.insets = new Insets(0, 0, 10, 0);
		p.add(prenota, gbc);
		gbc.insets = new Insets(0, 0, 10, 0);

		gbc.anchor = GridBagConstraints.PAGE_END;
		p.add(indietro, gbc);

		//gbc.weighty = 10;
		//add(p, gbc);
		//f.setVisible(true);


	}
	public void vediOrdini() {
		/*ordini=new JTextArea("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nHHHHHHHHHHHHHHHHHHHH"
				+ "HHHHHHHHHHHHHHH");*/

		//JScrollPane scroll = new JScrollPane(ordini);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		lab=new OurLabel("Ordini da preparare", SwingConstants.CENTER);
		//preparaTutto = new OurButton ("Prepara tutti gli ordini");
		indietro = new OurButton ("Torna indietro");

		p.setLayout(new BorderLayout());
		p2.add(preparaTutto, BorderLayout.NORTH);
		p2.add(indietro, BorderLayout.SOUTH);

		p.add(lab, BorderLayout.NORTH);
		p.add(scroll, BorderLayout.CENTER);
		p.add(p2,BorderLayout.SOUTH);

		f.add(p);
		f.setVisible(true);	
		//return f;
		//return p;
	}
	
	
}
