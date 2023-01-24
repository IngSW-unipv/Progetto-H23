package it.unipv.ingsfw.view;

import java.awt.*;
import javax.swing.*;


public class RistoranteGui extends JFrame{
	
	private JPanel p,p2;
	private JLabel labIdentificazione;
	private JButton start;
	private JButton clienteButton,dipendenteButton,noPrenotazioneButton;
	private JTextField nomeCliente;
	//private Container c;

	public RistoranteGui() {
		super("Ristorante");
		setSize(800,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //aggiungere salvare piatti e prenotazioni in db
		p=new JPanel();
		add(p);
		this.startPage();
		setVisible(true);
	}
	
	public void refreshPanel() {
		setVisible(false);
		this.getContentPane().removeAll();
	}
	
	public void startPage() {
		
		start=new JButton("Tocca per iniziare.");
		start.setBackground(Color.BLACK);
	    start.setForeground(Color.BLUE);
	    start.setFont(new Font("Roman", Font.ROMAN_BASELINE, 50));
	    add(start);
	}
	
	public JButton getStartButton() {
		return start;
	}
	
	public void sceltaPersona() {
		refreshPanel();
		
		clienteButton=new JButton("Cliente");
		dipendenteButton=new JButton("Dipendente");
		labIdentificazione=new JLabel("Sei un cliente o un dipendente?");
		labIdentificazione.setPreferredSize(new Dimension(50,100));
		clienteButton.setPreferredSize(new Dimension(380,100));
		dipendenteButton.setPreferredSize(new Dimension(380,100));
		
		setLayout (new BorderLayout());
		add(labIdentificazione,BorderLayout.NORTH);
		add(clienteButton,BorderLayout.EAST);
		add(dipendenteButton,BorderLayout.WEST);
		setVisible(true);
	}
	//da finire
	public void identificatiCliente() {
		refreshPanel();
		
		nomeCliente=new JTextField();
		nomeCliente.setPreferredSize(new Dimension(300,100));
		
		noPrenotazioneButton= new JButton("Non sei prenotato?");
		noPrenotazioneButton.setPreferredSize(new Dimension(300,100));
		
		setLayout (new BorderLayout());
		add(nomeCliente,BorderLayout.CENTER);
		add(noPrenotazioneButton,BorderLayout.SOUTH);
		
	}
}
