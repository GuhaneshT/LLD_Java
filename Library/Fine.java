package Library;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Fine {
    Book book;
    Reader reader;
    Date returnedDate;
    
    public Fine(Book book, Reader reader){
        this.book = book;
        this.reader = reader;
        
    }

    public long calculateFine(Date returnDate){
        LocalDate due = this.book.dueDate.toLocalDate();
        LocalDate returned = returnDate.toLocalDate();
        return Math.max(0, ChronoUnit.DAYS.between(due, returned));
        
    }
    
}
