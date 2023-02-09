package it.unipv.ingsfw.view;

import java.awt.*;
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
	//private Container c;

	public RistoranteGui() {
		
		f=new JFrame("Ristorante");
		height = 400;
		width = 800;
		f.setSize(width, height);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //aggiungere salvare piatti e prenotazioni in db
		p=new JPanel();
		p2= new JPanel();
		bordo=BorderFactory.createEmptyBorder(0,10,10,10);
		
		p.setBorder(bordo);
		f.add(p);
		
		cg=new ClienteGui();
		dg=new DipendenteGui();
		
		this.operazioniDipendenteR();
		
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
		p.setLayout(new BorderLayout());
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
	

	public void identificaClienteR() {
		refreshPanel();
		cg.identificaCliente();
	}
	
	public void scegliMenuR() {
		refreshPanel();
		cg.scegliMenu();
	}
	
	public void clienteNoPrenotatoR(int max) {
		refreshPanel();
		cg.clienteNoPrenotato(max);
	}
	
	public void identificaDipendenteR() {
		refreshPanel();
		f.add(dg.identificaDipendente());
	}
	
	public void vediOrdiniR() {
		refreshPanel();
		dg.vediOrdini();
		//f.add(dg.vediOrdini());
	}
	
	public void addDishR() {
		refreshPanel();
		dg.addDish();
	}
	
	public void aggiungiPrenotazioneR(int max) {
		refreshPanel();
		dg.aggiungiPrenotazione(max);
	}
	
	public void operazioniDipendenteR() {
		refreshPanel();
		dg.operazioniDipendente();
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
