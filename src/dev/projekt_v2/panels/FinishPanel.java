package dev.projekt_v2.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import dev.projekt_v2.core.ApplicationFrame;

public class FinishPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private ApplicationFrame appInstance;
	
	private JButton btnMenu;
	private JButton btnExit;
	
	public FinishPanel(ApplicationFrame app) {
		this.setSize(app.getSize());
		this.setLayout(null);
		
		this.appInstance = app;
	}
	
	public void create() {
		btnMenu = new JButton("Powrót do menu");
		btnMenu.setBounds(800, 610, 200, 50);
		
		btnMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Wczytujemy g³owne menu
				appInstance.init();
			}
		});
		
		btnExit = new JButton("WyjdŸ z programu");
		btnExit.setBounds(800, 670, 200, 50);

		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Zamykamy program
				appInstance.closeProgram();
			}
		});
		
		this.add(btnMenu);
		this.add(btnExit);
	}
}
