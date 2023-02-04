package it.unipv.ingsfw.view;

import java.awt.Font;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class OurSpinner extends JSpinner {
	public OurSpinner() {
		super();
		setFont(new Font("Roman", Font.ROMAN_BASELINE, 25));
	}
	public OurSpinner(SpinnerNumberModel s) {
		super(s);
		setFont(new Font("Roman", Font.ROMAN_BASELINE, 25));
	}
	
}
