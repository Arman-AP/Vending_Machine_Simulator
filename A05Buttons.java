package cp213;

import java.awt.Color;

import javax.swing.JButton;

//If you need any buttons in your program then they must be the instances of this class.
//You can customize this class as per your need.
@SuppressWarnings("serial")
public class A05Buttons extends JButton {
	public A05Buttons(String title) {
		setText(title);
		setBackground(Color.white);
	}
	public A05Buttons() {
	}
}
