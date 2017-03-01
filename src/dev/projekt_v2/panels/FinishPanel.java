package dev.projekt_v2.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import dev.projekt_v2.core.ApplicationFrame;

public class FinishPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private ApplicationFrame appInstance;
	private JButton btnMenu;
	
	public FinishPanel(Dimension size, ApplicationFrame app) {
		this.setSize(size);
		this.setLayout(null);
		
		this.appInstance = app;
	}
	
	public void create(){
		btnMenu = new JButton("Powrót do Menu");
		btnMenu.setBounds(800,670,200,50);
		
		btnMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Wczytujemy g³owne menu
				appInstance.init();
				
				
			}
		});
		
		this.add(btnMenu);
	}
}
