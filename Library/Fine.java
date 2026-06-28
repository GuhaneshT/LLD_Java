package Library;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Fine {
    Loan loan;
    Reader reader;
    Date returnedDate;
    
    public Fine(Loan loan, Reader reader){
        this.loan = loan;
        this.reader = reader;
        
    }

    public long calculateFine(Date returnDate){
        LocalDate due = this.loan.dueDate.toLocalDate();
        LocalDate returned = returnDate.toLocalDate();
        return Math.max(0, ChronoUnit.DAYS.between(due, returned));
        
    }
    
}
