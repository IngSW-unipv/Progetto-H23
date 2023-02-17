package it.unipv.ingsfw.view.ourComponents;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JPanel;


public class OurPanel extends JPanel {
	public OurPanel() {
		super();
		super.setOpaque(false);
	}
	public OurPanel(GridBagLayout l) {
		super(l);
		super.setOpaque(false);
	}
	public OurPanel(BorderLayout b) {
		super(b);
		super.setOpaque(false);
	}

}
