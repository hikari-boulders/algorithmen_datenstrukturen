package Verkettete_Liste;

import java.util.HashMap;

public class Memory {

	/* Die Idee des memory: Simulation der Speicherzellen z.B RAM!
	 * Die HashMap dient nur als ansteuerung von Speicheradressen. Auf diesem Speicherslot befindet sich 
	 * a) die Daten und b) der Pointer auf die näcshte Speicheradresse
	 * ______________________
	 * |512	|Object 1 -> 513|
	 * ----------------------
	 * |513	|Object 1 -> 612|
	 * ----------------------
	 * |514	|Object 1 -> 513| <-- So können einfach die verketteten Lsiten realistischer simuliert werden.
	 * ----------------------
	 * |612	|Object 1 -> 650|
	 * ----------------------
	 */
	
	private HashMap<Integer,MemoryCell> memory = new HashMap<Integer,MemoryCell>();
	private Integer addr = 0;
	
	

	/**
	 * Speicherung von neuen Daten in die Speicherzelle
	 * 
	 * @param data als Speicherzelle
	 * @return Nummer der Speicherzelle
	 */
	public Integer saveDataToMemory(MemoryCell data){
		memory.put(getAddr(),data);
		return addr;
	}
	
	
	/**
	 * Überschreiben von bestehenden Speicherzellen
	 * 
	 * @param addr Speicheradresse welche überschrieben werden soll
	 * @param data von Typ Speicherzelle
	 */
	public void overwriteDataInMemory(Integer addr, MemoryCell data){
		if(addr <= this.addr){
			memory.put(addr,data);
		}
	}
	
	/**
	 * Liest die Speicherzelle aus
	 * @param addr als Integer
	 * @return den Memory Inhalt
	 */
	public void deleteDatafromMemory(Integer addr){
			 //memory.remove(addr);
		memory.put(addr, null);
	}
	
	/**
	 * Liest die Speicherzelle aus
	 * @param addr als Integer
	 * @return den Memory Inhalt
	 */
	public MemoryCell getDatafromMemory(Integer addr){
		if(addr >= addr){
			return memory.get(addr);
		}
		return null;
	}
	
	
	/**
	 * Interner Speicherzähler
	 * @return speicherstelle
	 */
	private Integer getAddr(){
		// Das Memory besitzt Speicherzellen. Beginnend ab 1.
		this.addr = addr + 1;
		return this.addr;
	}
	
	/**
	 * Gibt den gesamten Inhalt des Memory's raus.... für debug.
	 * @return
	 */
	public void getMemoryDump(){
		
		System.out.println("|===============|===============|===========|");
		System.out.println("|Adress         |Content        |Next       |");
		System.out.println("|===============|===============|===========|");
		
		for(int i = 1; i <= addr;i++){
			if(memory.get(i) instanceof MemoryCell){
			System.out.println("|" + i + "              |" + memory.get(i).getData() + "        |" +memory.get(i).getNext()+"        |");
			System.out.println("|===============|===============|===========|");
			} else {
				System.out.println("|" + i + "             | unknow/null  | null      |");
				System.out.println("|===============|===============|===========|");
			}
		}

	}
}
