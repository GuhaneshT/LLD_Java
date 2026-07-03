package Cache;

import java.util.HashMap;

public class CacheEvictionStrategy {
    
    private Strategy strategy;

    public CacheEvictionStrategy(StrategyEnum strategy){
        if(strategy.equals(StrategyEnum.LFU)){
            this.strategy = new LFUStrategy();
        }
        else{
            this.strategy = new LRUStrategy();
        }
    }

    public HashMap<String, String> evict(HashMap<String, String> cacheMap){
        String keyToRemove = this.strategy.evictKey();
        if (keyToRemove != null) {
            cacheMap.remove(keyToRemove);
        }
        return cacheMap;
    }

    public void record(String key) {
        this.strategy.record(key);
    }
}
