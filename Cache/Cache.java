package Cache;
import java.util.HashMap;
public class Cache {
    private HashMap<String, String> cacheMap;
    private int capacity;
    private CacheEvictionStrategy eviction;
    
    public Cache(int capacity,StrategyEnum strategy){
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.eviction = new CacheEvictionStrategy(strategy);


    }
    
    public String get(String key){
        if(!this.cacheMap.containsKey(key)){
            return null;
        }
        this.eviction.record(key);
        return this.cacheMap.get(key);

    }

    public void set(String key,String value){
        int currSize = this.size();
        if(this.cacheMap.containsKey(key)){
            //update
            this.cacheMap.put(key,value);
            this.eviction.record(key);
            return;
        }
        if(currSize + 1 > this.capacity){
            //need to evict
            this.cacheMap = this.eviction.evict(this.cacheMap);
        }
        this.cacheMap.put(key,value);
        this.eviction.record(key);

    }

    private int size(){
        return this.cacheMap.size();
    }
    
}
