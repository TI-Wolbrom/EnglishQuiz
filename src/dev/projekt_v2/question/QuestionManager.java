package dev.projekt_v2.question;

import java.util.ArrayList;
import java.util.Random;

public final class QuestionManager {

	private static ArrayList<Question> questions = new ArrayList<>();

	public static void createQuestions() {	
		// Je�eli w pytaniu chcemy przej�� do nast�pnej linii u�ywamy "\n"
		
		questions.add(new Question("Je�eli chcieliby�my zapisa� liczb� 99 po angielsku otrzymaliby�my ?", "nine ninety", "ten thousand", "ninety nine", "fifteen five", 2));
		questions.add(new Question("W j�zyku angielskim s�owo 'car' oznacza ?", "Samolot", "Samoch�d", "Statek", "Motor", 1));
		questions.add(new Question("Jak nazywa si� w j�zyku angielskim telefon marki jab�ko?", "Apfel", "Melon", "Pinneapple", "Apple", 3));
		questions.add(new Question("Jak po angielsku pisze si� s�owo policjanci?","policeman","policemen","policemans","policemens",1));
		questions.add(new Question("Co oznacza s�owo cat?","Szatan","kat","jaszczurka","kot",3));
		questions.add(new Question("Co po polsku oznacza s�owo chairman?","cz�owiek krzes�o","szef","przewodnicz�cy","pracodawca",2));
		questions.add(new Question("Zdanie: To drink alcohol you must be atleast 18 years old. oznacza?","By pic alkochol musisz mie� minimum 18 lat","By pic alkochol musisz mie� ponad 18 lat","By pic alkochol mo�esz mie� minimum 18 lat","By pic alkochol nie musisz mie� minimum 18 lat",0));
		questions.add(new Question("Jak odczytujemy dat� 1912?","ninety twenty two","nineteen twenteen","nineteen tvelwe","nineteen twelve",3));
		questions.add(new Question("Jak odczytujemy dat� 979?","ninety seven and nine","ninety hundred seventy nine","nine hundred seventy nine","nine seventy nine",2));
		questions.add(new Question("W j�zyku angielskim 5=2+3 mo�emy zapisa� w postaci?", "five equals two plus three", "five equinox two plus three", "five equals two equals plus three", "five equals three", 0));
		questions.add(new Question("W j�zyku angielskim s�owo \"Sound Card\" oznacza?", "Karta graficzna", "Karta d�wi�kowa", "Karta rozszerze�", "Karta USB", 1));
		questions.add(new Question("Wynik dzia�ania: four + two - one, jest r�wny?","3","4","5","6",2));
		questions.add(new Question("Wyra�enie: Money on the wallet, oznacza?","Pieni�dze na portfelu","Pieni�dze w portfelu","Pieni�dze pod portfelem","Pieni�dze przed portfelem",0));
		questions.add(new Question("S�owo if oznacza?","dlaczego","kiedy","je�eli","albo",2));
		questions.add(new Question("Je�eli p�jdziemy do zoo szukaj�c s�oni, powinni�my szuka� tabliczki z napisem:","elephants","tigers","snakes","big animal",0));
		questions.add(new Question("Kt�ry spo�r�d wymienionych przedmiot�w nie pasuje w kuchni?","knife","spoon","fork","saw",3));
		questions.add(new Question("Czego u�ywamy do smarowania chleba mas�em?","hand","stick","knife","rock",2));
		questions.add(new Question("Jak m�wimy na banana w j�zyku angielskim?","banana","banaana","bannana","baanan",0));
		questions.add(new Question("Jak zapytamy o drog� na poczt�?","How can i go to the post house?","How can i go to the post hause?","How can i look for post office?","How can i go to the post office?",3));
		questions.add(new Question("Jak zapytamy kogo� o jego wiek?","How old is you?","How much old are you","How old are you?","How old am I?",2));
		questions.add(new Question("Jak powiemy komu�, �e kochamy czekolad�?","I love chocolate","I love chocolade","I hate chocolade","chocolade is my love",0));
		questions.add(new Question("S�owo \"Szef Kuchni\" w j�zyku angielskim ma posta�:", "Thief", "Thef", "Chief", "Chef", 3));
		questions.add(new Question("Czas Present Simple po polsku oznacza:", "Czas przysz�y prosty", "Czas przesz�y prosty", "Czas tera�niejszy prosty", "Czas tera�niejszy", 2));
		questions.add(new Question("Holandia w j�zyku angielskim ma posta�: ", "Netherlands, Holand", "Netherland, Holland", "Netherlands, Holland", "Netherlands, Herland", 2));
		questions.add(new Question("S�owo \"grumble\" w j�zyku angielskim oznacza?", "narzeka�, burcze� (w brzuchu)", "garb", "niezliczony", "g�szcz, zaro�la", 0));
		questions.add(new Question("S�owo \"discernible\" w j�zyku angielskim oznacza?", "zauwa�alny, pragn��", "zauwa�alny", "pragn��", "okalecza�", 1));
		questions.add(new Question("S�owo \"tradermark\" w j�zyku angielskim oznacza?", "znak prosty", "znak zodiaku", "znak towarowy", "znak wodny", 2));
		questions.add(new Question("Wybierz prawid�ow� odpowied�:\n\nWould you ... for a drink?", "try", "like", "care", "check", 2));
		questions.add(new Question("Wybierz prawid�ow� odpowied�:\n\nCould someone give me ... with the washing up?", "an aid", "a help", "a tip", "a hand", 3));
		
//		questions.add(new Question("","","","","",0));
//		questions.add(new Question("","","","","",0));
//		questions.add(new Question("","","","","",0));
	}
	
	public static Question getRandomQuestion() {
		Question q = questions.get(new Random().nextInt(questions.size()));
		
		q.mix(new Random().nextInt(4));
		
		return q;
	}
	
	public static void clearQuestions() {
		questions.clear();
	}
	
}
