package Library;

import java.sql.Date;

public class Loan {
    public BookCopy bookCopy;
    public Reader reader;
    public Date issueDate;
    public Date dueDate;
    public Date returnDate;
    public Fine fine;

    public Loan(BookCopy bookCopy, Reader reader, Date issueDate) {
        this.bookCopy = bookCopy;
        this.reader = reader;
        this.issueDate = issueDate;
        this.dueDate = new Date(issueDate.getTime() + 7L * 24 * 60 * 60 * 1000);
        this.fine = new Fine(this, reader);
    }
}
