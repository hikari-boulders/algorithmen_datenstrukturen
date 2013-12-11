package Verkettete_Liste;

public class Start {

/**
 * Algorithmen und Datenstrukturen Übung 2 – Komplexität 1
 * 
 * Aufgabe 2 – Listen (LinkedList)
 * Aufgabe 3 – Menge (LinkedSet)
 * 
 * Die wohl einfaste Methode wäre gewesen, ein Klasse zu erstellen welche zwei Integers besitzt (DATA, NEXT).
 * 
 * Ich habe mich leider dagegen entschieden und wollte noch gerade einen Speicher simulieren, um festzustellen wie es einen Level weiter unten aussehen könnte.
 * Das ganze erwies sich als etwas zermürbend... es muss mehr beachtet werden, die komplexität steigt. Die Klassen werden unübersichtlich...
 * 
 * Einfache funktionen wie Hashcode können nicht implementiert werden...
 * 
 * Ich habs aber dabei belassen und es nicht angepasst ;-)
 * 
 */
	
	/**
	 * 
	 * Einige ausführbare Beispiele.
	 * 
	 */
	public static void main(String[] args) {

		Memory speicher = new Memory();
		
		// Verkettete Liste anlegen
		LinkedList VKL1 = new LinkedList(speicher);
		LinkedList VKL2 = new LinkedList(speicher);

		// Set's erstellen
		LinkedSet LS1 = new LinkedSet(speicher);
		LinkedSet LS2 = new LinkedSet(speicher);
		
		LS1.add("Test");
		LS1.add("Test2222");
		LS1.remove("Test2222");
		
		System.out.println("ListSet grösse. " + LS1.getListSize());
		System.out.println("ListSet als String:" + LS1.toString());
		
		LS2.add("Test2222");
		LS1.slice(LS2);
		System.out.println("LS1 schnittmenge LS2: " + LS1.toString());
		
		
		VKL2.add("Velo");
		VKL2.add("Auto");
		
		VKL1.add("erstes");
		VKL1.add("zweites");
		VKL1.add("drittes");
		VKL1.add("viertes");
		VKL1.add("füntes");
		
		LinkedList VKL3 = new LinkedList(speicher);
		VKL2.add("Schiff");
		
		VKL3.add("viertes");
		VKL3.add("drittes");
		VKL3.add("füntes");
		VKL3.add("erstes");
		VKL3.add("zweites");

		
		System.out.println("Verkettete Liste 1.......");
		System.out.println("Grösse der VKL1 Liste: "+ VKL1.getListSize());
		System.out.println("Suche nach 'füntes' in VKL1... "+ VKL1.search("füntes"));
		System.out.println("Suche nach 'nööö' in VKL1... "+ VKL1.search("nööö"));
		System.out.println("Erstes Element von VKL1: " + VKL1.getFirst().getData());
		System.out.println("Erstes Element von VKL1: " + VKL1.getLast().getData());
		System.out.println("Vergleichen VKL1 mit VKL3 (true): " + VKL3.compare(VKL1));
		VKL3.add("zweites");
		System.out.println("Vergleichen VKL1 mit VKL3 (false): " + VKL1.compare(VKL3));

		System.out.println();
		System.out.println("Grösse VKL3 VOR merge:" + VKL3.getListSize());
		System.out.println("Grösse VKL1 VOR merge:" + VKL1.getListSize());
		System.out.println("Grösse VKL1 nach merge:" + VKL1.getListSize());
		System.out.println("Grösse VKL3 nach merge:" + VKL3.getListSize());
		System.out.println("Die beiden Listen VKL1 und VKL3 vergleichen: " + VKL3.compare(VKL1));	
		
		System.out.println();
		System.out.println("Speicherabbild erstellen:");
		speicher.getMemoryDump();
	}

}
