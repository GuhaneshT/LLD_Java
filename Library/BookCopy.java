package Library;

public class BookCopy {
    public String copyId;
    public Book book;
    public boolean borrowed;

    public BookCopy(String copyId, Book book) {
        this.copyId = copyId;
        this.book = book;
        this.borrowed = false;
    }

    @Override
    public String toString() {
        return book.name + "(" + copyId + ")";
    }
}
