package dev.projekt_v2.question;

import java.util.ArrayList;
import java.util.Random;

public final class QuestionManager {

	// Baza pytan
	private static ArrayList<Question> questions = new ArrayList<>();
	
	// Wybrane pytania do quizu
	private static ArrayList<Question> questionsSelected = new ArrayList<>();
	
	public static void createQuestions() {	
		if(!questions.isEmpty())
			questions.clear();
			
		// Je�eli w pytaniu chcemy przej�� do nast�pnej linii u�ywamy "\n"
		
		questions.add(new Question("Je�eli chcieliby�my zapisa� liczb� 99 po angielsku otrzymaliby�my ?", "nine ninety", "ten thousand", "ninety nine", "fifteen five", 2));
		questions.add(new Question("W j�zyku angielskim s�owo 'car' oznacza ?", "Samolot", "Samoch�d", "Statek", "Motor", 1));
		questions.add(new Question("W j�zyku angielskim s�owo 'ferry' oznacza?", "Samolot", "Samoch�d", "Prom", "�cigacz", 2));
		questions.add(new Question("W j�zyku angielskim s�owo 'cloudy' oznacza?", "Pochmurny", "Szybki", "Sko�ny", "Surowy", 0));
		questions.add(new Question("W j�zyku angielskim s�owo 'shoelaces' oznacza?", "Lance", "Sznur�wki", "Sznury", "Korona", 1));
		questions.add(new Question("Jak nazywa si� w j�zyku angielskim telefon marki jab�ko?", "Apfel", "Melon", "Pinneapple", "Apple", 3));
		questions.add(new Question("Jak po angielsku pisze si� s�owo policjanci?","policeman","policemen","policemans","policemens",1));
		questions.add(new Question("Jak po angielsku zapisuje sie kraj Bangladesz?", "Bandladesh", "Bangladesh", "Bangladeshi", "Banladeshy", 1));
		questions.add(new Question("Co oznacza s�owo cat?","Szatan","kat","jaszczurka","kot",3));
		questions.add(new Question("Co oznacza s�owo monkey","skarbonka","pieni�dze","ma�pa","cz�owiek",2));
		questions.add(new Question("Co oznacza s�owo clumsy?", "niezdarny", "�mia�y", "mi�kki", "szybki", 0));
		questions.add(new Question("Co po polsku oznacza s�owo chairman?","cz�owiek krzes�o","szef","przewodnicz�cy","pracodawca",2));
		questions.add(new Question("Zdanie: To drink alcohol you must be atleast 18 years old. oznacza?","By pic alkochol musisz mie� minimum 18 lat","By pic alkochol musisz mie� ponad 18 lat","By pic alkochol mo�esz mie� minimum 18 lat","By pic alkochol nie musisz mie� minimum 18 lat",0));
		questions.add(new Question("Zdanie: You mustn't run at the swimming pool. oznacza","Nie powiniene� biega� na basenie","Nie powiniene� biega� przy stawie w�dkarskim","Nie wolno Ci biega� w pobli�u wody","Nie wolno Ci biega� na basenie",3));
		questions.add(new Question("Zdanie: What a miserable weather! oznacza?", "Jaki okropny dzie�!", "Jaka okropna pogoda!", "Jaka paskudna pogoda!", "Jaka pi�kna pogoda!", 2));
		questions.add(new Question("Zdanie: We haven't had any rain for a fortnight! oznacza?", "Mieli�my rano ulew�!", "Nie pada�o od dw�ch tygodni", "Nie by�o burzy przez dwa tygodnie", "Nie b�dzie pada�o przez dwa tygodnie", 1));
		questions.add(new Question("Jak odczytujemy dat� 1912?","ninety twenty two","nineteen twenteen","nineteen tvelwe","nineteen twelve",1));
		questions.add(new Question("Jak odczytujemy dat� 979?","ninety seven and nine","ninety hundred seventy nine","nine hundred seventy nine","nine seventy nine",2));
		questions.add(new Question("Jak odczytujemy liczbe 10011?", "ten thousand eleven", "ten hundred eleven", "ten thousand hundred", "ten thousand one one", 0));
		questions.add(new Question("Jak odczytujemy liczbe 40089","fourteen thousand eighty ninety","forty hundred and eighty nine","forty and eight hundred nine","forty thousand eighty nine",3));
		questions.add(new Question("Jak odczytujemy liczbe 33","twenty two","thirsty three","thirty three","trinity three",2));
		questions.add(new Question("W j�zyku angielskim 3*1=/=2+2 mo�emy zapisa� w postaci?","three times one equals two plus two","three times one is bigger than two plus two","three times two equals one plus one","three times one unequals two plus two",3));
		questions.add(new Question("W j�zyku angielskim 5/3 mo�emy zapisa� w postaci?","five times three","five equinoxes of three","five thirds","three fifths",2));
		questions.add(new Question("W j�zyku angielskim 5=2+3 mo�emy zapisa� w postaci?", "five equals two plus three", "five equinox two plus three", "five equals two equals plus three", "five equals three", 0));
		questions.add(new Question("W j�zyku angielskim 8/2=2*2 mo�emy zapisa� w postaci?", "eight divided by two equals two multiply by two", "eight diffed by two equals two factor two", "eight equals two divided by four", "eight factored by two equals two summary two", 0));
		questions.add(new Question("Wynik dzia�ania: four + two - one, jest r�wny?","3","4","5","6",2));
		questions.add(new Question("Wynik dzia�ania: twelve + eleven + one / eight, jest r�wny?", "5", "8", "4", "12", 2));
		questions.add(new Question("Wyra�enie: Money on the wallet, oznacza?","Pieni�dze na portfelu","Pieni�dze w portfelu","Pieni�dze pod portfelem","Pieni�dze przed portfelem",0));
		questions.add(new Question("Je�eli p�jdziemy do zoo szukaj�c s�oni, powinni�my szuka� tabliczki z napisem:","elephants","tigers","snakes","big animal",0));
		questions.add(new Question("Kt�ry spo�r�d wymienionych przedmiot�w nie pasuje w kuchni?","knife","spoon","fork","saw",3));
		questions.add(new Question("Kt�ry spo�r�d wymienionych przedmiot�w nie pasuje w biurze?", "computer", "screen", "barn", "desk", 2));
		questions.add(new Question("Czego u�ywamy do smarowania chleba mas�em?","hand","stick","knife","rock", 2));
		questions.add(new Question("Czym zazwyczaj s�odzimy herbat�?", "water drops", "sand", "sugar", "cane", 2));
		questions.add(new Question("Jak powiemy, �e jest dzi� mgli�cie?", "It's cloudy today", "It's stormy today", "It's foggy today", "It's windy today", 2));
		questions.add(new Question("Jak powiemy, �e jest dzi� s�onecznie?", "It's stormy today", "It's cloudy today", "It's foggy today", "It's sunny today", 3));
		questions.add(new Question("Jak m�wimy na banana w j�zyku angielskim?","banana","banaana","bannana","baanan",0));
		questions.add(new Question("Jak zapytamy o drog� na poczt�?","How can i go to the post house?","How can i go to the post hause?","How can i look for post office?","How can i go to the post office?",3));
		questions.add(new Question("Jak zapytamy kogo� o jego wiek?","How old is you?","How much old are you","How old are you?","How old am I?",2));
		questions.add(new Question("Jak powiemy komu�, �e kochamy czekolad�?","I love chocolate","I love chocolade","I hate chocolade","chocolade is my love",0));
		questions.add(new Question("Jak powiemy komu�, �e urodzili�my si� w Polsce?", "I live in Poland", "I hate Poland", "I born in Poland", "I love Poland", 2));
		questions.add(new Question("Jak powiemy komu�, �e nienawidz� s�odyczy?", "I hate sweets", "I hatred sweetnes", "I hate candy", "I am candy", 0));
		questions.add(new Question("Czas Present Simple po polsku oznacza?", "Czas przysz�y prosty", "Czas przesz�y prosty", "Czas tera�niejszy prosty", "Czas tera�niejszy", 2));
		questions.add(new Question("Czas Past Simple po polsku oznacza?", "Czas przysz�y", "Czas przesz�y", "Czas tera�niejszy", "Czas przysz�y prosty", 1));
		questions.add(new Question("Czas Present Perfect po polsku oznacza?", "Czas przesz�y", "Czas tera�niejszy", "Czas przesz�y prosty", "Czas obecny doskona�y", 3));
		questions.add(new Question("Czas Future Simple po polsku oznacza?", "Czas obecny doskona�y", "Czas tera�niejszy", "Czas przysz�y prosty", "Czas przesz�y", 2));
		questions.add(new Question("Holandia w j�zyku angielskim ma posta�: ", "Netherlands, Holand", "Netherland, Holland", "Netherlands, Holland", "Netherlands, Herland", 2));
		questions.add(new Question("Szwecja w j�zyku angielskim ma posta�: ", "Vatican", "Sweden", "Switzerland", "Switzland", 2));
		questions.add(new Question("S�owo \"Szef Kuchni\" w j�zyku angielskim ma posta�:", "Thief", "Thef", "Chief", "Chef", 3));
		questions.add(new Question("S�owo \"grumble\" w j�zyku angielskim oznacza?", "narzeka�, burcze� (w brzuchu)", "garb", "niezliczony", "g�szcz, zaro�la", 0));
		questions.add(new Question("S�owo \"discernible\" w j�zyku angielskim oznacza?", "zauwa�alny, pragn��", "zauwa�alny", "pragn��", "okalecza�", 1));
		questions.add(new Question("S�owo \"trademark\" w j�zyku angielskim oznacza?", "znak prosty", "znak zodiaku", "znak towarowy", "znak wodny", 2));
		questions.add(new Question("S�owo \"mediterranean\" w j�zyku angielskim oznacza?", "Morze �r�dziemne", "Medykamenty", "Medyk", "Uznanie", 0));
		questions.add(new Question("S�owo \"shabby\" w j�zyku angielskim oznacza?", "zapadlisko", "niespokojny", "okaza�y", "przepyszny", 3));
		questions.add(new Question("S�owo \"partitions\" w j�zyku angielskim oznacza?", "pozycje", "rozbiory", "pochodzenie", "obszycie", 1));
		questions.add(new Question("S�owo \"bee\" w j�zyku angielskim oznacza?","os�","pszczo��","szerszenia","much�",1));
		questions.add(new Question("S�owo \"wasp\" w j�zyku angielskim oznacza?","os�","pszczo��","szerszenia","much�",0));
		questions.add(new Question("S�owo \"divide\" w j�zyku angielskim oznacza?","mno�y�","rozmno�y�","rozdzieli�","podzieli�",3));
		questions.add(new Question("S�owo \"multiply\" w j�zyku angielskim oznacza?","rozdziela�","powi�ksza�","mno�y�","dzieli�",2));
		questions.add(new Question("S�owo \"Sound Card\" oznacza?", "karta d�wi�kowa", "karta graficzna", "karta kredytowa", "karta usb", 0));
		questions.add(new Question("S�owo \"if\" oznacza?","dlaczego","kiedy","je�eli","albo",2));
		questions.add(new Question("S�owo \"Integrated peripherals\" oznacza?", "zintegrowane urz�dzenie wyj�cia", "zintegrowane urz�dzenie wej�cia", "zintegrowane urz�dzenia peryferyjne", "urz�dzenie wej�cia", 2));
		questions.add(new Question("Wybierz prawid�ow� odpowied�:\n\nWould you ... for a drink?", "try", "like", "care", "check", 2));
		questions.add(new Question("Wybierz prawid�ow� odpowied�:\n\nDo you live here? Yes, I ...", "am", "do", "does", "want", 1));
		questions.add(new Question("Wybierz prawid�ow� odpowied�:\n\nShe ... him because he's boring", "doesn't like", "does like", "don't like", "try like", 0));
		questions.add(new Question("Wybierz prawid�ow� odpowied�:\n\nI ... like Art.", "doesn't", "am not", "don't", "pear", 2));
		questions.add(new Question("Wybierz prawid�ow� odpowied�:\n\n... lives ... a flat.", "He, on", "I, on", "He, in", "He, at", 0));
		questions.add(new Question("Wybierz prawid�ow� odpowied�:\n\nWhere ... your grandparents live.","is","are","do","does",2));
		questions.add(new Question("Wybierz prawid�ow� odpowied�:\n\nWhat ... your favourite color.","be","were","are","is",3));
		questions.add(new Question("Wybierz prawid�ow� odpowied�:\n\nMy father is ... Actor.","the","a","an","en",2));
		questions.add(new Question("Wybierz prawid�ow� odpowied�:\n\nMy mother is ... Doctor.","the","a","an","en",1));
		questions.add(new Question("Wybierz prawid�ow� odpowied�:\n\n... Mississippi River is the chief river of the largest drainage system on the North American continent.","A","En","The","An",1));
		questions.add(new Question("Wybierz prawid�ow� odpowied�:\n\nWhat's the waether ... today?","like","look","seems","looks",0));
		questions.add(new Question("Wybierz prawid�ow� odpowied�:\n\nCan i get to our school ... car from here?","with","throught","by","on",2));
		questions.add(new Question("Odpowiedz na pytanie:\n\nHow many good answers are below this question? ","three","two","one","four",2));
		questions.add(new Question("Przet�umacz:\n\nI really like apples, pears and chocolate", "Bardzo lubi� jab�ka, gruszki i czekolad�", "Bardzo lubi� jab�ka, per�y i czekolad�", "Bardzo lubi� jab�ka, per�y i warzywa", "Bardzo lubi� jab�ka, s�odycze i warzywa", 0));
		questions.add(new Question("Przet�umacz:\n\nI hate arrogant people but I also understand shy people.", "Nienawidz� aroganckich ludzi, ale te� rozumiem dobrych ludzi", "Nienawidz� aroganckich ludzi, ale te� rozumiem nie�mia�ych ludzi", "Nienawidz� z�ych ludzi", "Zdanie jest niepoprawne.", 1));
		questions.add(new Question("Przet�umacz:\n\nI hate chocolade", "Nienawidz� czekolady", "Nienawidz� s�odyczy", "Nienawidz� owoc�w", "Zdanie jest niepoprawne", 3));
		questions.add(new Question("Przet�umacz:\n\nI love chocolate", "Kocham czekolad�", "Kocham s�odycze", "Kocham owoce", "Zdanie jest niepoprawne", 0));
		questions.add(new Question("Przet�umacz:\n\nI am tired of waiting!", "Jestem wkurzony czekaniem!", "Jestem zm�czony czekaniem!", "Jestem wyczerpany czekaniem!", "Zdanie jest niepoprawne!", 1));
		questions.add(new Question("Przet�umacz:\n\nI am exhausted!", "Jestem wkurzony!", "Jestem zm�czony!", "Jestem wyczerpany!", "Zdanie jest niepoprawne!", 2));
		questions.add(new Question("Przet�umacz:\n\nI really miss you!", "Naprawd� teskni� za tob�", "Naprawd� ci� kocham", "Naprawd� czekam na ciebie!", "Nie trafi�em na ciebie!", 0));
		
//		questions.add(new Question("","","","","",0));
//		questions.add(new Question("","","","","",0));
	}
	
	public static void selectRandomQuestions(int count) {
		Random rand = new Random();
		
		ArrayList<Integer> selects = new ArrayList<>();
		
		questionsSelected.clear();
		
		for(int i = 0; i < count; ++i) {
			int idx = rand.nextInt(questions.size());
			
			if(questionsSelected.isEmpty()) {
				Question q = questions.get(idx);
				q.mix(rand.nextInt(4));
				
				questionsSelected.add(q);
				selects.add(idx);
			}
			else {
				while(selects.contains(idx)) {
					idx = rand.nextInt(questions.size());
				}
				
				Question q = questions.get(idx);
				q.mix(rand.nextInt(4));
				
				questionsSelected.add(q);
				selects.add(idx);
			}
		}
	}
	
	public static Question selectQuestion(int id) {
		return questionsSelected.get(id - 1);
	}
}
