package dev.projekt_v2.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import dev.projekt_v2.core.ApplicationFrame;
import dev.projekt_v2.core.ApplicationOptions;
import dev.projekt_v2.gfx.ImageStorage;

public class FinishPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private ApplicationFrame appInstance;
	
	private JButton btnMenu;
	private JButton btnExit;
	
	private int correctAnswers;
	private int wrongAnswers;
	private int score;
	private float percentage;
	
	private JTextArea txtAreaSummary;
	
	public FinishPanel(ApplicationFrame app, int score, int correctAnswers, int wrongAnswers) {
		this.setSize(app.getSize());
		this.setLayout(null);
		
		this.score = score;
		this.appInstance = app;
		this.correctAnswers = correctAnswers;
		this.wrongAnswers = wrongAnswers;
		percentage = (correctAnswers*100)/32;
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
		
		txtAreaSummary = new JTextArea();
		txtAreaSummary.setVisible(false);
		txtAreaSummary.setTabSize(2);
		txtAreaSummary.setLineWrap(true);
		txtAreaSummary.setText("\tNiezale¿nie od wyników gratulujemy ukoñczenia quizu! Ale wracaj¹c do wyników, poni¿ej znajdziesz drobne podsumowanie:"
				+ "\n\t"
				+ "\n\t• Poprawne odpowiedzi: " + correctAnswers
				+ "\n\t• B³êdne odpowiedzi: " + wrongAnswers
				+ "\n\t"
				+ "\n\t"
				+ "\n\t"
				+ "\n\t Procentowy wynik: " + percentage + " %"
				+ "\n\t"
				+ "\n\t Zdobyte punkty: " + score
				);
		txtAreaSummary.setBounds(70, 100, 600, 500);
		txtAreaSummary.setEditable(false);
		
		txtAreaSummary.setFont(new Font(Font.SERIF, Font.BOLD | Font.ITALIC, 18));
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtAreaSummary.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		txtAreaSummary.setVisible(true);
		
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
		this.add(txtAreaSummary);
		this.add(btnExit);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(ImageStorage.getImage(ApplicationOptions.IN_USE_LOOK_AND_FEEL), 0, 0, null);
	}
}
