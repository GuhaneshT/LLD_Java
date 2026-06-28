package Library;

public class Book {
    public String name;
    public String author;
    
    public Book(String name, String author, Boolean borrowed){
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
