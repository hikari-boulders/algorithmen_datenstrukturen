package Verkettete_Liste;

public class LinkedSet extends  LinkedList {

	
	public LinkedSet(Memory speicher) {
		super(speicher);
	}
	
	/**
	 * Zwei listen zusammenfügen. Dabei wird der Header auf die gleiche Position verwiesen.
	 * @param LinkedSet
	 */
	public void mergeList(LinkedList LinkedSet) {
		getLast().setNext(LinkedSet.searchPosition(LinkedSet.getFirst().getData()));
		LinkedSet.setNewHeader(header, LinkedSet);
	}
	
	
	
    /**
     * Ausgabe von diesem SET als Strings
     */
    public String toString() {
    		mc = getFirst();
    
            String string = "{";

            while (mc.getNext() != 0) {

            	string += mc.getData() + ";";
    			mc = speicher.getDatafromMemory(mc.getNext());
            }
            string += mc.getData();

            string += "}";
            
            return string;
    }
    
    
    /**
     * Eine andere Menge wegschneiden
     */
    
    public void slice(LinkedSet set) {
    	mc = getFirst();
    	MemoryCell mcset = set.getFirst();
    	
        if (mc.getNext() == 0){
                return;
        }
        
        while (mcset.getNext() != 0) {
                if (search(mcset.getData()) == false) {
                        remove(mcset.getData());
                }
                mcset = speicher.getDatafromMemory(mcset.getNext());
        }
        
        if (search(mcset.getData()) == false) {
            remove(mcset.getData());
        }

}

}
