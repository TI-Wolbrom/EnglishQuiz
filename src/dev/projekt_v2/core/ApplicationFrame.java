package dev.projekt_v2.core;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import dev.projekt_v2.panels.MainMenuPanel;

public class ApplicationFrame extends JFrame {

	private MainMenuPanel mainMenu;
	
	public ApplicationFrame() {
		this.setTitle("Quiz");
		this.setSize(1024, 768);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}
	
	public void init() {
		mainMenu = new MainMenuPanel(this);
		mainMenu.create();
		mainMenu.setLayout(null);
		
		mainMenu.setVisible(true);
		
		this.add(mainMenu);
	}
	
	public void closeProgram() {
		this.dispose();
	}
	
}
