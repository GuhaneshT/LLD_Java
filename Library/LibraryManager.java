package Library;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    public Library library;
    public LibraryManager(){
        Book book1 = new Book("winter","guhanesh",false);
        Book book2 = new Book("summer","thanagasamy",false);
        Book book3 = new Book("autumn","sumathi",false);

        

        List<Book> books = new ArrayList<>(List.of(book1, book2, book3));
       

        this.library = new Library(books);
    }

    public void listBooks(){
        for(Book book : this.library.allBooks){
            BookCopy copy = this.library.findAvailableCopy(book);
            boolean available = copy != null;
            System.out.println(book.name + " available status -  " + Boolean.toString(available));
        }
    }

    public void addReader(String Name){
        Reader reader = new Reader(Name);
        this.library.readers.add(reader);
    }

    public void listReaders(){
        for(Reader reader : this.library.readers){
            System.out.println(reader.name + " has the books " + reader.booksBorrowed.toString() + " and a total due of " + Long.toString(reader.myDue()));
        }
    }

    public void borrowBook(String bookName, String readerName){
        java.sql.Date currDate = new java.sql.Date(System.currentTimeMillis());
        Reader reader = this.library.findReader(readerName);
        Book book = this.library.findBook(bookName);
        this.library.borrowBook(book, reader, currDate);
    }

    public void returnBook(String bookName, String readerName){
        java.sql.Date currDate = new java.sql.Date(System.currentTimeMillis());
        Reader reader = this.library.findReader(readerName);
        Book book = this.library.findBook(bookName);

        long currFine = this.library.returnBook(book, reader, currDate);
        System.out.println("You have returned the book and have a fine of " + Long.toString(currFine) + " overall outstanding due :  " + Long.toString(reader.myDue()));


    }


}
