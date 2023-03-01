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
			e.printStackTrace();
		}
		setFont(customFont);
	}

		public OurLabel(String nome, int i) {
			super(nome, i);
			try {
				customFont = Font.createFont(Font.TRUETYPE_FONT, new File("images/art-nuvo.ttf")).deriveFont(30f);
				GraphicsEnvironment ge = 
						GraphicsEnvironment.getLocalGraphicsEnvironment();
				ge.registerFont(customFont);
			} catch (IOException|FontFormatException e) {
				e.printStackTrace();
			}
			setFont(customFont);
		}
		
		//costruttore in cui passi un colore, aggiunto printStackTrace nel catch dell'exception
		
		public OurLabel(String nome, Color colore) {
			super(nome);
			try {
				customFont = Font.createFont(Font.TRUETYPE_FONT, new File("images/art-nuvo.ttf")).deriveFont(30f);
				GraphicsEnvironment ge = 
						GraphicsEnvironment.getLocalGraphicsEnvironment();
				ge.registerFont(customFont);
			} catch (IOException|FontFormatException e) {
				e.printStackTrace();
			}
			setFont(customFont);
			setForeground(colore);
		}
		
		public OurLabel(String nome, int i, Color colore) {
			super(nome, i);
			try {
				customFont = Font.createFont(Font.TRUETYPE_FONT, new File("images/art-nuvo.ttf")).deriveFont(30f);
				GraphicsEnvironment ge = 
						GraphicsEnvironment.getLocalGraphicsEnvironment();
				ge.registerFont(customFont);
			} catch (IOException|FontFormatException e) {
				e.printStackTrace();
			}
			setFont(customFont);
			setForeground(colore);
		}
		
		public Font getOurFont() {
            return customFont;
        }
}
