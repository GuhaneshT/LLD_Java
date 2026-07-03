package Cache;

public class Main {

    public static void main(String[] args) {
        CacheManager cacheManager = new CacheManager(3, StrategyEnum.LRU);
        cacheManager.set("key1", "value1");
        cacheManager.set("key2", "value2");
        cacheManager.set("key3", "value3");
        
        System.out.println(cacheManager.get("key1")); 
        
        cacheManager.set("key4", "value4"); 
        
        System.out.println(cacheManager.get("key2")); 
    }
    
}
