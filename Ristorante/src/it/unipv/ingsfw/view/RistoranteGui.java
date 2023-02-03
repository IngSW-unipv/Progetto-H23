package it.unipv.ingsfw.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


public class RistoranteGui extends JFrame{

	private JPanel p,p2;
	private JLabel labIdentificazione;
	private JButton start;
	private JButton clienteButton,dipendenteButton,noPrenotazioneButton;
	private JTextField nomeCliente;
	private JPasswordField passwordRistorante;
	private Border bordo;
	private int height, width;
	private GridBagConstraints  gbc;
	//private Container c;

	public RistoranteGui() {
		super("Ristorante");
		height = 400;
		width = 800;
		setSize(width, height);
		gbc = new GridBagConstraints();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //aggiungere salvare piatti e prenotazioni in db
		p=new JPanel();
		p2= new JPanel();
		bordo=BorderFactory.createEmptyBorder(0,10,10,10);
		p.setLayout(new BorderLayout());
		p.setBorder(bordo);
		add(p);
		this.startPage();
		setVisible(true);
	}

	
	public GridBagConstraints getGbc() {
		return gbc;
	}

	public void refreshPanel() {
		setVisible(false);
		this.getContentPane().removeAll();
	}

	public void startPage() {

		start=new OurButton("Tocca per iniziare.");
		start.setFont(new Font("Roman", Font.ROMAN_BASELINE, 50));
		add(start);
	}

	public JButton getStartButton() {
		return start;
	}

	public void sceltaPersona() {
        refreshPanel();

        clienteButton=new OurButton("Cliente");
        dipendenteButton=new OurButton("Dipendente");
        labIdentificazione=new JLabel("Sei un cliente o un dipendente?", SwingConstants.CENTER);
        labIdentificazione.setPreferredSize(new Dimension(50,100));
        clienteButton.setPreferredSize(new Dimension(width/4,height/6));
        dipendenteButton.setPreferredSize(new Dimension(width/4,height/6));
        
        p2.add(clienteButton,BorderLayout.EAST);
        p2.add(dipendenteButton,BorderLayout.WEST);
        
        p.add(p2,BorderLayout.CENTER);
        p.add(labIdentificazione,BorderLayout.NORTH);
        //p.add(clienteButton,BorderLayout.EAST);
        //p.add(dipendenteButton,BorderLayout.WEST);
        add(p);
        setVisible(true);
    }
	
	//da finire
	public void identificaCliente() {
		refreshPanel();
		
		labIdentificazione=new JLabel("Inserisci il nome della prenotazione", SwingConstants.CENTER);
		labIdentificazione.setPreferredSize(new Dimension(50,100));
		nomeCliente=new JTextField();
		nomeCliente.setPreferredSize(new Dimension(width/4,height/8));

		noPrenotazioneButton= new OurButton("Non sei prenotato?");
		noPrenotazioneButton.setPreferredSize(new Dimension(width/4,height/8));

		setLayout (new BorderLayout());
		p2.add(nomeCliente,BorderLayout.CENTER);
		p.add(labIdentificazione, BorderLayout.NORTH);
		p.add(noPrenotazioneButton,BorderLayout.SOUTH);
		p.add(p2, BorderLayout.CENTER);
		add(p);
		setVisible(true);
	}
	
	public void identificaDipendente() {
		refreshPanel();
		
		labIdentificazione=new JLabel("Inserisci la password del ristorante", SwingConstants.CENTER);
		labIdentificazione.setPreferredSize(new Dimension(50,100));
		passwordRistorante=new JPasswordField();
		passwordRistorante.setPreferredSize(new Dimension(width/4,height/8));


		setLayout (new BorderLayout());
		p2.add(passwordRistorante,BorderLayout.CENTER);
		p.add(labIdentificazione, BorderLayout.NORTH);
		p.add(p2, BorderLayout.CENTER);
		add(p);
		setVisible(true);
	}
	
	public JPanel getP() {
		return p;
	}

	public JPanel getP2() {
		return p2;
	}

	public JLabel getLabIdentificazione() {
		return labIdentificazione;
	}

	public JButton getStart() {
		return start;
	}

	public JButton getClienteButton() {
		return clienteButton;
	}

	public JButton getDipendenteButton() {
		return dipendenteButton;
	}

	public JButton getNoPrenotazioneButton() {
		return noPrenotazioneButton;
	}

	public JTextField getNomeCliente() {
		return nomeCliente;
	}

	public JPasswordField getPasswordRistorante() {
		return passwordRistorante;
	}

	public Border getBordo() {
		return bordo;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

}
