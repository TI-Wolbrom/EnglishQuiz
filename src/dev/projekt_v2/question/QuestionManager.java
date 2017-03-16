package dev.projekt_v2.question;

import java.util.ArrayList;
import java.util.Random;

public final class QuestionManager {

	private static ArrayList<Question> questions = new ArrayList<>();

	public static void createQuestions() {	
		// Je¿eli w pytaniu chcemy przejœæ do nastêpnej linii u¿ywamy "\n"
		
		questions.add(new Question("Je¿eli chcielibyœmy zapisaæ liczbê 99 po angielsku otrzymalibyœmy ?", "nine ninety", "ten thousand", "ninety nine", "fifteen five", 2));
		questions.add(new Question("W jêzyku angielskim s³owo 'car' oznacza ?", "Samolot", "Samochód", "Statek", "Motor", 1));
		questions.add(new Question("Jak nazywa siê w jêzyku angielskim telefon marki jab³ko?", "Apfel", "Melon", "Pinneapple", "Apple", 3));
		questions.add(new Question("Jak po angielsku pisze siê s³owo policjanci?","policeman","policemen","policemans","policemens",1));
		questions.add(new Question("Co oznacza s³owo cat?","Szatan","kat","jaszczurka","kot",3));
		questions.add(new Question("Co po polsku oznacza s³owo chairman?","cz³owiek krzes³o","szef","przewodnicz¹cy","pracodawca",2));
		questions.add(new Question("Zdanie: To drink alcohol you must be atleast 18 years old. oznacza?","By pic alkochol musisz mieæ minimum 18 lat","By pic alkochol musisz mieæ ponad 18 lat","By pic alkochol mo¿esz mieæ minimum 18 lat","By pic alkochol nie musisz mieæ minimum 18 lat",0));
		questions.add(new Question("Jak odczytujemy datê 1912?","ninety twenty two","nineteen twenteen","nineteen tvelwe","nineteen twelve",3));
		questions.add(new Question("Jak odczytujemy datê 979?","ninety seven and nine","ninety hundred seventy nine","nine hundred seventy nine","nine seventy nine",2));
		questions.add(new Question("W jêzyku angielskim 5=2+3 mo¿emy zapisaæ w postaci?", "five equals two plus three", "five equinox two plus three", "five equals two equals plus three", "five equals three", 0));
		questions.add(new Question("W jêzyku angielskim s³owo \"Sound Card\" oznacza?", "Karta graficzna", "Karta dŸwiêkowa", "Karta rozszerzeñ", "Karta USB", 1));
		questions.add(new Question("Wynik dzia³ania: four + two - one, jest równy?","3","4","5","6",2));
		questions.add(new Question("Wyra¿enie: Money on the wallet, oznacza?","Pieni¹dze na portfelu","Pieni¹dze w portfelu","Pieni¹dze pod portfelem","Pieni¹dze przed portfelem",0));
		questions.add(new Question("S³owo if oznacza?","dlaczego","kiedy","je¿eli","albo",2));
		questions.add(new Question("Je¿eli pójdziemy do zoo szukaj¹c s³oni, powinniœmy szukaæ tabliczki z napisem:","elephants","tigers","snakes","big animal",0));
		questions.add(new Question("Który spoœród wymienionych przedmiotów nie pasuje w kuchni?","knife","spoon","fork","saw",3));
		questions.add(new Question("Czego u¿ywamy do smarowania chleba mas³em?","hand","stick","knife","rock",2));
		questions.add(new Question("Jak mówimy na banana w jêzyku angielskim?","banana","banaana","bannana","baanan",0));
		questions.add(new Question("Jak zapytamy o drogê na pocztê?","How can i go to the post house?","How can i go to the post hause?","How can i look for post office?","How can i go to the post office?",3));
		questions.add(new Question("Jak zapytamy kogoœ o jego wiek?","How old is you?","How much old are you","How old are you?","How old am I?",2));
		questions.add(new Question("Jak powiemy komuœ, ¿e kochamy czekoladê?","I love chocolate","I love chocolade","I hate chocolade","chocolade is my love",0));
		questions.add(new Question("S³owo \"Szef Kuchni\" w jêzyku angielskim ma postaæ:", "Thief", "Thef", "Chief", "Chef", 3));
		questions.add(new Question("Czas Present Simple po polsku oznacza:", "Czas przysz³y prosty", "Czas przesz³y prosty", "Czas teraŸniejszy prosty", "Czas teraŸniejszy", 2));
		questions.add(new Question("Holandia w jêzyku angielskim ma postaæ: ", "Netherlands, Holand", "Netherland, Holland", "Netherlands, Holland", "Netherlands, Herland", 2));
		questions.add(new Question("S³owo \"grumble\" w jêzyku angielskim oznacza?", "narzekaæ, burczeæ (w brzuchu)", "garb", "niezliczony", "g¹szcz, zaroœla", 0));
		questions.add(new Question("S³owo \"discernible\" w jêzyku angielskim oznacza?", "zauwa¿alny, pragn¹æ", "zauwa¿alny", "pragn¹æ", "okaleczaæ", 1));
		questions.add(new Question("S³owo \"trademark\" w jêzyku angielskim oznacza?", "znak prosty", "znak zodiaku", "znak towarowy", "znak wodny", 2));
		questions.add(new Question("Wybierz prawid³ow¹ odpowiedŸ:\n\nWould you ... for a drink?", "try", "like", "care", "check", 2));
		questions.add(new Question("Wybierz prawid³ow¹ odpowiedŸ:\n\nCould someone give me ... with the washing up?", "an aid", "a help", "a tip", "a hand", 3));
		
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
