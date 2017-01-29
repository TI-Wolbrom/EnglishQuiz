package dev.projekt_v2.panels;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

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
	
	public QuizPanel(Dimension size) {
		this.setSize(size);
		this.setLayout(null);
	}
	
	public void create() {
		font = new Font("Arial", Font.BOLD, 20);
		
		lblQuestionDesc = new JLabel("Je¿eli chcielibyœmy zapisaæ liczbê 99 po angielsku otrzymalibyœmy ?");
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
		
		btnNextQuestion = new JButton("Nastêpne");
		btnNextQuestion.setBounds(800, 400, 150, 50);
		
		btnAnswerGroup = new ButtonGroup();
		
		btnAnswerA = createAnswerButton("A) nine ninety", 300);
		btnAnswerB = createAnswerButton("B) ten thousand", 400);
		btnAnswerC = createAnswerButton("C) ninety nine", 500);
		btnAnswerD = createAnswerButton("D) fifteen five", 600);
	
		this.add(lblQuestionDesc);
		this.add(lblQuestionNumber);
		this.add(lblSelectAnswer);
		
		this.add(btnCheck);
		this.add(btnNextQuestion);
	}
	
	private Font transformFont(int style, int size) {
		return new Font(font.getFontName(), style, size);
	}
	
	public JToggleButton createAnswerButton(String str, int y) {
		JToggleButton btn = new JToggleButton(str);
		btn.setFont(transformFont(Font.PLAIN, 14));
		btn.setBounds(20, y, 300, 50);
		btn.setHorizontalAlignment(SwingConstants.LEFT);
				
		btnAnswerGroup.add(btn);
		
		this.add(btn);
		
		return btn;
	}
	
}
