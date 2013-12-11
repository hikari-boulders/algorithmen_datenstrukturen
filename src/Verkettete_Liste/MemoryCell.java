package Verkettete_Liste;

public class MemoryCell {

	String data;
	Integer next;

	public MemoryCell(String data, Integer next){
		// Zahlen werden als String abgelegt. Ich finde String simuliert die Daten besser als nur ein Zahlenwert
		this.data = data;
		this.next = next;
	}
	
	public String getData(){
		return data;
	}
	
	public Integer getNext(){
		return next;
	}
	
	public void setNext(Integer newnext){
		this.next = newnext;
	}
}
