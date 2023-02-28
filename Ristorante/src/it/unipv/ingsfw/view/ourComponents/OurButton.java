package it.unipv.ingsfw.view.ourComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;

public class OurButton extends JButton {
	public Font customFont;
	public OurButton(String nome) {
		super(nome);
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("images/art-nuvo.ttf")).deriveFont(30f);
			GraphicsEnvironment ge = 
					GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(customFont);
		} catch (IOException|FontFormatException e) {
			//Handle exception
		}
		setFont(customFont);
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		//setFont(new Font("Roman", Font.ROMAN_BASELINE, 25));
		setOpaque(false);
		

		setContentAreaFilled(false);

		setBorder(new RoundedBorder(10));
	}
}
