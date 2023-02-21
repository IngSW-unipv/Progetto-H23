package it.unipv.ingsfw.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import it.unipv.ingsfw.view.ourComponents.OurButton;
import it.unipv.ingsfw.view.ourComponents.OurLabel;
import it.unipv.ingsfw.view.ourComponents.OurPanel;

public class RistoranteGui {

	protected JPanel p,p2;
	protected JLabel background, lab;
	protected JButton start;
	protected JButton clienteButton,dipendenteButton,indietro;
	//protected JTextField nomeCliente;
	protected Border bordo;
	protected int height, width;
	private ClienteGui cg;
	protected JTextArea ordini;
	private DipendenteGui dg;
	protected JFrame f;
	protected GridBagConstraints gbc;
	protected Font customFont;


	public RistoranteGui() {

		f=new JFrame("Ristorante");
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		height = 640;
		width =1220;
		f.setSize(width, height);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//aggiungere salvare piatti e prenotazioni in db
		p=new OurPanel();
		p2= new OurPanel();
		gbc= new GridBagConstraints();
		bordo=BorderFactory.createEmptyBorder(0,10,10,10);
		
		p.setBorder(bordo);
		f.add(p);

		cg=new ClienteGui();
		dg=new DipendenteGui();

		start=new OurButton("");
		clienteButton=new OurButton("Cliente");
		dipendenteButton=new OurButton("Dipendente");
		//clienteButton.setFont(customFont);
		
		
		f.setLayout(new BorderLayout());
		
		background=new JLabel(new ImageIcon("images/start-page.png"));
//		background.setLayout(new BorderLayout());
		
		
		this.startPage();
		f.add(background, BorderLayout.CENTER);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}

	public void anotherRefreshPanel() {
		f.setVisible(false);
		f.getContentPane().removeAll();
		background=new JLabel(new ImageIcon("images/background.png"));
		background.setLayout(new BorderLayout());
		f.setSize(width, height);
		f.add(background);
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
		f.setLayout(new BorderLayout());
		start.setBorderPainted(false);
		f.add(start, BorderLayout.CENTER);
		f.setVisible(true);
	}

	public JButton getStartButton() {
		return start;
	}

	public void sceltaPersona() {
		anotherRefreshPanel();

		p.setLayout(new BorderLayout());

		lab=new OurLabel("Sei un cliente o un dipendente?", SwingConstants.CENTER, Color.RED);
		lab.setPreferredSize(new Dimension(50,100));
		clienteButton.setPreferredSize(new Dimension(250,50));
		dipendenteButton.setPreferredSize(new Dimension(250,50));
		//p2.setOpaque(false);
		p2.add(clienteButton,BorderLayout.EAST);
		p2.add(dipendenteButton,BorderLayout.WEST);
		//p.setOpaque(false);
		p.add(p2,BorderLayout.CENTER);
		p.add(lab,BorderLayout.NORTH);
		//p.add(clienteButton,BorderLayout.EAST);
		//p.add(dipendenteButton,BorderLayout.WEST);
		background.add(p, BorderLayout.CENTER);
		f.setVisible(true);
	}


	public void identificaClienteR() {
		aggiungiPannello(cg.identificaCliente());
	}

	public void scegliMenuR() {
		aggiungiPannello(cg.scegliMenu());
	}

	public void clienteNoPrenotatoR(int i) {
		anotherRefreshPanel();
		background.add(cg.clienteNoPrenotato(i));
		f.setVisible(true);
	}

	public void identificaDipendenteR() {
		aggiungiPannello(dg.identificaDipendente());
	}

	public JFrame getF() {
		return f;
	}

	public void vediOrdiniR(String ordiniText) {
		aggiungiPannello(dg.vediOrdini(ordiniText));
	}

	public void addDishR() {
		aggiungiPannello(dg.addDish());
	}

	public void aggiungiPrenotazioneR(int max) {
		anotherRefreshPanel();
		background.add(dg.aggiungiPrenotazione(max));
		f.setVisible(true);
	}

