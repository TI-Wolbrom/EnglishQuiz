package dev.projekt_v2.panels;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dev.projekt_v2.core.ApplicationFrame;
import dev.projekt_v2.core.ApplicationOptions;
import dev.projekt_v2.gfx.ImageStorage;

public class DifficultyMenuPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private ApplicationFrame parent;
	
	private int timeForQuiz;
	private int difficultyLevel;
	
	private JLabel lblSelectDiff;
	
	private JButton btnEasy;
	private JButton btnMedium;
	private JButton btnHard;
	private JButton btnExit;
	
	public DifficultyMenuPanel(ApplicationFrame parent) {
		this.setSize(parent.getSize());
		this.setLayout(null);
		
		this.parent = parent;
	}
	
	public void create() {
		
		lblSelectDiff = new JLabel("Prosimy o wybranie poziomu trudnoœci:");
		lblSelectDiff.setBounds(350, 130, 400, 50);
		lblSelectDiff.setFont(new Font(lblSelectDiff.getFont().getFontName(), Font.BOLD, 16));
		
		btnEasy = new JButton("£atwy");
		btnEasy.setBounds(400, 210, 200, 50);
		
		btnEasy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Wczytujemy quiz o trudnoœci easy
				setTimeForQuiz(60);
				setDifficultyLevel(1);
				parent.showQuiz();
			}
		});
		
		btnMedium = new JButton("Œredni");
		btnMedium.setBounds(400, 310, 200, 50);
		
		btnMedium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Wczytujemy quiz o trudnoœci medium
				setTimeForQuiz(30);
				setDifficultyLevel(3);
				parent.showQuiz();
			}
		});
		
		btnHard = new JButton("Trudny");
		btnHard.setBounds(400, 410, 200, 50);
		
		btnHard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Wczytujemy quiz o trudnoœci hard
				setTimeForQuiz(15);
				setDifficultyLevel(10);
				parent.showQuiz();
			}
		});
		
		btnExit = new JButton("Wróæ do menu");
		btnExit.setBounds(800, 670, 200, 50);

		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Wczytujemy g³ówne menu
				parent.init();
			}
		});

		this.add(lblSelectDiff);
		
		this.add(btnEasy);
		this.add(btnMedium);
		this.add(btnHard);
		this.add(btnExit);
	}

	public int getTimeForQuiz() {
		return timeForQuiz;
	}

	public void setTimeForQuiz(int timeForQuiz) {
		this.timeForQuiz = timeForQuiz;
	}

	public int getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(ImageStorage.getImage(ApplicationOptions.IN_USE_LOOK_AND_FEEL), 0, 0, null);
	}
}
