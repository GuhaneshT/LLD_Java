package Library;
import java.util.*;

public class Reader {
    public String name;
    public long due;
    
    public List<Book> booksBorrowed = new ArrayList<>();

    public Reader(String name){
        this.name = name;
        this.due = 0L;
    }
    public void recordBorrow(Book book){
        this.booksBorrowed.add(book);
        //user copy of borrowed/loaned books

    }

    public void recordReturn(Book book){
        this.booksBorrowed.remove(book);
    }

    public long myDue(){
        return this.due;
    }
    
}
