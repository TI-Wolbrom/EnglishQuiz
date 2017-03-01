package dev.projekt_v2.core;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import dev.projekt_v2.panels.FinishPanel;
import dev.projekt_v2.panels.MainMenuPanel;
import dev.projekt_v2.panels.QuizPanel;

public class ApplicationFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private MainMenuPanel mainMenu;
	private QuizPanel quizPanel;
	private FinishPanel finishPanel;
	
	public ApplicationFrame() {
		this.setTitle("Quiz");
		this.setSize(1024, 768);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		
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
	
	public void showQuiz() {
		if(quizPanel == null) {
			quizPanel = new QuizPanel(getSize(),this);
			quizPanel.create();
			
			quizPanel.setVisible(true);	
			mainMenu.setVisible(false);
			
			this.add(quizPanel);
			this.remove(mainMenu);
		}
	}
	
	public void showFinish() {
		if(finishPanel == null) {
			finishPanel = new FinishPanel(getSize());
			finishPanel.create();
			
			finishPanel.setVisible(true);	
			quizPanel.setVisible(false);
			
			this.add(finishPanel);
			this.remove(quizPanel);
		}
	}
	
	public void closeProgram() {
		this.dispose();
	}
	
}
