package dev.projekt_v2.core;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import dev.projekt_v2.panels.DifficultyMenuPanel;
import dev.projekt_v2.panels.FinishPanel;
import dev.projekt_v2.panels.MainMenuPanel;
import dev.projekt_v2.panels.QuizPanel;

public class ApplicationFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private MainMenuPanel mainMenu;
	private QuizPanel quizPanel;
	private FinishPanel finishPanel;
	private DifficultyMenuPanel difficultyMenuPanel;
	
	public ApplicationFrame() {
		this.setTitle("Quiz  @  2TI ZSWolbrom");
		this.setSize(1024, 768);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
	}
	
	public void init() {
		mainMenu = new MainMenuPanel(this);
		mainMenu.create();
		mainMenu.setLayout(null);
		
		mainMenu.setVisible(true);
		
		if(finishPanel != null) {
			finishPanel.setVisible(false);
			this.remove(finishPanel);
			
			finishPanel = null;
		}else if(difficultyMenuPanel != null){
			difficultyMenuPanel.setVisible(false);
			this.remove(difficultyMenuPanel);
			
			difficultyMenuPanel = null;
		}
		
		this.add(mainMenu);
	}
	
	public void showDifficultyMenu() {
		if(difficultyMenuPanel == null) {
			difficultyMenuPanel = new DifficultyMenuPanel(this);
			difficultyMenuPanel.create();
			
			difficultyMenuPanel.setVisible(true);	
			mainMenu.setVisible(false);
			
			this.add(difficultyMenuPanel);
			this.remove(mainMenu);
			
			mainMenu = null;
		}
	}
	
	public void showQuiz() {
		if(quizPanel == null) {
			quizPanel = new QuizPanel(this, difficultyMenuPanel.getTimeForQuiz(), difficultyMenuPanel.getDifficultyLevel());
			quizPanel.create();
			quizPanel.createThreads();
			
			quizPanel.setVisible(true);	
			difficultyMenuPanel.setVisible(false);
			
			this.add(quizPanel);
			this.remove(difficultyMenuPanel);
			
			difficultyMenuPanel = null;
		}
	}
	
	public void showFinish() {
		if(finishPanel == null) {
			finishPanel = new FinishPanel(this, quizPanel.getScore(), quizPanel.getCorrectAnswers(), quizPanel.getWrongAnswers());
			finishPanel.create();
			
			finishPanel.setVisible(true);	
			quizPanel.setVisible(false);
			
			this.add(finishPanel);
			this.remove(quizPanel);
			
			quizPanel = null;
		}
	}
	
	public void closeProgram() {
		this.dispose();
		
		// Hardkorowe zamykanie procesu
		// Mamy pewnoœæ, ¿e zadne watki nie prze¿yj¹ po wywo³aniu tej metody
		System.exit(0);
	}
	
}
