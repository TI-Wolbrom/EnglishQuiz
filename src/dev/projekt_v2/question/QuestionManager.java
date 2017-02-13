package dev.projekt_v2.question;

import java.util.ArrayList;
import java.util.Random;

public final class QuestionManager {

	private static ArrayList<Question> questions = new ArrayList<>();

	public static void createQuestions() {	
		questions.add(new Question("Je¿eli chcielibyœmy zapisaæ liczbê 99 po angielsku otrzymalibyœmy ?", "nine ninety", "ten thousand", "ninety nine", "fifteen five", 2));
		questions.add(new Question("W jêzyku angielskim s³owo 'car' oznacza ?", "Samolot", "Samochód", "Statek", "Motor", 1));
		questions.add(new Question("Jak nazywa siê w jêzyku angielskim telefon marki jab³ko?", "Apfel", "Melon", "Pinneapple", "Apple", 3));
	}
	
	/*private static String randomString(int len) {
		String chars = "qwertyuiopasdfghjklzxcvbnm";
		char[] chars_ = chars.toCharArray();
		
		String str = new String();
		
		for(int i = 0; i < len; ++i)
			str += chars_[new Random().nextInt(chars.length())];
		
		return str;
	} */
	
	public static Question getRandomQuestion() {
		return questions.get(new Random().nextInt(questions.size()));
	}
	
	public static void clearQuestions() {
		questions.clear();
	}
	
	public static ArrayList<Question> getQuestions() {
		return questions;
	}

	public static void setQuestions(ArrayList<Question> questions) {
		QuestionManager.questions = questions;
	}
}
