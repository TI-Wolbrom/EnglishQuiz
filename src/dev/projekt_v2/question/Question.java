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
	
	public void mix(int newCorrect) {
		String correct = getAnswerById(answerCorrect);
		String mixed = getAnswerById(newCorrect);
		
		setAnswerById(newCorrect, correct);
		setAnswerById(answerCorrect, mixed);
		
		setAnswerCorrect(newCorrect);
	}
	
	public void setAnswerById(int id, String answer) {
		if(id == 0)
			setAnswerA(answer);
		else if(id == 1)
			setAnswerB(answer);
		else if(id == 2)
			setAnswerC(answer);
		else
			setAnswerD(answer);
	}
	
	public String getAnswerById(int id) {
		if(id == 0)
			return answerA;
		else if(id == 1)
			return answerB;
		else if(id == 2)
			return answerC;
		else if(id == 3)
			return answerD;
		
		return null;
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
