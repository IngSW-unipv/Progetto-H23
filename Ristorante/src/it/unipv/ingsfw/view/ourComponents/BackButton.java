package it.unipv.ingsfw.view.ourComponents;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class BackButton extends OurButton {
	private ImageIcon img;
	public BackButton() {
		img = new ImageIcon("images/icons8.png");
		setText("Indietro");
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(img);
	}
}
