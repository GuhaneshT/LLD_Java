package Cache;

abstract public class Strategy {

    abstract public void record(String key);
    abstract public String evictKey();
    
}
