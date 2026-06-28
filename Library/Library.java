package Library;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
    public List<Book> allBooks = new ArrayList<>();
    public List<Reader> readers = new ArrayList<>();
    public HashMap<Book,Reader> borrowedMap = new HashMap<>();

    public Library(List<Book> books){
        this.allBooks = books;
    }

    public void borrowBook(Book book,Reader reader,Date currDate){
        if (book == null || reader == null) {
            System.out.println("Book or reader not found");
            return;
        }
        if (!book.ifAvailable()) {
            System.out.println("Book is already borrowed");
            return;
        }
        borrowedMap.put(book,reader);
        book.borrowBook(currDate, reader);
        reader.recordBorrow(book);

    }

    public Book findBook(String bookName){
        //tbi
        for(Book book : allBooks){
            if(book.name.equals(bookName)){
                return book;
            }
        }
        return null;

    }

    public Reader findReader(String readerName){
        for( Reader reader : this.readers){
            if(reader.name.equals(readerName)){
                return reader;
            }
        }
        return null;
    }


    public long returnBook(Book book, Reader reader,Date currDate){
        if (book == null || reader == null) {
            System.out.println("Book or reader not found");
            return 0L;
        }
        if (book.ifAvailable()) {
            System.out.println("Book is not currently borrowed");
            return 0L;
        }
        Reader actualReader = borrowedMap.get(book);
        if (actualReader != reader) {
            System.out.println("This reader did not borrow the book");
            return 0L;
        }
        borrowedMap.remove(book);
        long fineAmt = book.returnBook(currDate);
        reader.due += fineAmt;
        reader.recordReturn(book);
        return fineAmt;



    }
    
    
}
