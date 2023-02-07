package it.unipv.ingsfw.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class RistoranteGui {

	protected JPanel p,p2;
	protected JLabel lab;
	protected JButton start;
	protected JButton clienteButton,dipendenteButton,indietro, preparaTutto;
	protected JSpinner clienteNoPrenotato;
	protected JTextField nomeCliente;
	protected Border bordo;
	protected int height, width;
	protected GridBagConstraints  gbc;
	protected SpinnerNumberModel value;
	private ClienteGui cg;
	protected JTextArea ordini;
	private DipendenteGui dg;
	protected JFrame f;
	//private Container c;

	public RistoranteGui() {
		
		f=new JFrame("Ristorante");
		height = 400;
		width = 800;
		f.setSize(width, height);
		gbc = new GridBagConstraints();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //aggiungere salvare piatti e prenotazioni in db
		p=new JPanel();
		p2= new JPanel();
		bordo=BorderFactory.createEmptyBorder(0,10,10,10);
		p.setLayout(new BorderLayout());
		p.setBorder(bordo);
		f.add(p);
		
		cg=new ClienteGui();
		dg=new DipendenteGui();
		
		this.vediOrdiniR();
		//f.setVisible(true);
		
	}

	public GridBagConstraints getGbc() {
		return gbc;
	}

	public void refreshPanel() {
		f.setVisible(false);
		f.getContentPane().removeAll();
	}

	public void startPage() {

		start=new OurButton("Tocca per iniziare.");
		start.setFont(new Font("Roman", Font.ROMAN_BASELINE, 50));
		f.add(start);
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
		f.add(p);
		f.setVisible(true);
	}
	//messo
	/*public void identificaCliente() {
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
	}*/
	//messo
	/*public void identificaDipendente() {
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
	//messo
	/*public void scegliMenu() {
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
	}*/
	//messo
	/*public void clienteNoPrenotato(int max) {
		refreshPanel();
		
		lab=new OurLabel("Inserisci il numero di posti", SwingConstants.CENTER);
		value = new SpinnerNumberModel (0, 0, max, 1);
		
		clienteNoPrenotato = new OurSpinner(value);
		clienteNoPrenotato.setPreferredSize(new Dimension(60, height/10));
		OurButton sceltaMenuButton = new OurButton("Vai alla scelta del menu");
		p2.add(lab,BorderLayout.NORTH);
		p2.add(clienteNoPrenotato,BorderLayout.EAST);
		p.add(p2, BorderLayout.CENTER);
		p.add(sceltaMenuButton, BorderLayout.SOUTH);
		f.add(p);
		f.setVisible(true);
		
	}*/
	//messo
	/*public void operazioniDipendente() {
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
	    }*/
	
	/*public void aggiungiPrenotazione(int max) {
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
		
		
	}*/
	//messo
	public void vediOrdini() {
		ordini=new JTextArea("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
				+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nHHHHHHHHHHHHHHHHHHHH"
				+ "HHHHHHHHHHHHHHH");
		
		JScrollPane scroll = new JScrollPane(ordini);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	  
	    lab=new OurLabel("Ordini da preparare", SwingConstants.CENTER);
		preparaTutto = new OurButton ("Prepara tutti gli ordini");
		indietro = new OurButton ("Torna indietro");
		
		p2.add(preparaTutto, BorderLayout.NORTH);
		p2.add(indietro, BorderLayout.SOUTH);
		
		p.add(lab, BorderLayout.NORTH);
		p.add(scroll, BorderLayout.CENTER);
		p.add(p2,BorderLayout.SOUTH);

		f.add(p);
        f.setVisible(true);	
	}

	public void identificaClienteR() {
		refreshPanel();
		f.add(cg.identificaCliente());
	}
	
	public void scegliMenuR() {
		refreshPanel();
		f.add(cg.scegliMenu());
	}
	
	public void clienteNoPrenotatoR(int max) {
		refreshPanel();
		f.add(cg.clienteNoPrenotato(max));
	}
	
	public void identificaDipendenteR() {
		refreshPanel();
		f.add(dg.identificaDipendente());
	}
	
	public void vediOrdiniR() {
		//refreshPanel();
		dg.vediOrdini();
		//f.add(dg.vediOrdini());
	}
	
	public SpinnerNumberModel getValue() {
		return value;
	}


	public JLabel getLab() {
		return lab;
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

	public JTextField getNomeCliente() {
		return nomeCliente;
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
