package Library;

import java.sql.Date;

public class Book {
    public String name;
    public String author;
    public Boolean borrowed;
    public Date borrowedDate;
    public Date dueDate;

    public Fine fine;
    public Book(String name, String author, Boolean borrowed){
        this.name = name;
        this.author = author;
        this.borrowed = borrowed;
        
    }

    public Boolean ifAvailable(){
        return !this.borrowed;
    }

    public void borrowBook(Date currDate,Reader reader){
        this.borrowed = true;
        this.borrowedDate = currDate;
        this.dueDate = new Date(currDate.getTime() + 7L * 24 * 60 * 60 * 1000);
        this.fine = new Fine(this, reader);

    }
    public long returnBook(Date returnDate){
        if (!this.borrowed || this.fine == null) {
            return 0L;
        }
        long fineAmt = this.fine.calculateFine(returnDate);
        this.borrowed = false;
        this.borrowedDate = null;
        this.dueDate = null;
        this.fine = null;
        return fineAmt;


    }
}
