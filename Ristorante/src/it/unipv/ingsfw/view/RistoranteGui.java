package it.unipv.ingsfw.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


public class RistoranteGui extends JFrame{

	private JPanel p,p2;
	private JLabel lab;
	private JButton start;
	private JButton clienteButton,dipendenteButton,noPrenotazioneButton, aLaCarteButton, ayceButton, sceltaMenuButton, preparaTutto;
	private JSpinner clienteNoPrenotato;
	private JTextField nomeCliente;
	private JPasswordField passwordRistorante;
	private JTextArea ordini;
	private Border bordo;
	private int height, width;
	private GridBagConstraints  gbc;
	private SpinnerNumberModel value;
	private JButton prenota, indietro;
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
		this.vediOrdini();
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
		lab=new OurLabel("Sei un cliente o un dipendente?", SwingConstants.CENTER);
		lab.setPreferredSize(new Dimension(50,100));
		clienteButton.setPreferredSize(new Dimension(width/4,height/6));
		dipendenteButton.setPreferredSize(new Dimension(width/4,height/6));

		p2.add(clienteButton,BorderLayout.EAST);
		p2.add(dipendenteButton,BorderLayout.WEST);

		p.add(p2,BorderLayout.CENTER);
		p.add(lab,BorderLayout.NORTH);
		//p.add(clienteButton,BorderLayout.EAST);
		//p.add(dipendenteButton,BorderLayout.WEST);
		add(p);
		setVisible(true);
	}

	public void identificaCliente() {
		refreshPanel();

		lab=new OurLabel("Inserisci il nome della prenotazione", SwingConstants.CENTER);
		lab.setPreferredSize(new Dimension(50,100));
		nomeCliente=new JTextField();
		nomeCliente.setPreferredSize(new Dimension(width/4,height/8));

		noPrenotazioneButton= new OurButton("Non sei prenotato?");
		noPrenotazioneButton.setPreferredSize(new Dimension(width/4,height/8));

		setLayout (new BorderLayout());
		p2.add(nomeCliente,BorderLayout.CENTER);
		p.add(lab, BorderLayout.NORTH);
		p.add(noPrenotazioneButton,BorderLayout.SOUTH);
		p.add(p2, BorderLayout.CENTER);
		add(p);
		setVisible(true);
	}

	public void identificaDipendente() {
		refreshPanel();

		lab=new OurLabel("Inserisci la password del ristorante", SwingConstants.CENTER);
		lab.setPreferredSize(new Dimension(50,100));
		passwordRistorante=new JPasswordField();
		passwordRistorante.setPreferredSize(new Dimension(width/4,height/8));


		setLayout (new BorderLayout());
		p2.add(passwordRistorante,BorderLayout.CENTER);
		p.add(lab, BorderLayout.NORTH);
		p.add(p2, BorderLayout.CENTER);
		add(p);
		setVisible(true);
	}
	public void scegliMenu() {
		refreshPanel();

		aLaCarteButton=new OurButton("A La Carte");
		ayceButton=new OurButton("All you can eat");
		lab=new OurLabel("Scegli tra i due menu", SwingConstants.CENTER);
		lab.setPreferredSize(new Dimension(50,100));
		aLaCarteButton.setPreferredSize(new Dimension(width/4,height/6));
		ayceButton.setPreferredSize(new Dimension(width/4,height/6));

		p2.add(aLaCarteButton,BorderLayout.EAST);
		p2.add(ayceButton,BorderLayout.WEST);
		p.add(p2,BorderLayout.CENTER);
		p.add(lab,BorderLayout.NORTH);
		//p.add(clienteButton,BorderLayout.EAST);
		//p.add(dipendenteButton,BorderLayout.WEST);
		add(p);
		setVisible(true);
	}
	
	public void clienteNoPrenotato(int max) {
		refreshPanel();
		
		lab=new OurLabel("Inserisci il numero di posti", SwingConstants.CENTER);
		value = new SpinnerNumberModel (0, 0, max, 1);
		
		clienteNoPrenotato = new OurSpinner(value);
		clienteNoPrenotato.setPreferredSize(new Dimension(60, height/10));
		sceltaMenuButton = new OurButton("Vai alla scelta del menu");
		p2.add(lab,BorderLayout.NORTH);
		p2.add(clienteNoPrenotato,BorderLayout.EAST);
		p.add(p2, BorderLayout.CENTER);
		p.add(sceltaMenuButton, BorderLayout.SOUTH);
		add(p);
		setVisible(true);
		
	}
	
	public void operazioniDipendente() {
			refreshPanel();
			
	        setLayout(new GridBagLayout());

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
	        add(p, gbc);
	        setVisible(true);
	    }
	public void aggiungiPrenotazione(int max) {
		refreshPanel();
		
		lab=new OurLabel("Inserisci nome cliente e posti", SwingConstants.CENTER);
		value = new SpinnerNumberModel (0, 0, max, 1);
		
		clienteNoPrenotato = new OurSpinner(value);
		clienteNoPrenotato.setPreferredSize(new Dimension(60, height/10));
		nomeCliente=new JTextField();
		nomeCliente.setPreferredSize(new Dimension(width/4,height/8));
		
		prenota = new OurButton("Prenota il cliente");
		indietro = new OurButton ("Torna indietro");
		setLayout(new GridBagLayout());

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
        add(p, gbc);
        setVisible(true);
		
		
	}
	// da finire
	public void vediOrdini() {
		ordini=new JTextArea("No");
		ordini.setPreferredSize(new Dimension(20, 20));
		ordini.setLineWrap(true);
	    ordini.setEditable(false);
	    ordini.setVisible(true);
		JScrollPane scroll = new JScrollPane (ordini, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	  
		preparaTutto = new OurButton ("Prepara tutti gli ordini");
		indietro = new OurButton ("Torna indietro");
		setLayout(new GridBagLayout());

        gbc.gridwidth = GridBagConstraints.REMAINDER;        //senza questo li allinea in riga
        //gbc.anchor = GridBagConstraints.EAST;                
        gbc.fill = GridBagConstraints.HORIZONTAL; 		//bordi bottoni allineati (prova vertical per capire)
        p = new JPanel(new GridBagLayout());
        
        gbc.insets = new Insets(0, 0, 10, 0);
     
        p.add(scroll, gbc);
        
    
        
        gbc.insets = new Insets(0, 0, 10, 0);
        p.add(preparaTutto, gbc);
        gbc.insets = new Insets(0, 0, 10, 0);
   
        p.add(indietro, gbc);

        //gbc.weighty = 10;
        add(p, gbc);
        setVisible(true);
		
		
	}
	
	public JButton getPrenota() {
		return prenota;
	}


	public SpinnerNumberModel getValue() {
		return value;
	}


	public JLabel getLab() {
		return lab;
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


	public JSpinner getClienteNoPrenotato() {
		return clienteNoPrenotato;
	}


	public void setLab(String s) {
		lab.setText(s);
	}

	public JPanel getP() {
		return p;
	}

	public JPanel getP2() {
		return p2;
	}

	public JLabel getLabIdentificazione() {
		return lab;
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
