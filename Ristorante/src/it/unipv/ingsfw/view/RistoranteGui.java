package it.unipv.ingsfw.view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

import it.unipv.ingsfw.view.ourComponents.BackButton;
import it.unipv.ingsfw.view.ourComponents.OurButton;
import it.unipv.ingsfw.view.ourComponents.OurLabel;
import it.unipv.ingsfw.view.ourComponents.OurPanel;

public class RistoranteGui implements IRistoranteGUI{

	protected JPanel p,p2;
	protected JLabel background, lab/*,dip*/;
	protected JButton startButton, backButton;
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
		//		gbc= new GridBagConstraints();
		bordo=BorderFactory.createEmptyBorder(0,10,10,10);

		//dip=new OurLabel("");

		p.setBorder(bordo);
		f.add(p);

		cg=new ClienteGui();
		dg=new DipendenteGui();

		startButton=new OurButton("");
		backButton = new BackButton();
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
	@Override
	public void refreshPanel() {
		f.setVisible(false);
		f.getContentPane().removeAll();
		background=new JLabel(new ImageIcon("images/background.png"));
		background.setLayout(new BorderLayout());
		f.setSize(width, height);
		f.add(background);
		f.setVisible(true);
	}

	@Override
	public void startPage() {
		f.setLayout(new BorderLayout());
		startButton.setBorderPainted(false);
		f.add(startButton, BorderLayout.CENTER);
		f.setVisible(true);
	}
	@Override
	public JButton getStartButton() {
		return startButton;
	}

	@Override
	public void lastClientPage() {
		f.setVisible(false);
		f.getContentPane().removeAll();
		background=new JLabel(new ImageIcon("images/endPage.png"));
		background.setLayout(new BorderLayout());
		f.setSize(width, height);
		f.add(background);
		f.setVisible(true);
	}

