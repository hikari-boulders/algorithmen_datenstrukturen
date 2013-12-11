package Verkettete_Liste;

public class Start {

/**
 * Algorithmen und Datenstrukturen �bung 2 � Komplexit�t 1
 * 
 * Aufgabe 2 � Listen (LinkedList)
 * Aufgabe 3 � Menge (LinkedSet)
 * 
 * Die wohl einfaste Methode w�re gewesen, ein Klasse zu erstellen welche zwei Integers besitzt (DATA, NEXT).
 * 
 * Ich habe mich leider dagegen entschieden und wollte noch gerade einen Speicher simulieren, um festzustellen wie es einen Level weiter unten aussehen k�nnte.
 * Das ganze erwies sich als etwas zerm�rbend... es muss mehr beachtet werden, die komplexit�t steigt. Die Klassen werden un�bersichtlich...
 * 
 * Einfache funktionen wie Hashcode k�nnen nicht implementiert werden...
 * 
 * Ich habs aber dabei belassen und es nicht angepasst ;-)
 * 
 */
	
	/**
	 * 
	 * Einige ausf�hrbare Beispiele.
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
		
		System.out.println("ListSet gr�sse. " + LS1.getListSize());
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
		VKL1.add("f�ntes");
		
		LinkedList VKL3 = new LinkedList(speicher);
		VKL2.add("Schiff");
		
		VKL3.add("viertes");
		VKL3.add("drittes");
		VKL3.add("f�ntes");
		VKL3.add("erstes");
		VKL3.add("zweites");

		
		System.out.println("Verkettete Liste 1.......");
		System.out.println("Gr�sse der VKL1 Liste: "+ VKL1.getListSize());
		System.out.println("Suche nach 'f�ntes' in VKL1... "+ VKL1.search("f�ntes"));
		System.out.println("Suche nach 'n���' in VKL1... "+ VKL1.search("n���"));
		System.out.println("Erstes Element von VKL1: " + VKL1.getFirst().getData());
		System.out.println("Erstes Element von VKL1: " + VKL1.getLast().getData());
		System.out.println("Vergleichen VKL1 mit VKL3 (true): " + VKL3.compare(VKL1));
		VKL3.add("zweites");
		System.out.println("Vergleichen VKL1 mit VKL3 (false): " + VKL1.compare(VKL3));

		System.out.println();
		System.out.println("Gr�sse VKL3 VOR merge:" + VKL3.getListSize());
		System.out.println("Gr�sse VKL1 VOR merge:" + VKL1.getListSize());
		System.out.println("Gr�sse VKL1 nach merge:" + VKL1.getListSize());
		System.out.println("Gr�sse VKL3 nach merge:" + VKL3.getListSize());
		System.out.println("Die beiden Listen VKL1 und VKL3 vergleichen: " + VKL3.compare(VKL1));	
		
		System.out.println();
		System.out.println("Speicherabbild erstellen:");
		speicher.getMemoryDump();
	}

}
