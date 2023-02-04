package it.unipv.ingsfw.view;

import java.awt.Font;

import javax.swing.JLabel;

public class OurLabel extends JLabel {
	public OurLabel(String nome) {
		super(nome);
		setFont(new Font("Roman", Font.ROMAN_BASELINE, 25));
	}

		public OurLabel(String nome, int i) {
			super(nome, i);
			setFont(new Font("Roman", Font.ROMAN_BASELINE, 25));
		}
}
