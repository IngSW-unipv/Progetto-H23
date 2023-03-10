package it.unipv.ingsfw.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import it.unipv.ingsfw.view.ourComponents.BackButton;
import it.unipv.ingsfw.view.ourComponents.OurButton;
import it.unipv.ingsfw.view.ourComponents.OurLabel;
import it.unipv.ingsfw.view.ourComponents.OurPanel;
import it.unipv.ingsfw.view.ourComponents.OurSpinner;
import it.unipv.ingsfw.view.ourComponents.OurTextField;

public class ClienteGui {

	private String defaultTextOfTotale;
	private JButton noPrenotazioneButton,aLaCarteButton,ayceButton,sceltaMenuButton, addButton,inviaOrdineButton, chiediContoButton, homeButton;
	private JPanel panel,statusPanel;
	private JLabel lab,totale;
	private JSpinner clienteNoPrenotatoSpinner, quantPiattoSpinner;
	private SpinnerNumberModel spinnerValue;
	private Border bordo;
	private GridBagConstraints gbc;
	private JTextField nomeClienteField;
	private JList<String> piattiMenu;
	private DefaultListModel<String> listModel;
	private JScrollPane scroll;

	public ClienteGui() {

		panel=new OurPanel();
		
		bordo=BorderFactory.createEmptyBorder(0,10,10,10);

		panel.setBorder(bordo);

		nomeClienteField=new OurTextField();
		homeButton = new BackButton();
		noPrenotazioneButton= new OurButton("Non hai prenotato?");
		aLaCarteButton=new OurButton("A La Carte");
		ayceButton=new OurButton("All you can eat");
		defaultTextOfTotale="Totale: ";
		totale=new OurLabel(defaultTextOfTotale, SwingConstants.CENTER, Color.RED);
		inviaOrdineButton=new OurButton("Aggiungi e invia Portata");

		chiediContoButton  = new OurButton ("Chiedi il conto");

		sceltaMenuButton = new OurButton("Vai alla scelta del menu");
		spinnerValue = new SpinnerNumberModel (0, 0, 1, 1);
		clienteNoPrenotatoSpinner = new OurSpinner(spinnerValue);
		quantPiattoSpinner = new OurSpinner(spinnerValue);
		listModel = new DefaultListModel<String>();
		piattiMenu = new JList<String>(listModel);
	}

	public JPanel identificaCliente() {

		createPanel();
		lab=new OurLabel("TAVOLO CON PRENOTAZIONE", SwingConstants.CENTER, Color.RED);
		OurLabel lab2 = new OurLabel("Nome della prenotazione: ", Color.BLACK);
		nomeClienteField.setFont(new Font("Italic", Font.ITALIC, 20));
		nomeClienteField.setPreferredSize(new Dimension(200,50));

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(30, 80, 0, 0);
		panel.add(lab2, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(30, 5, 0, 0);
		panel.add(nomeClienteField,gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(10, 0, 0, 0);
		panel.add(homeButton, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.PAGE_START;
		panel.add(noPrenotazioneButton, gbc);
		

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.insets = new Insets(100, 0, 0, 0);
		panel.add(lab,gbc);

		return panel;

	}

	public JButton getHomeButton() {
		return homeButton;
	}

	public JPanel clienteNoPrenotato(int max) {

		createPanel();
		spinnerValue.setValue(1);
		spinnerValue.setMinimum(1);
		spinnerValue.setMaximum(max);
		lab=new OurLabel("TAVOLO SENZA PRENOTAZIONE", SwingConstants.CENTER, Color.RED);
		OurLabel lab2 = new OurLabel("Inserisci numero posti: ");
		lab2.setForeground(Color.BLACK);

		clienteNoPrenotatoSpinner.setPreferredSize(new Dimension(60, 35));

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(30, 0, 0, 0);
		panel.add(lab2, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(30, 20, 0, 0);
		panel.add(clienteNoPrenotatoSpinner,gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.PAGE_START;
		panel.add(sceltaMenuButton, gbc);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.insets = new Insets(100, 0, 0, 0);
		panel.add(lab,gbc);

		return panel;
	}

	public JPanel scegliMenu() {
		createPanel();
		lab=new OurLabel("SCEGLI TIPO DI MENU", Color.RED);
		aLaCarteButton.setPreferredSize(new Dimension(230,400/6));
		ayceButton.setPreferredSize(new Dimension(230,400/6));

		gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 70, 250, 0);
        panel.add(ayceButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 10, 250, 0);
        panel.add(aLaCarteButton,gbc);

        gbc.insets = new Insets(180, 70, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(lab,gbc);

		return panel;
	}

	public JPanel addStatusPanel() {
        statusPanel= new OurPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        statusPanel.add(totale, gbc);
        statusPanel.add(chiediContoButton, gbc);
        return statusPanel;
    }


    public JPanel inviaOrdine(ArrayList<String> nomi, ArrayList<Integer> quantita) {
        createPanel();
        spinnerValue.setValue(0);
        spinnerValue.setMinimum(0);
        quantPiattoSpinner.setPreferredSize(new Dimension(50, 35));

        lab = new OurLabel("AGGIUNGI PORTATE AL TUO ORDINE", Color.RED);

        for(String p: nomi) {
            listModel.addElement(p);
        }

        piattiMenu.setModel(listModel);
        piattiMenu.setPreferredSize(new Dimension(400,400));
        scroll = new JScrollPane(piattiMenu);

        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        gbc.insets = new Insets(20, 20, 0, 0);
        gbc.gridx = 2;
        gbc.gridy = 3;


        gbc.anchor=GridBagConstraints.LINE_END;
        panel.add(addStatusPanel(), gbc);

        gbc.insets = new Insets(20, 360, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor =  GridBagConstraints.LINE_START;
        panel.add(lab, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor =  GridBagConstraints.LINE_START;
        panel.add(scroll, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor =  GridBagConstraints.LINE_END;
        panel.add(quantPiattoSpinner,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor =  GridBagConstraints.CENTER;
        panel.add(inviaOrdineButton,gbc);

        gbc.insets = new Insets(20, 20, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor =  GridBagConstraints.LINE_END;
        panel.add(quantPiattoSpinner,gbc);

        return panel;
    }
    
	public void createPanel() {
        panel = new OurPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        panel.setBorder(bordo);
    }
   
	public JButton getInviaOrdineButton() {
		return inviaOrdineButton;
	}

	public JButton getChiediContoButton() {
		return chiediContoButton;
	}



	public JButton getNoPrenotazioneButton() {
		return noPrenotazioneButton;
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

	public JButton getAddButton() {
		return addButton;
	}

	public JSpinner getClienteNoPrenotato() {
		return clienteNoPrenotatoSpinner;
	}

	public JSpinner getQuantPiattoSpinner() {
		return quantPiattoSpinner;
	}

	public SpinnerNumberModel getSpinnerValue() {
		return spinnerValue;
	}

	public JTextField getNomeClienteField() {
		return nomeClienteField;
	}

	public JList getPiattiMenu() {
		return piattiMenu;
	}

	public DefaultListModel getListModel() {
		return listModel;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public JLabel getTotale() {
		return totale;
	}

	public JButton getinviaOrdineButton() {
		return inviaOrdineButton;
	}
	
	public String getDefaultTextOfTotale() {
		return defaultTextOfTotale;
	}
}