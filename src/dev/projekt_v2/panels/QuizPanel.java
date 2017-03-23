package dev.projekt_v2.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
import dev.projekt_v2.core.ApplicationOptions;
import dev.projekt_v2.gfx.ImageStorage;
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

	private int correctAnswers;
	private int wrongAnswers;
	private int score;
	private int comboPoints = 1;
	private int difficultyLevel; // 1 - easy;  3 - medium;  10 - hard;
	
	private Question question;
	private int answerSelected;
	private int correctAnswer;
	private int questionNumber = 1;
	private int timeLeft; 	
	private final int baseTime; 							
	
	private long timer;
	
	private Thread thread;
	
	public QuizPanel(ApplicationFrame parent, int timeLeft, int difficultyLevel) {
		this.parent = parent;
		setSize(parent.getSize());
		setLayout(null);
		this.timeLeft = timeLeft;
		this.baseTime = timeLeft;
		this.difficultyLevel = difficultyLevel;
	}
	
	public void create() {
		QuestionManager.selectRandomQuestions(32);	
		
		question = QuestionManager.selectQuestion(questionNumber);
		
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
		lblTimeLeft.setForeground(Color.white);
		
		lblQuestionNumber = new JLabel("Pytanie "+ questionNumber +" z 32");
		lblQuestionNumber.setBounds(890, 20, 120, 20);
		lblQuestionNumber.setFont(transformFont(Font.PLAIN, 16));
		lblQuestionNumber.setForeground(Color.GREEN);
		
		lblSelectAnswer = new JLabel("Proszê o wybranie prawid³owej odpowiedzi:");
		lblSelectAnswer.setBounds(20, 225, 500, 64);
		lblSelectAnswer.setFont(transformFont(Font.BOLD, 18));
		lblSelectAnswer.setForeground(Color.white);
		
		btnCheck = new JButton("SprawdŸ");
		btnCheck.setBounds(800, 300, 200, 50);
		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerSelected = 101;
				
				if(btnAnswerA.isSelected())
					answerSelected = 0;
				else if(btnAnswerB.isSelected())
					answerSelected = 1;
				else if(btnAnswerC.isSelected())
					answerSelected = 2;
				else if(btnAnswerD.isSelected())
					answerSelected = 3;
				
				if(answerSelected != 101)
					thread.suspend();
				
				if(questionNumber == 32)
					btnFinish.setEnabled(true);
				
				if(answerSelected == 101)
					JOptionPane.showMessageDialog(null, "Wybierz jak¹œ odpowiedŸ ...", "Informacja", JOptionPane.OK_OPTION);
				
				else if(question.isCorrectFrom(answerSelected)) {
					setAnswersEnabled(false);
					correctAnswers++;
					score += timeLeft * difficultyLevel * comboPoints;
					if(comboPoints < 5)
						comboPoints++;
					btnCheck.setBackground(Color.green);
					btnCheck.setText("Odpowiedz poprawna!");
					btnCheck.setEnabled(false);
					btnNextQuestion.setEnabled(true);
				} else {
					setAnswersEnabled(false);
					wrongAnswers++;
					comboPoints = 1;
					btnCheck.setBackground(Color.red);
					btnCheck.setText("OdpowiedŸ niepoprawna!");
					btnCheck.setEnabled(false);
					btnNextQuestion.setEnabled(true);
				}
				
				if(answerSelected != 101)
					colorAnswers();
			}
		});
		
		btnFinish = new JButton("Zakoñcz");
		btnFinish.setBounds(800, 400, 200, 50);
		btnFinish.setVisible(false);
		btnFinish.setEnabled(false);
		btnFinish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					thread.join(1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				parent.showFinish();
			}
		});
		
		btnNextQuestion = new JButton("Nastêpne");
		btnNextQuestion.setBounds(800, 400, 200, 50);
		btnNextQuestion.setEnabled(false);
		btnNextQuestion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(answerSelected <= 3) {	
					timeLeft = baseTime;
					timer = System.currentTimeMillis();
					thread.resume();
					
					btnAnswerGroup.clearSelection();
					if(!btnAnswerA.isEnabled()||!btnAnswerB.isEnabled()||!btnAnswerC.isEnabled()||!btnAnswerD.isEnabled())
						setAnswersEnabled(true);
					
					btnAnswerA.setBackground(null);
					btnAnswerB.setBackground(null);
					btnAnswerC.setBackground(null);
					btnAnswerD.setBackground(null);
					
					btnCheck.setEnabled(true);
					btnCheck.setBackground(getBackground());
					btnCheck.setText("SprawdŸ");
					
					questionNumber++;
					question = QuestionManager.selectQuestion(questionNumber);
					if(questionNumber > 31){
						btnNextQuestion.setVisible(false);
						btnFinish.setVisible(true);
					}
						
					update();
				} else 
					JOptionPane.showMessageDialog(null, "Wybierz jak¹œ odpowiedŸ ...", "Informacja", JOptionPane.OK_OPTION);
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
	
	public void createThreads() {
		thread = new Thread(new Runnable() {
			public void run() {
				timer = System.currentTimeMillis();
				while(timeLeft >= 0) {
					if(System.currentTimeMillis() - timer > 1000){
						timer += 1000;
						timeLeft--;
					}
					try {
						lblTimeLeft.setText("Pozosta³y czas: " +timeLeft);
							
						if(timeLeft < 31 && !lblTimeLeft.getForeground().equals(Color.RED))
							lblTimeLeft.setForeground(Color.RED);
						else if(timeLeft > 31 &&!lblTimeLeft.getForeground().equals(Color.BLACK))
							lblTimeLeft.setForeground(Color.white);
					} catch(Exception e) { }
						
					if(timeLeft < 1){
						setAnswersEnabled(false);
						colorAnswers();
						btnAnswerGroup.clearSelection();
						btnCheck.setEnabled(false);
						btnNextQuestion.setEnabled(true);
						btnFinish.setEnabled(true);
						thread.suspend();
					}
				}
			}
		});
		
		thread.start();
	}
	
	public void update() {
		txtQuestionDesc.setText(question.getQuestion());
		lblQuestionNumber.setText("Pytanie "+ questionNumber +" z 32");

		// Jest to wymagane na nimbusie
		btnCheck.setOpaque(false);
		btnAnswerA.setOpaque(false);
		btnAnswerB.setOpaque(false);
		btnAnswerC.setOpaque(false);
		btnAnswerD.setOpaque(false);
		
		btnAnswerA.setText("A) " + question.getAnswerA());
		btnAnswerB.setText("B) " + question.getAnswerB());
		btnAnswerC.setText("C) " + question.getAnswerC());
		btnAnswerD.setText("D) " + question.getAnswerD());
		
		btnNextQuestion.setEnabled(false);
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

	public int getScore() {
		return score;
	}
	
	private void setAnswersEnabled(boolean setEnabled){
		btnAnswerA.setEnabled(setEnabled);
		btnAnswerB.setEnabled(setEnabled);
		btnAnswerC.setEnabled(setEnabled);
		btnAnswerD.setEnabled(setEnabled);
	}
	
	private void colorAnswers(){
		correctAnswer = question.getAnswerCorrect();
		btnAnswerGroup.clearSelection();
		
		// Jest to wymagane na nimbusie
		btnCheck.setOpaque(true);
		btnAnswerA.setOpaque(true);
		btnAnswerB.setOpaque(true);
		btnAnswerC.setOpaque(true);
		btnAnswerD.setOpaque(true);
		
		if(correctAnswer == 0){
			btnAnswerA.setBackground(Color.green);
			btnAnswerB.setBackground(Color.red);
			btnAnswerC.setBackground(Color.red);
			btnAnswerD.setBackground(Color.red);
		}else if(correctAnswer == 1){
			btnAnswerA.setBackground(Color.red);
			btnAnswerB.setBackground(Color.green);
			btnAnswerC.setBackground(Color.red);
			btnAnswerD.setBackground(Color.red);
		}else if(correctAnswer == 2){
			btnAnswerA.setBackground(Color.red);
			btnAnswerB.setBackground(Color.red);
			btnAnswerC.setBackground(Color.green);
			btnAnswerD.setBackground(Color.red);
		}else if(correctAnswer == 3){
			btnAnswerA.setBackground(Color.red);
			btnAnswerB.setBackground(Color.red);
			btnAnswerC.setBackground(Color.red);
			btnAnswerD.setBackground(Color.green);
		}
	}

	public int getCorrectAnswers() {
		return correctAnswers;
	}

	public int getWrongAnswers() {
		return wrongAnswers;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(ImageStorage.getImage(ApplicationOptions.IN_USE_LOOK_AND_FEEL), 0, 0, null);
	}
	
}