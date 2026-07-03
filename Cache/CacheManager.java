package Cache;

public class CacheManager {

    private Cache cache;
    

    public CacheManager(int capacity,StrategyEnum strategy){
        this.cache = new Cache(capacity,strategy);
        
        
    }
    
    public String get(String key){
        return this.cache.get(key);

    }

    public void set(String key,String value){
        this.cache.set(key,value);
    }


    
}
