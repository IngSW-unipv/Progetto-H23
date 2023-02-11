package it.unipv.ingsfw.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class OurLabel extends JLabel {
	public OurLabel(String nome) {
		super(nome);
		setFont(new Font("Roman", Font.ROMAN_BASELINE, 25));
		setForeground(Color.WHITE);
	}

		public OurLabel(String nome, int i) {
			super(nome, i);
			setFont(new Font("Roman", Font.ROMAN_BASELINE, 25));
			setForeground(Color.WHITE);
		}
}
