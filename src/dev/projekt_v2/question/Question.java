package dev.projekt_v2.question;

public class Question {

	private String question;
	
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	
	private int answerCorrect;

	public Question(String question, String a, String b, String c, String d, int correct) {
		setQuestion(question);
		
		setAnswerA(a);
		setAnswerB(b);
		setAnswerC(c);
		setAnswerD(d);
		
		setAnswerCorrect(correct);
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswerA() {
		return answerA;
	}

	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}

	public String getAnswerB() {
		return answerB;
	}

	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}

	public String getAnswerC() {
		return answerC;
	}

	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}

	public String getAnswerD() {
		return answerD;
	}

	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}

	public int getAnswerCorrect() {
		return answerCorrect;
	}

	public void setAnswerCorrect(int answerCorrect) {
		this.answerCorrect = answerCorrect;
	}
	
	public boolean isCorrectFrom(int i) {
		return i == answerCorrect;
	}
}
