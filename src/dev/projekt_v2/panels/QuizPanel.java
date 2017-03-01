package dev.projekt_v2.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import dev.projekt_v2.core.ApplicationFrame;
import dev.projekt_v2.question.Question;
import dev.projekt_v2.question.QuestionManager;

public class QuizPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ApplicationFrame parent;
	
	private JTextArea txtQuestionDesc;
	private JLabel lblQuestionNumber;
	private JLabel lblSelectAnswer;
	private JLabel lblTimeLeft;
	
	private Font font;
	
	private JButton btnCheck;
	private JButton btnNextQuestion;
	private JButton btnFinish;
	
	private ButtonGroup btnAnswerGroup;
	
	private JToggleButton btnAnswerA;
	private JToggleButton btnAnswerB;
	private JToggleButton btnAnswerC;
	private JToggleButton btnAnswerD;
	
	private Question question;
	private int answerSelected;
	private int questionNumber = 1;
	private int timeLeft = 60; 							//	tymczasowe sta³e 60 sec
	
	private long timer;
	
	private Thread thread;
	
	public QuizPanel(Dimension size, ApplicationFrame parent) {
		this.parent = parent;
		this.setSize(size);
		this.setLayout(null);
			
		QuestionManager.createQuestions();
		
		question = QuestionManager.getRandomQuestion();
		
		thread = new Thread(new Runnable() {
			public void run() {
				timer = System.currentTimeMillis();
				while(timeLeft >= 0){
					if(System.currentTimeMillis() - timer > 1000){
						timer += 1000;
						timeLeft--;
					}
					try{
						lblTimeLeft.setText("Pozosta³y czas: " +timeLeft);
						
						if(timeLeft < 31 && !lblTimeLeft.getForeground().equals(Color.RED))
							lblTimeLeft.setForeground(Color.RED);
						else if(timeLeft > 31 &&!lblTimeLeft.getForeground().equals(Color.BLACK))
							lblTimeLeft.setForeground(Color.BLACK);
					} catch(Exception e) { }
					
					if(timeLeft < 1){
						btnAnswerA.setEnabled(false);
						btnAnswerB.setEnabled(false);
						btnAnswerC.setEnabled(false);
						btnAnswerD.setEnabled(false);
						btnCheck.setEnabled(false);
						thread.suspend();
					}
				}

			}});
		
		if(!thread.isAlive())
			thread.start();
	}
	
	public void create() {
		font = new Font("Arial", Font.BOLD, 20);
		
		txtQuestionDesc = new JTextArea(question.getQuestion());
		txtQuestionDesc.setBounds(20, 20, 700, 100);
		txtQuestionDesc.setEditable(false); // wy³¹czamy mo¿liwoœæ edytowania tekstu
		txtQuestionDesc.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // tworzymy obramowanie o kolorze czarnym i o gruboœci 2
		txtQuestionDesc.setLineWrap(true); // w³¹czamy zawijanie tekstu
		txtQuestionDesc.setWrapStyleWord(true);
		txtQuestionDesc.setFont(font);
		
		lblTimeLeft = new JLabel("Pozosta³y czas: " + timeLeft);
		lblTimeLeft.setBounds(851, 50, 160, 20);
		lblTimeLeft.setFont(transformFont(Font.PLAIN, 16));
		
		lblQuestionNumber = new JLabel("Pytanie "+ questionNumber +" z 32");
		lblQuestionNumber.setBounds(890, 20, 120, 20);
		lblQuestionNumber.setFont(transformFont(Font.PLAIN, 16));
		
		lblSelectAnswer = new JLabel("Proszê o wybranie prawid³owej odpowiedzi:");
		lblSelectAnswer.setBounds(20, 225, 500, 64);
		lblSelectAnswer.setFont(transformFont(Font.BOLD, 18));
		
		btnCheck = new JButton("SprawdŸ");
		btnCheck.setBounds(800, 300, 200, 50);
		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answerSelected=101;
				
				if(btnAnswerA.isSelected())
					answerSelected = 0;
				else if(btnAnswerB.isSelected())
					answerSelected = 1;
				else if(btnAnswerC.isSelected())
					answerSelected = 2;
				else if(btnAnswerD.isSelected())
					answerSelected = 3;
				
				if(answerSelected != 101){
					thread.suspend();
					System.out.println(timeLeft);
				}				
				
				if(answerSelected == 101)
					JOptionPane.showMessageDialog(null, "Wybierz jak¹œ odpowiedŸ ...", "Informacja", JOptionPane.OK_OPTION);
				
				else if(question.isCorrectFrom(answerSelected)) {
					btnCheck.setBackground(Color.green);
					btnCheck.setText("Odpowiedz poprawna!");
					btnCheck.setEnabled(false);
					System.out.println("Odpowiedz poprawna!");
				} else {
					btnCheck.setBackground(Color.red);
					btnCheck.setText("OdpowiedŸ niepoprawna!");
					btnCheck.setEnabled(false);
					System.out.println("Odpowiedz niepoprawna!");
				}

			}
		});
		
		btnFinish = new JButton("Zakoñcz");
		btnFinish.setBounds(800, 400, 200, 50);
		btnFinish.setVisible(false);
		btnFinish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					thread.join(1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				parent.showFinish();
			}
		});
		
		btnNextQuestion = new JButton("Nastêpne");
		btnNextQuestion.setBounds(800, 400, 200, 50);
		btnNextQuestion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timeLeft = 60;
				timer = System.currentTimeMillis();
				thread.resume();
				
				btnAnswerGroup.clearSelection();
				if(!btnAnswerA.isEnabled()||!btnAnswerB.isEnabled()||!btnAnswerC.isEnabled()||!btnAnswerD.isEnabled()){
					btnAnswerA.setEnabled(true);
					btnAnswerB.setEnabled(true);
					btnAnswerC.setEnabled(true);
					btnAnswerD.setEnabled(true);
				}
				
				btnCheck.setEnabled(true);
				btnCheck.setBackground(getBackground());
				btnCheck.setText("SprawdŸ");
				
				question = QuestionManager.getRandomQuestion();
				questionNumber++;
				if(questionNumber > 31){
				btnNextQuestion.setVisible(false);
				btnFinish.setVisible(true);
				}
					
				update();
			}
		});
		
		btnAnswerGroup = new ButtonGroup();
			
		btnAnswerA = createAnswerButton("A) " + question.getAnswerA(), 300);
		btnAnswerB = createAnswerButton("B) " + question.getAnswerB(), 400);
		btnAnswerC = createAnswerButton("C) " + question.getAnswerC(), 500);
		btnAnswerD = createAnswerButton("D) " + question.getAnswerD(), 600);
		
		this.add(txtQuestionDesc);
		this.add(lblQuestionNumber);
		this.add(lblSelectAnswer);
		this.add(lblTimeLeft);
		this.add(btnFinish);
		this.add(btnCheck);
		this.add(btnNextQuestion);
	}
	
	public void update() {
		txtQuestionDesc.setText(question.getQuestion());
		lblQuestionNumber.setText("Pytanie "+ questionNumber +" z 32");

		btnAnswerA.setText("A) " + question.getAnswerA());
		btnAnswerB.setText("B) " + question.getAnswerB());
		btnAnswerC.setText("C) " + question.getAnswerC());
		btnAnswerD.setText("D) " + question.getAnswerD());
	}
	
	private Font transformFont(int style, int size) {
		return new Font(font.getFontName(), style, size);
	}
	
	public JToggleButton createAnswerButton(String str, int y) {
		JToggleButton btn = new JToggleButton(str);
		btn.setFont(transformFont(Font.PLAIN, 14));
		btn.setBounds(20, y, 385, 50);
		btn.setHorizontalAlignment(SwingConstants.LEFT);
				
		btnAnswerGroup.add(btn);
		
		this.add(btn);
		
		return btn;
	}
	
}