	public void operazioniDipendenteR() {
		aggiungiPannello(dg.operazioniDipendente());
	}
	
	public void inviaOrdineR(ArrayList<String> nomi, ArrayList<Integer> quantita) {
		aggiungiPannello(cg.inviaOrdine(nomi, quantita));
	}
	
//	public void inviaOrdineR() {
//		aggiungiPannello(cg.inviaOrdine());
//	}
//	
	private void aggiungiPannello(JPanel panel) {
		anotherRefreshPanel();
		background.add(panel);
		f.setVisible(true);
	}

	public void popUpErrore(String s) {
		JOptionPane.showMessageDialog(null, s, "ERRORE", JOptionPane.INFORMATION_MESSAGE);
	}

	public JButton getTornaIndietroButton() {
		return dg.getTornaIndietroButton();
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

//	public JTextField getNomeCliente() {
//		return nomeCliente;
//	}

	public Border getBordo() {
		return bordo;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	public JPasswordField getPasswordRistorante() {
		return dg.getPasswordRistorante();
	}
	
	public JButton getAggiungiPrenotazioneButton() {
		return dg.getAggiungiPrenotazioneButton();
	}

	public JButton getAggiungiQuantitaButton() {
		return dg.getAggiungiQuantitaButton();
	}

	public JButton getVediOrdiniButton() {
		return dg.getVediOrdiniButton();
	}

	public JButton aggiungiPrenotazioneButton() {
		return dg.getAggiungiPrenotazioneButton();
	}
	//text field per inserire nome cliente
	public JTextField getClienteDaPrenotare() {
		return dg.getNomeCliente();
	}
	//spinner per inserire il numero di persone nella prenotazione
	public JSpinner getClienteNoPrenotatoD() {
		return dg.getClienteNoPrenotato();
	}
	
	public JButton getPrenotaClienteButton() {
		return dg.getPrenota();
	}
	//textField dove il cliente inserisce il nome col quale ha prenotato
	public JTextField getNomeClienteField() {
		return cg.getNomeClienteField();
	}
	
	public JButton getNoPrenotazioneButton() {
		return cg.getNoPrenotazioneButton();
	}
	//bottone "vai a scelta menù" nella gui del cliente senza prenotazione
	public JButton getSceltaMenuButton() {
		return cg.getSceltaMenuButton();
	}
	//spinner per inserire il numero di persone nella sezione cliente senza prenotazione 
	public JSpinner getClienteNoPrenotato() {
		return cg.getClienteNoPrenotato();
	}
	
	public JButton getAyceButton() {
		return cg.getAyceButton();
	}
	
	public JButton getALaCaButton() {
		return cg.getaLaCarteButton();
	}
	//lista dove il cliente vede i piatti che può ordinare
	public JList getPiattiMenu() {
		return cg.getPiattiMenu();
	}
	//spinner per inserire la quantità del piatto
	public JSpinner getQuantPiattoSpinner() {
		return cg.getQuantPiattoSpinner();
	}
	
	public SpinnerNumberModel getValueC() {
		//cg.getValue().setValue(0);
		return cg.getValue();
	}
	
	public void azzeraValueC() {
		this.getValueC().setMinimum(0);
		this.getValueC().setMaximum(0);
		this.getValueC().setValue(0);
	}
	
	public SpinnerNumberModel getValueD() {
		return dg.getValue();
	}
	
	public JLabel getTotale() {
		return cg.getTotale();
	}
	
	public JButton getinviaOrdineButton() {
		return cg.getinviaOrdineButton();
	}
	//bottone aggiungi nella pagina per aggiornare le quantità
	public JButton getAggiungi() {
		return dg.getAggiungi();
	}
	
	public JTextField getNomePiattoField() {
		return dg.getNomePiattoField();
	}
	
	public JSpinner getQuantitySpinner() {
		return dg.getQuantitySpinner();
	}
	//textarea dove il dipendente vede gli ordini
	public JTextArea getOrdini() {
		return dg.getOrdini();
	}
}







