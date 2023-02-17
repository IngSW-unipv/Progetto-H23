package it.unipv.ingsfw.view.ourComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;

public class OurLabel extends JLabel {
	private Font customFont;
	public OurLabel(String nome) {
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
//		setFont(new Font("Roman", Font.ROMAN_BASELINE, 25));
		setForeground(Color.BLACK);
	}

		public OurLabel(String nome, int i) {
			super(nome, i);
			try {
				customFont = Font.createFont(Font.TRUETYPE_FONT, new File("images/art-nuvo.ttf")).deriveFont(30f);
				GraphicsEnvironment ge = 
						GraphicsEnvironment.getLocalGraphicsEnvironment();
				ge.registerFont(customFont);
			} catch (IOException|FontFormatException e) {
				//Handle exception
			}
			setFont(customFont);
//			setFont(new Font("Roman", Font.ROMAN_BASELINE, 25));
			setForeground(Color.BLACK);
		}
}
