class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("------------------------");
    }
}

class EBook extends Book {
    private double fileSize;

    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    public void displayEBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
        System.out.println("File Size: " + fileSize + " MB");
        System.out.println("------------------------");
    }
}

public class BookLibrarySystem {
    public static void main(String[] args) {
        Book b1 = new Book("978-81-203-1234", "Java Programming", "James Gosling");
        EBook eb1 = new EBook("978-93-502-5678", "Advanced Java", "Herbert Schildt", 5.2);

        b1.displayBookDetails();
        eb1.displayEBookDetails();

        b1.setAuthor("Oracle Corporation");
        System.out.println("Updated Author of Book 1: " + b1.getAuthor());
    }
}
