package it.unipv.ingsfw.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class OurButton extends JButton {
	public OurButton(String nome) {
		super(nome);
		setBackground(Color.WHITE);
		setForeground(Color.RED);
		setFont(new Font("Roman", Font.ROMAN_BASELINE, 25));
		//setContentAreaFilled(false);
		
	}
}
