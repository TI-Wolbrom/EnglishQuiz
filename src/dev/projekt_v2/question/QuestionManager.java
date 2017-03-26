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
			
		// Je¿eli w pytaniu chcemy przejœæ do nastêpnej linii u¿ywamy "\n"
		
		questions.add(new Question("Je¿eli chcielibyœmy zapisaæ liczbê 99 po angielsku otrzymalibyœmy ?", "nine ninety", "ten thousand", "ninety nine", "fifteen five", 2));
		questions.add(new Question("W jêzyku angielskim s³owo 'car' oznacza ?", "Samolot", "Samochód", "Statek", "Motor", 1));
		questions.add(new Question("W jêzyku angielskim s³owo 'ferry' oznacza?", "Samolot", "Samochód", "Prom", "Œcigacz", 2));
		questions.add(new Question("W jêzyku angielskim s³owo 'cloudy' oznacza?", "Pochmurny", "Szybki", "Skoœny", "Surowy", 0));
		questions.add(new Question("W jêzyku angielskim s³owo 'shoelaces' oznacza?", "Lance", "Sznurówki", "Sznury", "Korona", 1));
		questions.add(new Question("Jak nazywa siê w jêzyku angielskim telefon marki jab³ko?", "Apfel", "Melon", "Pinneapple", "Apple", 3));
		questions.add(new Question("Jak po angielsku pisze siê s³owo policjanci?","policeman","policemen","policemans","policemens",1));
		questions.add(new Question("Jak po angielsku zapisuje sie kraj Bangladesz?", "Bandladesh", "Bangladesh", "Bangladeshi", "Banladeshy", 1));
		questions.add(new Question("Co oznacza s³owo cat?","Szatan","kat","jaszczurka","kot",3));
		questions.add(new Question("Co oznacza s³owo monkey","skarbonka","pieni¹dze","ma³pa","cz³owiek",2));
		questions.add(new Question("Co oznacza s³owo clumsy?", "niezdarny", "œmia³y", "miêkki", "szybki", 0));
		questions.add(new Question("Co po polsku oznacza s³owo chairman?","cz³owiek krzes³o","szef","przewodnicz¹cy","pracodawca",2));
		questions.add(new Question("Zdanie: To drink alcohol you must be atleast 18 years old. oznacza?","By pic alkochol musisz mieæ minimum 18 lat","By pic alkochol musisz mieæ ponad 18 lat","By pic alkochol mo¿esz mieæ minimum 18 lat","By pic alkochol nie musisz mieæ minimum 18 lat",0));
		questions.add(new Question("Zdanie: You mustn't run at the swimming pool. oznacza","Nie powinieneœ biegaæ na basenie","Nie powinieneœ biegaæ przy stawie wêdkarskim","Nie wolno Ci biegaæ w pobli¿u wody","Nie wolno Ci biegaæ na basenie",3));
		questions.add(new Question("Zdanie: What a miserable weather! oznacza?", "Jaki okropny dzieñ!", "Jaka okropna pogoda!", "Jaka paskudna pogoda!", "Jaka piêkna pogoda!", 2));
		questions.add(new Question("Zdanie: We haven't had any rain for a fortnight! oznacza?", "Mieliœmy rano ulewê!", "Nie pada³o od dwóch tygodni", "Nie by³o burzy przez dwa tygodnie", "Nie bêdzie pada³o przez dwa tygodnie", 1));
		questions.add(new Question("Jak odczytujemy datê 1912?","ninety twenty two","nineteen twenteen","nineteen tvelwe","nineteen twelve",1));
		questions.add(new Question("Jak odczytujemy datê 979?","ninety seven and nine","ninety hundred seventy nine","nine hundred seventy nine","nine seventy nine",2));
		questions.add(new Question("Jak odczytujemy liczbe 10011?", "ten thousand eleven", "ten hundred eleven", "ten thousand hundred", "ten thousand one one", 0));
		questions.add(new Question("Jak odczytujemy liczbe 40089","fourteen thousand eighty ninety","forty hundred and eighty nine","forty and eight hundred nine","forty thousand eighty nine",3));
		questions.add(new Question("Jak odczytujemy liczbe 33","twenty two","thirsty three","thirty three","trinity three",2));
		questions.add(new Question("W jêzyku angielskim 3*1=/=2+2 mo¿emy zapisaæ w postaci?","three times one equals two plus two","three times one is bigger than two plus two","three times two equals one plus one","three times one unequals two plus two",3));
		questions.add(new Question("W jêzyku angielskim 5/3 mo¿emy zapisaæ w postaci?","five times three","five equinoxes of three","five thirds","three fifths",2));
		questions.add(new Question("W jêzyku angielskim 5=2+3 mo¿emy zapisaæ w postaci?", "five equals two plus three", "five equinox two plus three", "five equals two equals plus three", "five equals three", 0));
		questions.add(new Question("W jêzyku angielskim 8/2=2*2 mo¿emy zapisaæ w postaci?", "eight divided by two equals two multiply by two", "eight diffed by two equals two factor two", "eight equals two divided by four", "eight factored by two equals two summary two", 0));
		questions.add(new Question("Wynik dzia³ania: four + two - one, jest równy?","3","4","5","6",2));
		questions.add(new Question("Wynik dzia³ania: twelve + eleven + one / eight, jest równy?", "5", "8", "4", "12", 2));
		questions.add(new Question("Wyra¿enie: Money on the wallet, oznacza?","Pieni¹dze na portfelu","Pieni¹dze w portfelu","Pieni¹dze pod portfelem","Pieni¹dze przed portfelem",0));
		questions.add(new Question("Je¿eli pójdziemy do zoo szukaj¹c s³oni, powinniœmy szukaæ tabliczki z napisem:","elephants","tigers","snakes","big animal",0));
		questions.add(new Question("Który spoœród wymienionych przedmiotów nie pasuje w kuchni?","knife","spoon","fork","saw",3));
		questions.add(new Question("Który spoœród wymienionych przedmiotów nie pasuje w biurze?", "computer", "screen", "barn", "desk", 2));
		questions.add(new Question("Czego u¿ywamy do smarowania chleba mas³em?","hand","stick","knife","rock", 2));
		questions.add(new Question("Czym zazwyczaj s³odzimy herbatê?", "water drops", "sand", "sugar", "cane", 2));
		questions.add(new Question("Jak powiemy, ¿e jest dziœ mgliœcie?", "It's cloudy today", "It's stormy today", "It's foggy today", "It's windy today", 2));
		questions.add(new Question("Jak powiemy, ¿e jest dziœ s³onecznie?", "It's stormy today", "It's cloudy today", "It's foggy today", "It's sunny today", 3));
		questions.add(new Question("Jak mówimy na banana w jêzyku angielskim?","banana","banaana","bannana","baanan",0));
		questions.add(new Question("Jak zapytamy o drogê na pocztê?","How can i go to the post house?","How can i go to the post hause?","How can i look for post office?","How can i go to the post office?",3));
		questions.add(new Question("Jak zapytamy kogoœ o jego wiek?","How old is you?","How much old are you","How old are you?","How old am I?",2));
		questions.add(new Question("Jak powiemy komuœ, ¿e kochamy czekoladê?","I love chocolate","I love chocolade","I hate chocolade","chocolade is my love",0));
		questions.add(new Question("Jak powiemy komuœ, ¿e urodziliœmy siê w Polsce?", "I live in Poland", "I hate Poland", "I born in Poland", "I love Poland", 2));
		questions.add(new Question("Jak powiemy komuœ, ¿e nienawidzê s³odyczy?", "I hate sweets", "I hatred sweetnes", "I hate candy", "I am candy", 0));
		questions.add(new Question("Czas Present Simple po polsku oznacza?", "Czas przysz³y prosty", "Czas przesz³y prosty", "Czas teraŸniejszy prosty", "Czas teraŸniejszy", 2));
		questions.add(new Question("Czas Past Simple po polsku oznacza?", "Czas przysz³y", "Czas przesz³y", "Czas teraŸniejszy", "Czas przysz³y prosty", 1));
		questions.add(new Question("Czas Present Perfect po polsku oznacza?", "Czas przesz³y", "Czas teraŸniejszy", "Czas przesz³y prosty", "Czas obecny doskona³y", 3));
		questions.add(new Question("Czas Future Simple po polsku oznacza?", "Czas obecny doskona³y", "Czas teraŸniejszy", "Czas przysz³y prosty", "Czas przesz³y", 2));
		questions.add(new Question("Holandia w jêzyku angielskim ma postaæ: ", "Netherlands, Holand", "Netherland, Holland", "Netherlands, Holland", "Netherlands, Herland", 2));
		questions.add(new Question("Szwecja w jêzyku angielskim ma postaæ: ", "Vatican", "Sweden", "Switzerland", "Switzland", 2));
		questions.add(new Question("S³owo \"Szef Kuchni\" w jêzyku angielskim ma postaæ:", "Thief", "Thef", "Chief", "Chef", 3));
		questions.add(new Question("S³owo \"grumble\" w jêzyku angielskim oznacza?", "narzekaæ, burczeæ (w brzuchu)", "garb", "niezliczony", "g¹szcz, zaroœla", 0));
		questions.add(new Question("S³owo \"discernible\" w jêzyku angielskim oznacza?", "zauwa¿alny, pragn¹æ", "zauwa¿alny", "pragn¹æ", "okaleczaæ", 1));
		questions.add(new Question("S³owo \"trademark\" w jêzyku angielskim oznacza?", "znak prosty", "znak zodiaku", "znak towarowy", "znak wodny", 2));
		questions.add(new Question("S³owo \"mediterranean\" w jêzyku angielskim oznacza?", "Morze Œródziemne", "Medykamenty", "Medyk", "Uznanie", 0));
		questions.add(new Question("S³owo \"shabby\" w jêzyku angielskim oznacza?", "zapadlisko", "niespokojny", "okaza³y", "przepyszny", 3));
		questions.add(new Question("S³owo \"partitions\" w jêzyku angielskim oznacza?", "pozycje", "rozbiory", "pochodzenie", "obszycie", 1));
		questions.add(new Question("S³owo \"bee\" w jêzyku angielskim oznacza?","osê","pszczo³ê","szerszenia","muchê",1));
		questions.add(new Question("S³owo \"wasp\" w jêzyku angielskim oznacza?","osê","pszczo³ê","szerszenia","muchê",0));
		questions.add(new Question("S³owo \"divide\" w jêzyku angielskim oznacza?","mno¿yæ","rozmno¿yæ","rozdzieliæ","podzieliæ",3));
		questions.add(new Question("S³owo \"multiply\" w jêzyku angielskim oznacza?","rozdzielaæ","powiêkszaæ","mno¿yæ","dzieliæ",2));
		questions.add(new Question("S³owo \"Sound Card\" oznacza?", "karta dŸwiêkowa", "karta graficzna", "karta kredytowa", "karta usb", 0));
		questions.add(new Question("S³owo \"if\" oznacza?","dlaczego","kiedy","je¿eli","albo",2));
		questions.add(new Question("S³owo \"Integrated peripherals\" oznacza?", "zintegrowane urz¹dzenie wyjœcia", "zintegrowane urz¹dzenie wejœcia", "zintegrowane urz¹dzenia peryferyjne", "urz¹dzenie wejœcia", 2));
		questions.add(new Question("Wybierz prawid³ow¹ odpowiedŸ:\n\nWould you ... for a drink?", "try", "like", "care", "check", 2));
		questions.add(new Question("Wybierz prawid³ow¹ odpowiedŸ:\n\nDo you live here? Yes, I ...", "am", "do", "does", "want", 1));
		questions.add(new Question("Wybierz prawid³ow¹ odpowiedŸ:\n\nShe ... him because he's boring", "doesn't like", "does like", "don't like", "try like", 0));
		questions.add(new Question("Wybierz prawid³ow¹ odpowiedŸ:\n\nI ... like Art.", "doesn't", "am not", "don't", "pear", 2));
		questions.add(new Question("Wybierz prawid³ow¹ odpowiedŸ:\n\n... lives ... a flat.", "He, on", "I, on", "He, in", "He, at", 0));
		questions.add(new Question("Wybierz prawid³ow¹ odpowiedŸ:\n\nWhere ... your grandparents live.","is","are","do","does",2));
		questions.add(new Question("Wybierz prawid³ow¹ odpowiedŸ:\n\nWhat ... your favourite color.","be","were","are","is",3));
		questions.add(new Question("Wybierz prawid³ow¹ odpowiedŸ:\n\nMy father is ... Actor.","the","a","an","en",2));
		questions.add(new Question("Wybierz prawid³ow¹ odpowiedŸ:\n\nMy mother is ... Doctor.","the","a","an","en",1));
		questions.add(new Question("Wybierz prawid³ow¹ odpowiedŸ:\n\n... Mississippi River is the chief river of the largest drainage system on the North American continent.","A","En","The","An",1));
		questions.add(new Question("Wybierz prawid³ow¹ odpowiedŸ:\n\nWhat's the waether ... today?","like","look","seems","looks",0));
		questions.add(new Question("Wybierz prawid³ow¹ odpowiedŸ:\n\nCan i get to our school ... car from here?","with","throught","by","on",2));
		questions.add(new Question("Odpowiedz na pytanie:\n\nHow many good answers are below this question? ","three","two","one","four",2));
		questions.add(new Question("Przet³umacz:\n\nI really like apples, pears and chocolate", "Bardzo lubiê jab³ka, gruszki i czekoladê", "Bardzo lubiê jab³ka, per³y i czekoladê", "Bardzo lubiê jab³ka, per³y i warzywa", "Bardzo lubiê jab³ka, s³odycze i warzywa", 0));
		questions.add(new Question("Przet³umacz:\n\nI hate arrogant people but I also understand shy people.", "Nienawidzê aroganckich ludzi, ale te¿ rozumiem dobrych ludzi", "Nienawidzê aroganckich ludzi, ale te¿ rozumiem nieœmia³ych ludzi", "Nienawidzê z³ych ludzi", "Zdanie jest niepoprawne.", 1));
		questions.add(new Question("Przet³umacz:\n\nI hate chocolade", "Nienawidzê czekolady", "Nienawidzê s³odyczy", "Nienawidzê owoców", "Zdanie jest niepoprawne", 3));
		questions.add(new Question("Przet³umacz:\n\nI love chocolate", "Kocham czekoladê", "Kocham s³odycze", "Kocham owoce", "Zdanie jest niepoprawne", 0));
		questions.add(new Question("Przet³umacz:\n\nI am tired of waiting!", "Jestem wkurzony czekaniem!", "Jestem zmêczony czekaniem!", "Jestem wyczerpany czekaniem!", "Zdanie jest niepoprawne!", 1));
		questions.add(new Question("Przet³umacz:\n\nI am exhausted!", "Jestem wkurzony!", "Jestem zmêczony!", "Jestem wyczerpany!", "Zdanie jest niepoprawne!", 2));
		questions.add(new Question("Przet³umacz:\n\nI really miss you!", "Naprawdê teskniê za tob¹", "Naprawdê ciê kocham", "Naprawdê czekam na ciebie!", "Nie trafi³em na ciebie!", 0));
		
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
