package dev.projekt_v2.panels;

import java.awt.Color;
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
	private int questionNumber = 29;
	private int timeLeft; 	
	private final int baseTime; 							
	
	private long timer;
	
	private Thread thread;
	
	public QuizPanel(ApplicationFrame parent, int timeLeft) {
		this.parent = parent;
		setSize(parent.getSize());
		setLayout(null);
		this.timeLeft = timeLeft;
		this.baseTime = timeLeft;
	}
	
	public void create() {
		QuestionManager.createQuestions();
		
		question = QuestionManager.getRandomQuestion();
		
		font = new Font("Arial", Font.BOLD, 20);
		
		txtQuestionDesc = new JTextArea(question.getQuestion());
		txtQuestionDesc.setBounds(20, 20, 700, 100);
		txtQuestionDesc.setEditable(false); // wy��czamy mo�liwo�� edytowania tekstu
		txtQuestionDesc.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // tworzymy obramowanie o kolorze czarnym i o grubo�ci 2
		txtQuestionDesc.setLineWrap(true); // w��czamy zawijanie tekstu
		txtQuestionDesc.setWrapStyleWord(true);
		txtQuestionDesc.setFont(font);
		
		lblTimeLeft = new JLabel("Pozosta�y czas: " + timeLeft);
		lblTimeLeft.setBounds(851, 50, 160, 20);
		lblTimeLeft.setFont(transformFont(Font.PLAIN, 16));
		
		lblQuestionNumber = new JLabel("Pytanie "+ questionNumber +" z 32");
		lblQuestionNumber.setBounds(890, 20, 120, 20);
		lblQuestionNumber.setFont(transformFont(Font.PLAIN, 16));
		
		lblSelectAnswer = new JLabel("Prosz� o wybranie prawid�owej odpowiedzi:");
		lblSelectAnswer.setBounds(20, 225, 500, 64);
		lblSelectAnswer.setFont(transformFont(Font.BOLD, 18));
		
		btnCheck = new JButton("Sprawd�");
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
				
				if(answerSelected != 101){
					thread.suspend();
					System.out.println(timeLeft);
				}
				
				if(questionNumber == 32)
					btnFinish.setEnabled(true);
				
				if(answerSelected == 101)
					JOptionPane.showMessageDialog(null, "Wybierz jak�� odpowied� ...", "Informacja", JOptionPane.OK_OPTION);
				
				else if(question.isCorrectFrom(answerSelected)) {
					btnCheck.setBackground(Color.green);
					btnCheck.setText("Odpowiedz poprawna!");
					btnCheck.setEnabled(false);
					btnNextQuestion.setEnabled(true);
				} else {
					btnCheck.setBackground(Color.red);
					btnCheck.setText("Odpowied� niepoprawna!");
					btnCheck.setEnabled(false);
					btnNextQuestion.setEnabled(true);
				}
			
			}
		});
		
		btnFinish = new JButton("Zako�cz");
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
		
		btnNextQuestion = new JButton("Nast�pne");
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
					if(!btnAnswerA.isEnabled()||!btnAnswerB.isEnabled()||!btnAnswerC.isEnabled()||!btnAnswerD.isEnabled()){
						btnAnswerA.setEnabled(true);
						btnAnswerB.setEnabled(true);
						btnAnswerC.setEnabled(true);
						btnAnswerD.setEnabled(true);
					}
					
					btnCheck.setEnabled(true);
					btnCheck.setBackground(getBackground());
					btnCheck.setText("Sprawd�");
					
					question = QuestionManager.getRandomQuestion();
					questionNumber++;
					if(questionNumber > 31){
						btnNextQuestion.setVisible(false);
						btnFinish.setVisible(true);
					}
						
					update();
				} else {
					JOptionPane.showMessageDialog(null, "Wybierz jak�� odpowied� ...", "Informacja", JOptionPane.OK_OPTION);
				}
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
						lblTimeLeft.setText("Pozosta�y czas: " +timeLeft);
							
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
			}
		});
		
		thread.start();
	}
	
	public void update() {
		txtQuestionDesc.setText(question.getQuestion());
		lblQuestionNumber.setText("Pytanie "+ questionNumber +" z 32");

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
}