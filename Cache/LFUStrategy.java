package Cache;

import java.util.HashMap;

public class LFUStrategy extends Strategy{

    private final HashMap<String, Integer> keyFreq = new HashMap<>();

    public void record(String key) {
        keyFreq.put(key, keyFreq.getOrDefault(key, 0) + 1);
    }

    public String evictKey() {
        String keyToRemove = null;
        int minFreq = Integer.MAX_VALUE;

        for (var entry : keyFreq.entrySet()) {
            if (entry.getValue() < minFreq) {
                minFreq = entry.getValue();
                keyToRemove = entry.getKey();
            }
        }

        if (keyToRemove != null) {
            keyFreq.remove(keyToRemove);
        }
        return keyToRemove;
    }
}
