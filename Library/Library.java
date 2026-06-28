package Library;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Library {
    public List<Book> allBooks = new ArrayList<>();
    public List<BookCopy> allCopies = new ArrayList<>();
    public List<Reader> readers = new ArrayList<>();
    public List<Loan> activeLoans = new ArrayList<>();
    public Catalog catalog;

    public Library(List<Book> books){
        this.allBooks = books;
        this.catalog = new Catalog(books);
        for (int i = 0; i < books.size(); i++) {
            this.allCopies.add(new BookCopy("COPY-" + (i + 1), books.get(i)));
        }
    }

    public void borrowBook(Book book,Reader reader,Date currDate){
        if (book == null || reader == null) {
            System.out.println("Book or reader not found");
            return;
        }
        BookCopy availableCopy = findAvailableCopy(book);
        if (availableCopy == null) {
            System.out.println("No available copy for the book");
            return;
        }
        Loan loan = new Loan(availableCopy, reader, currDate);
        activeLoans.add(loan);
        availableCopy.borrowed = true;
        reader.recordBorrow(availableCopy);

    }

    public Book findBook(String bookName){
        return this.catalog.findBook(bookName);
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
        Loan loan = findActiveLoan(book, reader);
        if (loan == null) {
            System.out.println("This reader does not have an active loan for the book");
            System.out.println("This reader did not borrow the book");
            return 0L;
        }
        activeLoans.remove(loan);
        loan.bookCopy.borrowed = false;
        loan.returnDate = currDate;
        long fineAmt = loan.fine.calculateFine(currDate);
        reader.due += fineAmt;
        reader.recordReturn(loan.bookCopy);
        return fineAmt;



    }

    public BookCopy findAvailableCopy(Book book) {
        for (BookCopy copy : allCopies) {
            if (copy.book == book && !copy.borrowed) {
                return copy;
            }
        }
        return null;
    }

    public Loan findActiveLoan(Book book, Reader reader) {
        for (Loan loan : activeLoans) {
            if (loan.bookCopy.book == book && loan.reader == reader) {
                return loan;
            }
        }
        return null;
    }
    
    
}
