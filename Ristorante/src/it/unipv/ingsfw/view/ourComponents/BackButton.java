package it.unipv.ingsfw.view.ourComponents;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class BackButton extends JButton {
	private ImageIcon img;
	public BackButton() {
		img = new ImageIcon("images/icons8.png");
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(img);
	}
	
}