	public void sceltaPersona() {
		refreshPanel();

		p = new OurPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		lab=new OurLabel("SEI UN CLIENTE O DIPENDENTE?", SwingConstants.CENTER, Color.RED);
		clienteButton.setPreferredSize(new Dimension(230,400/6));
		dipendenteButton.setPreferredSize(new Dimension(230,400/6));

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(0, 70, 250, 0);
		p.add(clienteButton, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 10, 250, 0);
		p.add(dipendenteButton,gbc);

		gbc.insets = new Insets(180, 70, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		p.add(lab,gbc);

		background.add(p, BorderLayout.CENTER);
		f.setVisible(true);

	}

	@Override
	public void identificaClienteR() {
		aggiungiPannello(cg.identificaCliente());
	}
	@Override
	public void scegliMenuR() {
		aggiungiPannello(cg.scegliMenu());
	}
	@Override
	public void clienteNoPrenotatoR(int i) {
		refreshPanel();
		background.add(cg.clienteNoPrenotato(i));
		f.setVisible(true);
	}
	@Override
	public void identificaDipendenteR() {
		//		dip=dg.refreshDipendente(dg.identificaDipendente());
		//		f.add(dip);
		//		f.setVisible(true);
		aggiungiPannello(dg.identificaDipendente());
	}
	@Override
	public JFrame getF() {
		return f;
	}
	@Override
	public void vediOrdiniR(String ordiniText) {
		//		dip=dg.refreshDipendente(dg.vediOrdini(ordiniText));
		//		f.add(dip);
		//		f.setVisible(true);
		aggiungiPannello(dg.vediOrdini(ordiniText));
	}
	
	@Override
	public void addDishR() {
		aggiungiPannello(dg.addDish());
	}
	@Override
	public void aggiungiPrenotazioneR(int max) {
		refreshPanel();
		background.add(dg.aggiungiPrenotazione(max));
		f.setVisible(true);
	}
	@Override
	public void operazioniDipendenteR() {
		aggiungiPannello(dg.operazioniDipendente());
	}
	@Override
	public void inviaOrdineR(ArrayList<String> nomi, ArrayList<Integer> quantita) {
		aggiungiPannello(cg.inviaOrdine(nomi, quantita));
	}
	@Override
	public void aggiungiPannello(JPanel panel) {
		refreshPanel();
		background.add(panel);
		f.setVisible(true);
	}
	@Override
	public void popUpErrore(String s) {
		JOptionPane.showMessageDialog(null, s, "ERRORE", JOptionPane.INFORMATION_MESSAGE);
	}
	@Override
	public JButton getHomeButton() {
		return dg.getHomeButton();
	}

	@Override
	public JButton getHomeClienteButton() {
		return cg.getHomeButton();
	}

	@Override
	public JButton getTornaIndietroButton() {
		return dg.getTornaIndietroButton();
	}
	@Override
	public JLabel getLab() {
		return lab;
	}
	@Override
	public void setLab(String s) {
		lab.setText(s);
	}
	@Override
	public JPanel getP() {
		return p;
	}
	@Override
	public JPanel getP2() {
		return p2;
	}
	@Override
	public JLabel getLabIdentificazione() {
		return lab;
	}
	@Override
	public JButton getStart() {
		return startButton;
	}
	@Override
	public JButton getClienteButton() {
		return clienteButton;
	}
	@Override
	public JButton getDipendenteButton() {
		return dipendenteButton;
	}
	@Override
	public Border getBordo() {
		return bordo;
	}
	@Override
	public int getHeight() {
		return height;
	}
	@Override
	public int getWidth() {
		return width;
	}
	@Override
	public JPasswordField getPasswordRistorante() {
		return dg.getPasswordRistorante();
	}
	@Override
	public char[] getPasswordOfPasswordRistorante() {
		return this.getPasswordRistorante().getPassword();
	}
	@Override
	public JLabel getPostiLiberiLabel() {
		return dg.getLabPosti();
	}

	@Override
	public JLabel getClientiPrenotatiLabel() {
		return dg.getLabClientiPrenotati();
	}

	@Override
	public JButton getAggiungiPrenotazioneButton() {
		return dg.getAggiungiPrenotazioneButton();
	}
	@Override
	public JButton getAggiungiQuantitaButton() {
		return dg.getAggiungiQuantitaButton();
	}
	@Override
	public JButton getVediOrdiniButton() {
		return dg.getVediOrdiniButton();
	}
	@Override
	public JButton getVediPrenotazioniButton() {
		return dg.getVediPrenotazioniButton();
	}
	@Override
	public JButton aggiungiPrenotazioneButton() {
		return dg.getAggiungiPrenotazioneButton();
	}

	@Override
	public JTextArea getPrenotazioniArea() {
		return dg.getPrenotazioniArea();
	}

	//text field per inserire nome cliente
	@Override
	public JTextField getClienteDaPrenotare() {
		return dg.getNomeCliente();
	}
	@Override
	public String getTextOfClienteDaPrenotare() {
		return this.getClienteDaPrenotare().getText();
	}

	@Override
	public void setTextOfClienteDaPrenotare(String s) {
		this.getClienteDaPrenotare().setText(s);
	}

	//spinner per inserire il numero di persone nella prenotazione
	@Override
	public JSpinner getClienteNoPrenotatoD() {
		return dg.getClienteNoPrenotato();
	}
	@Override
	public int getValueOfClienteNoPrenotatoD() {
		return (int)this.getClienteNoPrenotatoD().getValue();
	}
	@Override
	public JButton getPrenotaClienteButton() {
		return dg.getPrenota();
	}
	//textField dove il cliente inserisce il nome col quale ha prenotato
	@Override
	public JTextField getNomeClienteField() {
		return cg.getNomeClienteField();
	}
	@Override
	public void setTextOfNomeClienteField(String s) {
		this.getNomeClienteField().setText(s);
	}
	@Override
	public String getTextNomeClienteField() {
		return this.getNomeClienteField().getText();
	}
	@Override
	public JButton getNoPrenotazioneButton() {
		return cg.getNoPrenotazioneButton();
	}
	//bottone "vai a scelta men�" nella gui del cliente senza prenotazione
	@Override
	public JButton getSceltaMenuButton() {
		return cg.getSceltaMenuButton();
	}
	//spinner per inserire il numero di persone nella sezione cliente senza prenotazione 
	@Override
	public JSpinner getClienteNoPrenotato() {
		return cg.getClienteNoPrenotato();
	}
	@Override
	public int getValueClienteNoPrenotato() {
		return (int)this.getClienteNoPrenotato().getValue();
	}
	@Override
	public JButton getAyceButton() {
		return cg.getAyceButton();
	}
	@Override
	public JButton getALaCaButton() {
		return cg.getaLaCarteButton();
	}

	//lista dove il cliente vede i piatti che pu� ordinare
	@Override
	public JList getPiattiMenu() {
		return cg.getPiattiMenu();
	}
	@Override
	public int getSelectedIndexOfPiattiMenu() {
		return this.getPiattiMenu().getSelectedIndex();
	}
	@Override
	public Object getSelectedValueOfPiattiMenu() {
		return this.getPiattiMenu().getSelectedValue();
	}

	//spinner per inserire la quantit� del piatto
	@Override
	public JSpinner getQuantPiattoSpinner() {
		return cg.getQuantPiattoSpinner();
	}
	@Override
	public int getValueOfQuantPiattoSpinner() {
		return (int)this.getQuantPiattoSpinner().getValue();
	}
	@Override
	public SpinnerNumberModel getValueC() {
		//cg.getValue().setValue(0);
		return cg.getValue();
	}
	@Override
	public int getMinimumOfValueC() {
		return (int)this.getValueC().getMinimum();
	}
	@Override
	public int getValueOfValueC() {
		return (int)this.getValueC().getValue();
	}
	@Override
	public void setValueOfValueC(int i) {
		this.getValueC().setValue(i);
	}
	@Override
	public void setMaxOfValueC(int i) {
		this.getValueC().setMaximum(i);
	}
	@Override
	public void azzeraValueC() {
		this.getValueC().setMinimum(0);
		this.getValueC().setMaximum(0);
		this.getValueC().setValue(0);
	}
	@Override
	public SpinnerNumberModel getValueD() {
		return dg.getValue();
	}
	@Override
	public void setMaxOfValueD(int i) {
		this.getValueD().setMaximum(i);
	}
	@Override
	public void setValueOfValueD(int i) {
		this.getValueD().setValue(i);
	}
	@Override
	public int getValueOfValueD() {
		return (int)this.getValueD().getValue();
	}
	@Override
	public JLabel getTotale() {
		return cg.getTotale();
	}
	@Override
	public void setTextOfTotale(String s) {
		this.getTotale().setText(s);
	}
	@Override
	public JButton getinviaOrdineButton() {
		return cg.getinviaOrdineButton();
	}
	//bottone aggiungi nella pagina per aggiornare le quantit�
	@Override
	public JButton getAggiungi() {
		return dg.getAggiungi();
	}
	@Override
	public JTextField getNomePiattoField() {
		return dg.getNomePiattoField();
	}
	@Override
	public String getTextOfNomePiattoField() {
		return this.getNomePiattoField().getText();
	}
	@Override
	public void setTextOfNomePiattoField(String s) {
		this.getNomePiattoField().setText(s);
	}
	@Override
	public JSpinner getQuantitySpinner() {
		return dg.getQuantitySpinner();
	}
	@Override
	public int getValueOfQuantitySpinner() {
		return (int)this.getQuantitySpinner().getValue();
	}

	//textarea dove il dipendente vede gli ordini
	@Override
	public JTextArea getOrdini() {
		return dg.getOrdini();
	}
	@Override
	public void setTextOfOrdini(String s) {
		this.getOrdini().setText(s);
	}
	// Jbutton che usa il dipendente per preparare tutti gli ordini
	@Override
	public JButton getPreparaTuttoButton() {
		return dg.getPreparaTutto();
	}
	// Jbutton che fa chiedere il conto al cliente
	@Override
	public JButton getChiediContoButton() {
		return cg.getChiediContoButton();
	}

	@Override
	public void setTextOfPostiLiberiLabel(String s) {
		this.getPostiLiberiLabel().setText(s);
	}

	@Override
	public void setTextOfClientiPrenotatiLabel(String s) {
		this.getClientiPrenotatiLabel().setText(s);
	}

	@Override
	public String getDefaultTextOfLabPosti() {
		return dg.getDefaultTextOfLabPosti();
	}

	@Override
	public String getDefaultTextOfLabClientiPrenotati() {
		return dg.getDefaultTextOfLabClientiPrenotati();
	}
	@Override
	public String getDefaultTextOfTotale() {
		return cg.getDefaultTextOfTotale();
	}
}







