package Verkettete_Liste;

public class LinkedList {

	MemoryCell mc;
	Memory speicher;
	Integer header; // Das erste Element der Verketteten Liste im Memory. Der
					// Wert ist die Speicherstelle im Memory!

	/**
	 * Initialisierung der LinkedList
	 * @param speicher
	 */
	public LinkedList(Memory speicher) {

		this.speicher = speicher;

		// Initialisierung HEAD
		if (header == null) {
			header = this.speicher.saveDataToMemory(new MemoryCell("%HEAD%", 0));
		}
	}

	/**
	 * Einfach ein neues Element hinzufügen (am ende der Liste)
	 * 
	 * @param Daten
	 */

	public void add(String data) {
		Integer newaddr = speicher.saveDataToMemory(new MemoryCell(data, 0));
		updateExistingElement(newaddr);
	}

	/**
	 * Fügt ein neues Element am Anfang der Liste ein
	 * @param Daten als string
	 */
	public void addFirst(String data) {

		Integer newaddr; // Speicherort der neuen Zelle
		newaddr = speicher.saveDataToMemory(new MemoryCell(data, 0));
		updateExistingElementFirst(newaddr);
	}
	
	public void remove(String data) {
	
		Integer addr = searchPosition(data); // zu löschende element suchen
		Integer newnext = speicher.getDatafromMemory(addr).getNext(); // Das next dieses Elements zwischenspeichern
		speicher.getDatafromMemory(searchElementbeforPosition(data)).setNext(newnext);// Das vorherige Element mit dem nachfolgenden verknüpfen
		speicher.deleteDatafromMemory(addr); //altes element entfernen
	}

	/**
	 * Überprüft, ob ein Datenobjekt in der Liste ist
	 * @param zu suchende Daten
	 * @return true or false
	 */
	public boolean search(String data) {

		MemoryCell mc = getFirst();
		int iteration = 0;
		
		do {
			if (mc.getData().equals(data)){
				return true;
			} else {
				mc = speicher.getDatafromMemory(mc.getNext());
			}
			iteration++;
		} while ( iteration < getListSize());

		return false;
	}
	


	/**
	 * Gibt die genaue Position eines Elementes im speicher an.
	 * @param data
	 * @return
	 * @throws NotFoundException
	 */
	public Integer searchPosition(String data){

		MemoryCell mc = getFirst();
		Integer position = speicher.getDatafromMemory(header).getNext();
		int iteration = 0;
		
		do {
			if (mc.getData().equals(data)){
				return position;
			} else {
				position = mc.getNext();
				mc = speicher.getDatafromMemory(mc.getNext());
			}
			iteration++;
		} while ( iteration < getListSize());

		return null;
	}
	
	
	
	/**
	 * Sucht das Elemt vor dem anderen heraus
	 * @param data
	 * @return
	 */
	private Integer searchElementbeforPosition(String data){

		MemoryCell mc = getFirst();
		Integer position = header;
		int iteration = 0;
		
		while ( iteration < getListSize()) {

			if (mc.getData().equals(data)){
				return position;
			} else {
				position = speicher.getDatafromMemory(position).getNext();
				mc = speicher.getDatafromMemory(mc.getNext());
			}
			
			iteration++;
		} 

		return null;
	}

	/**
	 * Automatische Anpassung der Reihenfolge der verketteten Elemente. Hier
	 * geht es darum den Pointer anzupassen.
	 * 
	 * @param addr
	 */
	private void updateExistingElement(Integer addr) {

		MemoryCell mc = speicher.getDatafromMemory(header);

		while (mc.getNext() != 0) {
			mc = speicher.getDatafromMemory(mc.getNext());
		}
		mc.setNext(addr);
	}

	/**
	 * Fügt ein neues Element am Anfang der Liste ein
	 * @param addr
	 */
	private void updateExistingElementFirst(Integer addr) {

		MemoryCell mc = speicher.getDatafromMemory(header);

		speicher.getDatafromMemory(addr).setNext(mc.getNext());
		mc.setNext(addr);
	}

	/**
	 * Zwei Listen vergleichen. Sind die gleichen Elemente vorhanden (reihenfolge ist egal) gibt es True zurück
	 * @param andere Linked List
	 * @return True or False
	 */
	public boolean compare(LinkedList otherlist) {

		MemoryCell mclistother = otherlist.getFirst();
		int iteration = 0;
		
		if(otherlist.getListSize() != getListSize()){return false;}
		
		do {
			if (search(mclistother.getData())) {
				mclistother = speicher.getDatafromMemory(mclistother.getNext());
			} else {
				return false;
			}
			iteration++;
		} while ( iteration < otherlist.getListSize());

		return true;

	}

	
	/**
	 * Grösse der LinkedList ausgeben
	 * 
	 * @return Integer grösse
	 */
	public Integer getListSize() {
		Integer size = 0;

		MemoryCell mc = speicher.getDatafromMemory(header);

		while (mc.getNext() != 0) {
			mc = speicher.getDatafromMemory(mc.getNext());
			size++;
		}
		return size;
	}
	

	/**
	 * Erstes Element der Liste ausgeben
	 * @return
	 */
	public MemoryCell getFirst() {

		MemoryCell mc = speicher.getDatafromMemory(header);

		if (mc.getNext() != 0) {
			return speicher.getDatafromMemory(mc.getNext());
		} else {
			return mc;
		}
	}

	/**
	 * Letztes Element der Liste ausgeben
	 * @return
	 */
	public MemoryCell getLast() {
		MemoryCell mc = speicher.getDatafromMemory(header);

		if (mc.getNext() != 0) {
			while (mc.getNext() != 0) {
				mc = speicher.getDatafromMemory(mc.getNext());
			}
			return mc;
		} else {
			return mc;
		}
	}
	
	/**
	 * Header der Liste neu setzen
	 * @param newposition
	 * @param otherlist
	 */
	protected void setNewHeader(Integer newposition, LinkedList otherlist){
		speicher.deleteDatafromMemory(otherlist.header);
		this.header = newposition;
	}

}
