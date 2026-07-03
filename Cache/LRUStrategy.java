package Cache;

import java.util.LinkedList;

public class LRUStrategy extends Strategy {
    
    private final LinkedList<String> usedList = new LinkedList<>();
    
    public void record(String key) {
        usedList.remove(key);
        usedList.addLast(key);
    }
        
    public String evictKey() {
        if (usedList.isEmpty()) {
            return null;
        }
        return usedList.removeFirst();
    }
}
