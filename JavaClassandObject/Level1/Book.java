public class Book {
    String title;
    String author;
    double price;

    // Constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("-----------------");
    }

    public static void main(String[] args) {
        Book b1 = new Book("2 States", "Chetan Bhagat", 500);
        Book b2 = new Book("Wings of Fire", "A. P. J. Abdul Kalam", 600);

        b1.displayBookDetails();
        b2.displayBookDetails();
    }
}