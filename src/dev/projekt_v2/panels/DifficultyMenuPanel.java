package dev.projekt_v2.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import dev.projekt_v2.core.ApplicationFrame;

public class DifficultyMenuPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private ApplicationFrame parent;
	
	private int timeForQuiz;

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
		btnEasy = new JButton("£atwy");
		btnEasy.setBounds(400, 210, 200, 50);
		
		btnEasy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Wczytujemy quiz o trudnoœci easy
				setTimeForQuiz(60);
				parent.showQuiz();
			}
		});
		
		btnMedium = new JButton("œredni");
		btnMedium.setBounds(400, 310, 200, 50);
		
		btnMedium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Wczytujemy quiz o trudnoœci medium
				setTimeForQuiz(30);
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
	
	
}
