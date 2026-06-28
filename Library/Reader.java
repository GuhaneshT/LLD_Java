package Library;
import java.util.*;

public class Reader {
    public String name;
    public long due;
    
    public List<BookCopy> booksBorrowed = new ArrayList<>();

    public Reader(String name){
        this.name = name;
        this.due = 0L;
    }
    public void recordBorrow(BookCopy bookCopy){
        this.booksBorrowed.add(bookCopy);
    }

    public void recordReturn(BookCopy bookCopy){
        this.booksBorrowed.remove(bookCopy);
    }

    public long myDue(){
        return this.due;
    }
    
}
