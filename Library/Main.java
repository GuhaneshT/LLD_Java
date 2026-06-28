package Library;

public class Main {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();

        library.addReader("Alice");
        library.addReader("Bob");

        library.listBooks();
        library.borrowBook("winter", "Alice");
        library.listReaders();
        library.returnBook("winter", "Alice");
        library.listReaders();
        library.listBooks();
    }
}
