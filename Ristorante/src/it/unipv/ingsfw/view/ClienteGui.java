package it.unipv.ingsfw.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class ClienteGui {
	
	//private JTextField nomeCliente;
	private JButton noPrenotazioneButton,aLaCarteButton,ayceButton,sceltaMenuButton;
	//private SpinnerNumberModel value;
	//private JSpinner clienteNoPrenotato;
	private JPanel p,p2;
	private JLabel lab;
	private JSpinner clienteNoPrenotato;
	private SpinnerNumberModel value;
	
	public ClienteGui() {
		p=new JPanel();
		p2= new JPanel();
		
		noPrenotazioneButton= new OurButton("Non sei prenotato?");
		aLaCarteButton=new OurButton("A La Carte");
		ayceButton=new OurButton("All you can eat");
		sceltaMenuButton = new OurButton("Vai alla scelta del menu");
		
	}
	
	public JPanel identificaCliente() {
		//refreshPanel();
		
		//label
		lab=new OurLabel("Inserisci il nome della prenotazione", SwingConstants.CENTER);
		lab.setPreferredSize(new Dimension(50,100));
		JTextField nomeCliente=new JTextField();
		nomeCliente.setPreferredSize(new Dimension(200,50));

		//noPrenotazioneButton= new OurButton("Non sei prenotato?");
		noPrenotazioneButton.setPreferredSize(new Dimension(200,50));

		p.setLayout (new BorderLayout());
		p2.add(nomeCliente,BorderLayout.CENTER);
		p.add(lab, BorderLayout.NORTH);
		p.add(noPrenotazioneButton,BorderLayout.SOUTH);
		p.add(p2, BorderLayout.CENTER);
		//f.add(p);
		//f.setVisible(true);
		return p;
	}
	
	public JPanel scegliMenu() {
		//refreshPanel();

		//aLaCarteButton=new OurButton("A La Carte");
		//ayceButton=new OurButton("All you can eat");
		lab=new OurLabel("Scegli tra i due menu", SwingConstants.CENTER);
		lab.setPreferredSize(new Dimension(50,100));
		aLaCarteButton.setPreferredSize(new Dimension(200,400/6));
		ayceButton.setPreferredSize(new Dimension(200,400/6));

		p.add(lab,BorderLayout.NORTH);
		p2.add(aLaCarteButton,BorderLayout.EAST);
		p2.add(ayceButton,BorderLayout.WEST);
		p.add(p2,BorderLayout.CENTER);
		//p.add(clienteButton,BorderLayout.EAST);
		//p.add(dipendenteButton,BorderLayout.WEST);
		//f.add(p);
		//f.setVisible(true);
		return p;
	}
	
	public JPanel clienteNoPrenotato(int max) {
		//refreshPanel();
		
		lab=new OurLabel("Inserisci il numero di posti", SwingConstants.CENTER);
		value = new SpinnerNumberModel (0, 0, max, 1);
		clienteNoPrenotato = new OurSpinner(value);
		
		clienteNoPrenotato.setPreferredSize(new Dimension(60, 40));
		sceltaMenuButton = new OurButton("Vai alla scelta del menu");
		p2.add(lab,BorderLayout.NORTH);
		p2.add(clienteNoPrenotato,BorderLayout.EAST);
		p.add(p2, BorderLayout.CENTER);
		p.add(sceltaMenuButton, BorderLayout.SOUTH);
		//f.add(p);
		//f.setVisible(true);
		return p;
		
	}
}
