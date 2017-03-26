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
			
		// Jeżeli w pytaniu chcemy przejść do następnej linii używamy "\n"
		
		questions.add(new Question("Jeżeli chcielibyśmy zapisać liczbę 99 po angielsku otrzymalibyśmy ?", "nine ninety", "ten thousand", "ninety nine", "fifteen five", 2));
		questions.add(new Question("W języku angielskim słowo 'car' oznacza ?", "Samolot", "Samochód", "Statek", "Motor", 1));
		questions.add(new Question("W języku angielskim słowo 'ferry' oznacza?", "Samolot", "Samochód", "Prom", "Ścigacz", 2));
		questions.add(new Question("W języku angielskim słowo 'cloudy' oznacza?", "Pochmurny", "Szybki", "Skośny", "Surowy", 0));
		questions.add(new Question("W języku angielskim słowo 'shoelaces' oznacza?", "Lance", "Sznurówki", "Sznury", "Korona", 1));
		questions.add(new Question("Jak nazywa się w języku angielskim telefon marki jabłko?", "Apfel", "Melon", "Pinneapple", "Apple", 3));
		questions.add(new Question("Jak po angielsku pisze się słowo policjanci?","policeman","policemen","policemans","policemens",1));
		questions.add(new Question("Jak po angielsku zapisuje sie kraj Bangladesz?", "Bandladesh", "Bangladesh", "Bangladeshi", "Banladeshy", 1));
		questions.add(new Question("Co oznacza słowo cat?","Szatan","kat","jaszczurka","kot",3));
		questions.add(new Question("Co oznacza słowo monkey","skarbonka","pieniądze","małpa","człowiek",2));
		questions.add(new Question("Co oznacza słowo clumsy?", "niezdarny", "śmiały", "miękki", "szybki", 0));
		questions.add(new Question("Co po polsku oznacza słowo chairman?","człowiek krzesło","szef","przewodniczący","pracodawca",2));
		questions.add(new Question("Zdanie: To drink alcohol you must be atleast 18 years old. oznacza?","By pic alkochol musisz mieć minimum 18 lat","By pic alkochol musisz mieć ponad 18 lat","By pic alkochol możesz mieć minimum 18 lat","By pic alkochol nie musisz mieć minimum 18 lat",0));
		questions.add(new Question("Zdanie: You mustn't run at the swimming pool. oznacza","Nie powinieneś biegać na basenie","Nie powinieneś biegać przy stawie wędkarskim","Nie wolno Ci biegać w pobliżu wody","Nie wolno Ci biegać na basenie",3));
		questions.add(new Question("Zdanie: What a miserable weather! oznacza?", "Jaki okropny dzień!", "Jaka okropna pogoda!", "Jaka paskudna pogoda!", "Jaka piękna pogoda!", 2));
		questions.add(new Question("Zdanie: We haven't had any rain for a fortnight! oznacza?", "Mieliśmy rano ulewę!", "Nie padało od dwóch tygodni", "Nie było burzy przez dwa tygodnie", "Nie będzie padało przez dwa tygodnie", 1));
		questions.add(new Question("Jak odczytujemy datę 1912?","ninety twenty two","nineteen twenteen","nineteen tvelwe","nineteen twelve",1));
		questions.add(new Question("Jak odczytujemy datę 979?","ninety seven and nine","ninety hundred seventy nine","nine hundred seventy nine","nine seventy nine",2));
		questions.add(new Question("Jak odczytujemy liczbe 10011?", "ten thousand eleven", "ten hundred eleven", "ten thousand hundred", "ten thousand one one", 0));
		questions.add(new Question("Jak odczytujemy liczbe 40089","fourteen thousand eighty ninety","forty hundred and eighty nine","forty and eight hundred nine","forty thousand eighty nine",3));
		questions.add(new Question("Jak odczytujemy liczbe 33","twenty two","thirsty three","thirty three","trinity three",2));
		questions.add(new Question("W języku angielskim 3*1≠2+2 możemy zapisać w postaci?","three times one equals two plus two","three times one is bigger than two plus two","three times two equals one plus one","three times one unequals two plus two",3));
		questions.add(new Question("W języku angielskim 5/3 możemy zapisać w postaci?","five times three","five equinoxes of three","five thirds","three fifths",2));
		questions.add(new Question("W języku angielskim 5=2+3 możemy zapisać w postaci?", "five equals two plus three", "five equinox two plus three", "five equals two equals plus three", "five equals three", 0));
		questions.add(new Question("W języku angielskim 8/2=2*2 możemy zapisać w postaci?", "eight divided by two equals two multiply by two", "eight diffed by two equals two factor two", "eight equals two divided by four", "eight factored by two equals two summary two", 0));
		questions.add(new Question("Wynik działania: four + two - one, jest równy?","3","4","5","6",2));
		questions.add(new Question("Wynik działania: twelve + eleven + one / eight, jest równy?", "5", "8", "4", "12", 2));
		questions.add(new Question("Wyrażenie: Money on the wallet, oznacza?","Pieniądze na portfelu","Pieniądze w portfelu","Pieniądze pod portfelem","Pieniądze przed portfelem",0));
		questions.add(new Question("Jeżeli pójdziemy do zoo szukając słoni, powinniśmy szukać tabliczki z napisem:","elephants","tigers","snakes","big animal",0));
		questions.add(new Question("Który spośród wymienionych przedmiotów nie pasuje w kuchni?","knife","spoon","fork","saw",3));
		questions.add(new Question("Który spośród wymienionych przedmiotów nie pasuje w biurze?", "computer", "screen", "barn", "desk", 2));
		questions.add(new Question("Czego używamy do smarowania chleba masłem?","hand","stick","knife","rock", 2));
		questions.add(new Question("Czym zazwyczaj słodzimy herbatę?", "water drops", "sand", "sugar", "cane", 2));
		questions.add(new Question("Jak powiemy, że jest dziś mgliście?", "It's cloudy today", "It's stormy today", "It's foggy today", "It's windy today", 2));
		questions.add(new Question("Jak powiemy, że jest dziś słonecznie?", "It's stormy today", "It's cloudy today", "It's foggy today", "It's sunny today", 3));
		questions.add(new Question("Jak mówimy na banana w języku angielskim?","banana","banaana","bannana","baanan",0));
		questions.add(new Question("Jak zapytamy o drogę na pocztę?","How can i go to the post house?","How can i go to the post hause?","How can i look for post office?","How can i go to the post office?",3));
		questions.add(new Question("Jak zapytamy kogoś o jego wiek?","How old is you?","How much old are you","How old are you?","How old am I?",2));
		questions.add(new Question("Jak powiemy komuś, że kochamy czekoladę?","I love chocolate","I love chocolade","I hate chocolade","chocolade is my love",0));
		questions.add(new Question("Jak powiemy komuś, że urodziliśmy się w Polsce?", "I live in Poland", "I hate Poland", "I born in Poland", "I love Poland", 2));
		questions.add(new Question("Jak powiemy komuś, że nienawidzę słodyczy?", "I hate sweets", "I hatred sweetnes", "I hate candy", "I am candy", 0));
		questions.add(new Question("Czas Present Simple po polsku oznacza?", "Czas przyszły prosty", "Czas przeszły prosty", "Czas teraźniejszy prosty", "Czas teraźniejszy", 2));
		questions.add(new Question("Czas Past Simple po polsku oznacza?", "Czas przyszły", "Czas przeszły", "Czas teraźniejszy", "Czas przyszły prosty", 1));
		questions.add(new Question("Czas Present Perfect po polsku oznacza?", "Czas przeszły", "Czas teraźniejszy", "Czas przeszły prosty", "Czas obecny doskonały", 3));
		questions.add(new Question("Czas Future Simple po polsku oznacza?", "Czas obecny doskonały", "Czas teraźniejszy", "Czas przyszły prosty", "Czas przeszły", 2));
		questions.add(new Question("Holandia w języku angielskim ma postać: ", "Netherlands, Holand", "Netherland, Holland", "Netherlands, Holland", "Netherlands, Herland", 2));
		questions.add(new Question("Szwecja w języku angielskim ma postać: ", "Vatican", "Sweden", "Switzerland", "Switzland", 2));
		questions.add(new Question("Słowo \"Szef Kuchni\" w języku angielskim ma postać:", "Thief", "Thef", "Chief", "Chef", 3));
		questions.add(new Question("Słowo \"grumble\" w języku angielskim oznacza?", "narzekać, burczeć (w brzuchu)", "garb", "niezliczony", "gąszcz, zarośla", 0));
		questions.add(new Question("Słowo \"discernible\" w języku angielskim oznacza?", "zauważalny, pragnąć", "zauważalny", "pragnąć", "okaleczać", 1));
		questions.add(new Question("Słowo \"trademark\" w języku angielskim oznacza?", "znak prosty", "znak zodiaku", "znak towarowy", "znak wodny", 2));
		questions.add(new Question("Słowo \"mediterranean\" w języku angielskim oznacza?", "Morze Śródziemne", "Medykamenty", "Medyk", "Uznanie", 0));
		questions.add(new Question("Słowo \"shabby\" w języku angielskim oznacza?", "zapadlisko", "niespokojny", "okazały", "przepyszny", 3));
		questions.add(new Question("Słowo \"partitions\" w języku angielskim oznacza?", "pozycje", "rozbiory", "pochodzenie", "obszycie", 1));
		questions.add(new Question("Słowo \"bee\" w języku angielskim oznacza?","osę","pszczołę","szerszenia","muchę",1));
		questions.add(new Question("Słowo \"wasp\" w języku angielskim oznacza?","osę","pszczołę","szerszenia","muchę",0));
		questions.add(new Question("Słowo \"divide\" w języku angielskim oznacza?","mnożyć","rozmnożyć","rozdzielić","podzielić",3));
		questions.add(new Question("Słowo \"multiply\" w języku angielskim oznacza?","rozdzielać","powiększać","mnożyć","dzielić",2));
		questions.add(new Question("Słowo \"Sound Card\" oznacza?", "karta dźwiękowa", "karta graficzna", "karta kredytowa", "karta usb", 0));
		questions.add(new Question("Słowo \"if\" oznacza?","dlaczego","kiedy","jeżeli","albo",2));
		questions.add(new Question("Słowo \"Integrated peripherals\" oznacza?", "zintegrowane urządzenie wyjścia", "zintegrowane urządzenie wejścia", "zintegrowane urządzenia peryferyjne", "urządzenie wejścia", 2));
		questions.add(new Question("Wybierz prawidłową odpowiedź:\n\nWould you ... for a drink?", "try", "like", "care", "check", 2));
		questions.add(new Question("Wybierz prawidłową odpowiedź:\n\nDo you live here? Yes, I ...", "am", "do", "does", "want", 1));
		questions.add(new Question("Wybierz prawidłową odpowiedź:\n\nShe ... him because he's boring", "doesn't like", "does like", "don't like", "try like", 0));
		questions.add(new Question("Wybierz prawidłową odpowiedź:\n\nI ... like Art.", "doesn't", "am not", "don't", "pear", 2));
		questions.add(new Question("Wybierz prawidłową odpowiedź:\n\n... lives ... a flat.", "He, on", "I, on", "He, in", "He, at", 0));
		questions.add(new Question("Wybierz prawidłową odpowiedź:\n\nWhere ... your grandparents live.","is","are","do","does",2));
		questions.add(new Question("Wybierz prawidłową odpowiedź:\n\nWhat ... your favourite color.","be","were","are","is",3));
		questions.add(new Question("Wybierz prawidłową odpowiedź:\n\nMy father is ... Actor.","the","a","an","en",2));
		questions.add(new Question("Wybierz prawidłową odpowiedź:\n\nMy mother is ... Doctor.","the","a","an","en",1));
		questions.add(new Question("Wybierz prawidłową odpowiedź:\n\n... Mississippi River is the chief river of the largest drainage system on the North American continent.","A","En","The","An",1));
		questions.add(new Question("Wybierz prawidłową odpowiedź:\n\nWhat's the waether ... today?","like","look","seems","looks",0));
		questions.add(new Question("Wybierz prawidłową odpowiedź:\n\nCan i get to our school ... car from here?","with","throught","by","on",2));
		questions.add(new Question("Odpowiedz na pytanie:\n\nHow many good answers are below this question? ","three","two","one","four",2));
		questions.add(new Question("Przetłumacz:\n\nI really like apples, pears and chocolate", "Bardzo lubię jabłka, gruszki i czekoladę", "Bardzo lubię jabłka, perły i czekoladę", "Bardzo lubię jabłka, perły i warzywa", "Bardzo lubię jabłka, słodycze i warzywa", 0));
		questions.add(new Question("Przetłumacz:\n\nI hate arrogant people but I also understand shy people.", "Nienawidzę aroganckich ludzi, ale też rozumiem dobrych ludzi", "Nienawidzę aroganckich ludzi, ale też rozumiem nieśmiałych ludzi", "Nienawidzę złych ludzi", "Zdanie jest niepoprawne.", 1));
		questions.add(new Question("Przetłumacz:\n\nI hate chocolade", "Nienawidzę czekolady", "Nienawidzę słodyczy", "Nienawidzę owoców", "Zdanie jest niepoprawne", 3));
		questions.add(new Question("Przetłumacz:\n\nI love chocolate", "Kocham czekoladę", "Kocham słodycze", "Kocham owoce", "Zdanie jest niepoprawne", 0));
		questions.add(new Question("Przetłumacz:\n\nI am tired of waiting!", "Jestem wkurzony czekaniem!", "Jestem zmęczony czekaniem!", "Jestem wyczerpany czekaniem!", "Zdanie jest niepoprawne!", 1));
		questions.add(new Question("Przetłumacz:\n\nI am exhausted!", "Jestem wkurzony!", "Jestem zmęczony!", "Jestem wyczerpany!", "Zdanie jest niepoprawne!", 2));
		questions.add(new Question("Przetłumacz:\n\nI really miss you!", "Naprawdę tesknię za tobą", "Naprawdę cię kocham", "Naprawdę czekam na ciebie!", "Nie trafiłem na ciebie!", 0));
		
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
