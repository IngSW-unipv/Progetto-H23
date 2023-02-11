package it.unipv.ingsfw.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.Border;

public class OurButton extends JButton {
	public OurButton(String nome) {
		super(nome);
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setFont(new Font("Roman", Font.ROMAN_BASELINE, 25));
		setOpaque(false);
		
		setContentAreaFilled(false);
		
		setBorder(new RoundedBorder(10));
	}
}
