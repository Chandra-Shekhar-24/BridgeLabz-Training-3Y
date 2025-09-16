import java.util.*;

class Book {
    private String title;
    private String author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getDetails() {
        return title + " by " + author;
    }
}

class Library {
    private String name;
    private List<Book> books = new ArrayList<>();
    public Library(String name) { this.name = name; }
    public void addBook(Book book) { books.add(book); }
    public void showBooks() {
        System.out.println("Library: " + name);
        for (Book b : books) System.out.println(" - " + b.getDetails());
    }
}

public class LibraryAggregationDemo {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "James");
        Book b2 = new Book("OOP in Java", "Robert");

        Library lib1 = new Library("City Library");
        Library lib2 = new Library("College Library");

        lib1.addBook(b1);
        lib1.addBook(b2);
        lib2.addBook(b2); // same book in multiple libraries

        lib1.showBooks();
        lib2.showBooks();
    }
}
