package Library;

import java.util.List;

public class Catalog {
    public List<Book> books;

    public Catalog(List<Book> books) {
        this.books = books;
    }

    public Book findBook(String bookName) {
        for (Book book : books) {
            if (book.name.equals(bookName)) {
                return book;
            }
        }
        return null;
    }
}
