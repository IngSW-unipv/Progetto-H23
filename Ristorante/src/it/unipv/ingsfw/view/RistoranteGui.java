package it.unipv.ingsfw.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class RistoranteGui {

	protected JPanel p,p2;
	protected JLabel lab;
	protected JButton start;
	protected JButton clienteButton,dipendenteButton,indietro;
	protected JTextField nomeCliente;
	protected Border bordo;
	protected int height, width;
	private ClienteGui cg;
	protected JTextArea ordini;
	private DipendenteGui dg;
	protected JFrame f;
	protected GridBagConstraints gbc;


	public RistoranteGui() {

		f=new JFrame("Ristorante");
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		height = 640;
		width =1220;
		f.setSize(width, height);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//aggiungere salvare piatti e prenotazioni in db
		p=new JPanel();
		p2= new JPanel();
		gbc= new GridBagConstraints();
		bordo=BorderFactory.createEmptyBorder(0,10,10,10);
		

		p.setBorder(bordo);
		f.add(p);

		cg=new ClienteGui();
		dg=new DipendenteGui();

		this.addDishR();
		f.setVisible(true);

	}

	public void refreshPanel() {
		Image backgroundImage = Toolkit.getDefaultToolkit().getImage("images/sfondo-riga-ricette.png");
		f.setVisible(false);
		f.getContentPane().removeAll();
		f.setContentPane(new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundImage, 0, 0, null);
			}
		});

		
		f.pack();
		f.setSize(width, height);
		f.setVisible(true);
	}

	public void startPage() {
		refreshPanel();
		f.setLayout(new BorderLayout());
		/*JLabel background=new JLabel(new ImageIcon("C:\\Users\\gabri\\Desktop\\sfondo-riga-ricette.png"));
		f.add(background, BorderLayout.CENTER);
		background.setLayout(new BorderLayout());
		start=new OurButton("Tocca per iniziare.");
		start.setFont(new Font("Roman", Font.ROMAN_BASELINE, 50));
		background.add(start);*/
		start=new OurButton("Tocca per iniziare.");
		start.setFont(new Font("Roman", Font.ROMAN_BASELINE, 50));
		f.add(start, BorderLayout.CENTER);
		f.setVisible(true);
	}


	public void startPage2() {

		f.setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon("C:\\Users\\gabri\\Desktop\\sfondo-riga-ricette.png"));
		f.add(background, BorderLayout.CENTER);
		// background.setLayout(new FlowLayout());
		JLabel l1=new JLabel("Here is a button");
		JButton b1=new JButton("I am a button");
		background.add(l1);
		background.add(b1);
		f.setVisible(true);
	}

	public JButton getStartButton() {
		return start;
	}

	public void sceltaPersona() {
		refreshPanel();

		p.setLayout(new BorderLayout());
		clienteButton=new OurButton("Cliente");
		dipendenteButton=new OurButton("Dipendente");
		lab=new OurLabel("Sei un cliente o un dipendente?", SwingConstants.CENTER);
		lab.setPreferredSize(new Dimension(50,100));
		clienteButton.setPreferredSize(new Dimension(width/4,height/6));
		dipendenteButton.setPreferredSize(new Dimension(width/4,height/6));
		p2.setOpaque(false);
		p2.add(clienteButton,BorderLayout.EAST);
		p2.add(dipendenteButton,BorderLayout.WEST);
		p.setOpaque(false);
		p.add(p2,BorderLayout.CENTER);
		p.add(lab,BorderLayout.NORTH);
		//p.add(clienteButton,BorderLayout.EAST);
		//p.add(dipendenteButton,BorderLayout.WEST);
		f.add(p);
		f.setVisible(true);
	}


	public void identificaClienteR() {
		refreshPanel();
		cg.identificaCliente();
	}

	public void scegliMenuR() {
		refreshPanel();
//		f.setLayout(new BorderLayout());
		f.add(cg.scegliMenu2());
	}

	public void clienteNoPrenotatoR(int max) {
		refreshPanel();
		f.add(cg.clienteNoPrenotato(max));
	}

	public void identificaDipendenteR() {
		refreshPanel();
		dg.identificaDipendente();
	}

	public void vediOrdiniR() {
		refreshPanel();
		dg.vediOrdini();
		//f.add(dg.vediOrdini());
	}

	public void addDishR() {
		refreshPanel();
		f.setLayout(new GridBagLayout());
		//gbc.insets = new Insets(30, 0, 0, 0);
		f.add(dg.addDish(), gbc);
	}

	public void aggiungiPrenotazioneR(int max) {
		refreshPanel();
		dg.aggiungiPrenotazione(max);
	}

	public void operazioniDipendenteR() {
		refreshPanel();
		f.add(dg.operazioniDipendente());
	}

	public void inviaOrdineR() {
		cg.inviaOrdine();
	}

	public JLabel getLab() {
		return lab;
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
