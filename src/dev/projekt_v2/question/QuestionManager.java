package dev.projekt_v2.question;

import java.util.ArrayList;
import java.util.Random;

public final class QuestionManager {

	private static ArrayList<Question> questions = new ArrayList<>();

	public static void createQuestions() {	
		questions.add(new Question("Je�eli chcieliby�my zapisa� liczb� 99 po angielsku otrzymaliby�my ?", "nine ninety", "ten thousand", "ninety nine", "fifteen five", 2));
		questions.add(new Question("W j�zyku angielskim s�owo 'car' oznacza ?", "Samolot", "Samoch�d", "Statek", "Motor", 1));
		questions.add(new Question("Jak nazywa si� w j�zyku angielskim telefon marki jab�ko?", "Apfel", "Melon", "Pinneapple", "Apple", 3));
		questions.add(new Question("Jak po angielsku pisze si� s�owo policjanci?","policeman","policemen","policemans","policemens",1));
		questions.add(new Question("Co oznacza s�owo cat?","Szatan","kat","jaszczurka","kot",3));
		questions.add(new Question("Co po polsku oznacza s�owo chairman?","cz�owiek krzes�o","szef","przewodnicz�cy","pracodawca",2));
		questions.add(new Question("Zdanie: To drink alcohol you must be atleast 18 years old. oznacza?","By pic alkochol musisz mie� minimum 18 lat","By pic alkochol musisz mie� ponad 18 lat","By pic alkochol mo�esz mie� minimum 18 lat","By pic alkochol nie musisz mie� minimum 18 lat",0));
		questions.add(new Question("Jak odczytujemy dat� 1922?","ninety twenty two","nineteen twenteen","nineteen twelwe","nineteen twelve",3));
		questions.add(new Question("Jak odczytujemy dat� 979?","ninety seven and nine","ninety hundred seventy nine","nine hundred seventy nine","nine seventy nine",2));
		questions.add(new Question("W j�zyku angielskim 5=2+3 mo�emy zapisa� w postaci?", "five equals two plus three", "five equinox two plus three", "five equals two equals plus three", "five equals three", 0));
		questions.add(new Question("W j�zyku angielskim s�owo \"Sound Card\" oznacza?", "Karta graficzna", "Karta d�wi�kowa", "Karta rozszerze�", "Karta USB", 1));
//		questions.add(new Question("","","","","",0));
//		questions.add(new Question("","","","","",0));
//		questions.add(new Question("","","","","",0));
//		questions.add(new Question("","","","","",0));
//		questions.add(new Question("","","","","",0));
//		questions.add(new Question("","","","","",0));
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
