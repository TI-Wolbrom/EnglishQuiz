package dev.projekt_v2.panels;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FinishPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private JButton btnMenu;

	public FinishPanel(Dimension size){
		this.setSize(size);
		this.setLayout(null);
		
	}
	
	public void create(){
		btnMenu = new JButton("Menu");
		btnMenu.setBounds(800,600,100,100);
		
		this.add(btnMenu);
	}
	
	public JButton createButton(String str, int y) {
		JButton btn = new JButton(str);
		btn.setBounds(64, y, 200, 50);
		
		this.add(btn);
		
		return btn;
	}
	
}
