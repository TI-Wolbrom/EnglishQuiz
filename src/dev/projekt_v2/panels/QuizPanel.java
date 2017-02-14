package dev.projekt_v2.panels;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import dev.projekt_v2.question.Question;
import dev.projekt_v2.question.QuestionManager;

public class QuizPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel lblQuestionDesc;
	private JLabel lblQuestionNumber;
	private JLabel lblSelectAnswer;
	
	private Font font;
	
	private JButton btnCheck;
	private JButton btnNextQuestion;
	
	private ButtonGroup btnAnswerGroup;
	
	private JToggleButton btnAnswerA;
	private JToggleButton btnAnswerB;
	private JToggleButton btnAnswerC;
	private JToggleButton btnAnswerD;
	
	private Question question;
	private int answerSelected;
	
	public QuizPanel(Dimension size) {
		this.setSize(size);
		this.setLayout(null);
		
		QuestionManager.createQuestions();
		
		question = QuestionManager.getRandomQuestion();
	}
	
	public void create() {
		font = new Font("Arial", Font.BOLD, 20);
		
		lblQuestionDesc = new JLabel(question.getQuestion());
		lblQuestionDesc.setBounds(20, 20, 700, 64);
		lblQuestionDesc.setFont(font);
		
		lblQuestionNumber = new JLabel("Pytanie 1 z 32");
		lblQuestionNumber.setBounds(890, 20, 120, 20);
		lblQuestionNumber.setFont(transformFont(Font.PLAIN, 16));
		
		lblSelectAnswer = new JLabel("Proszê o wybranie prawid³owej odpowiedzi:");
		lblSelectAnswer.setBounds(20, 225, 500, 64);
		lblSelectAnswer.setFont(transformFont(Font.BOLD, 18));
		
		btnCheck = new JButton("SprawdŸ");
		btnCheck.setBounds(800, 300, 150, 50);
		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btnAnswerA.isSelected())
					answerSelected = 0;
				else if(btnAnswerB.isSelected())
					answerSelected = 1;
				else if(btnAnswerC.isSelected())
					answerSelected = 2;
				else if(btnAnswerD.isSelected())
					answerSelected = 3;
				else JOptionPane.showMessageDialog(null, "Wybierz jak¹œ odpowiedŸ ...", "Informacja", JOptionPane.OK_OPTION);
				
				if(question.isCorrectFrom(answerSelected)) {
					System.out.println("Odpowiedz poprawna!");
				} else {
					System.out.println("Odpowiedz niepoprawna!");
				}
			}
		});
		
		btnNextQuestion = new JButton("Nastêpne");
		btnNextQuestion.setBounds(800, 400, 150, 50);
		btnNextQuestion.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAnswerGroup.clearSelection();
				
				question = QuestionManager.getRandomQuestion();
				
				update();
			}
		});
		
		btnAnswerGroup = new ButtonGroup();
		
		btnAnswerA = createAnswerButton("A) " + question.getAnswerA(), 300);
		btnAnswerB = createAnswerButton("B) " + question.getAnswerB(), 400);
		btnAnswerC = createAnswerButton("C) " + question.getAnswerC(), 500);
		btnAnswerD = createAnswerButton("D) " + question.getAnswerD(), 600);
	
		this.add(lblQuestionDesc);
		this.add(lblQuestionNumber);
		this.add(lblSelectAnswer);
		
		this.add(btnCheck);
		this.add(btnNextQuestion);
	}
	
	public void update() {
		lblQuestionDesc.setText(question.getQuestion());
		
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
