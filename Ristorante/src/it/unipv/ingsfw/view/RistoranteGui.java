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

	protected JPanel panel;
	protected JLabel background, label;
	protected JButton startButton, backButton, endButton, clienteButton,dipendenteButton;
	protected Border bordo;
	protected int height, width;
	private ClienteGui cg;
	protected JTextArea ordini;
	private DipendenteGui dg;
	protected JFrame mainFrame;


	public RistoranteGui() {

		mainFrame=new JFrame("Ristorante");
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		height = 640;
		width =1220;
		mainFrame.setSize(width, height);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new OurPanel();
		
		bordo=BorderFactory.createEmptyBorder(0,10,10,10);

		panel.setBorder(bordo);
		mainFrame.add(panel);

		cg=new ClienteGui();
		dg=new DipendenteGui();

		startButton=new OurButton("");
		endButton=new OurButton("");
		backButton = new BackButton();
		clienteButton=new OurButton("Cliente");
		dipendenteButton=new OurButton("Dipendente");

		mainFrame.setLayout(new BorderLayout());

		background=new JLabel(new ImageIcon("images/start-page.png"));

		this.startPage();
		mainFrame.add(background, BorderLayout.CENTER);
		mainFrame.setLocationRelativeTo(null);

	}
	@Override
	public void refreshPanel() {
		mainFrame.setVisible(false);
		mainFrame.getContentPane().removeAll();
		background=new JLabel(new ImageIcon("images/background.png"));
		background.setLayout(new BorderLayout());
		mainFrame.setSize(width, height);
		mainFrame.add(background);
		mainFrame.setVisible(true);
	}

	@Override
	public void startPage() {
		mainFrame.setLayout(new BorderLayout());
		startButton.setBorderPainted(false);
		mainFrame.add(startButton, BorderLayout.CENTER);
		mainFrame.setVisible(true);
	}
	@Override
	public JButton getStartButton() {
		return startButton;
	}

	@Override
	public void lastPage() {
		mainFrame.setVisible(false);
		mainFrame.getContentPane().removeAll();
		background=new JLabel(new ImageIcon("images/endPage.png"));
		background.setLayout(new BorderLayout());
		endButton.setBorderPainted(false);
		background.add(endButton, BorderLayout.CENTER);
		mainFrame.setSize(width, height);
		mainFrame.add(background);
		mainFrame.setVisible(true);
	}

	public void sceltaPersona() {
		refreshPanel();
		panel = new OurPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		label=new OurLabel("SEI UN CLIENTE O DIPENDENTE?", SwingConstants.CENTER, Color.RED);
		clienteButton.setPreferredSize(new Dimension(230,400/6));
		dipendenteButton.setPreferredSize(new Dimension(230,400/6));

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(0, 70, 250, 0);
		panel.add(clienteButton, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 10, 250, 0);
		panel.add(dipendenteButton,gbc);

		gbc.insets = new Insets(180, 70, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(label,gbc);

		background.add(panel, BorderLayout.CENTER);
		mainFrame.setVisible(true);

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
		mainFrame.setVisible(true);
	}
	@Override
	public void identificaDipendenteR() {
		aggiungiPannello(dg.identificaDipendente());
	}

	@Override
	public void vediOrdiniR(String ordiniText) {
		aggiungiPannello(dg.vediOrdini(ordiniText));
	}
	
	@Override
	public void vediPrenotazioniR(String prenotazioniText) {
		aggiungiPannello(dg.vediPrenotazioni(prenotazioniText));
	}
	
	@Override
	public void addDishR() {
		aggiungiPannello(dg.addDish());
	}
	@Override
	public void aggiungiPrenotazioneR(int max) {
		refreshPanel();
		background.add(dg.aggiungiPrenotazione(max));
		mainFrame.setVisible(true);
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
		mainFrame.setVisible(true);
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
	public JButton getEndButton() {
		return endButton;
	}
	@Override
	public JButton getTornaIndietroButton() {
		return dg.getTornaIndietroButton();
	}
	
	@Override
	public JLabel getLabIdentificazione() {
		return label;
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
	public JTextField getNomeClienteFieldD() {
		return dg.getNomeClienteField();
	}
	@Override
	public String getTextOfClienteDaPrenotare() {
		return this.getNomeClienteFieldD().getText();
	}

	@Override
	public void setTextOfClienteDaPrenotare(String s) {
		this.getNomeClienteFieldD().setText(s);
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
		return dg.getPrenotaButton();
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
	public SpinnerNumberModel getSpinnerValueC() {
		//cg.getValue().setValue(0);
		return cg.getSpinnerValue();
	}
	@Override
	public int getMinimumOfValueC() {
		return (int)this.getSpinnerValueC().getMinimum();
	}
	@Override
	public int getValueOfValueC() {
		return (int)this.getSpinnerValueC().getValue();
	}
	@Override
	public void setValueOfValueC(int i) {
		this.getSpinnerValueC().setValue(i);
	}
	@Override
	public void setMaxOfValueC(int i) {
		this.getSpinnerValueC().setMaximum(i);
	}
	@Override
	public void azzeraValueC() {
		this.getSpinnerValueC().setMinimum(0);
		this.getSpinnerValueC().setMaximum(0);
		this.getSpinnerValueC().setValue(0);
	}
	@Override
	public SpinnerNumberModel getSpinnerValueD() {
		return dg.getSpinnerValue();
	}
	@Override
	public void setMaxOfValueD(int i) {
		this.getSpinnerValueD().setMaximum(i);
	}
	@Override
	public void setValueOfValueD(int i) {
		this.getSpinnerValueD().setValue(i);
	}
	@Override
	public int getValueOfValueD() {
		return (int)this.getSpinnerValueD().getValue();
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
	//bottone aggiorna nella pagina per aggiornare le quantit�
	@Override
	public JButton getAggiornaQuantitaButton() {
		return dg.getAggiornaQuantitaButton();
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







