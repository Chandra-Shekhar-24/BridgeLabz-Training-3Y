public class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean availability;

    public LibraryBook() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        this.availability = true;
    }

    public LibraryBook(String title, String author, double price, boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    public void borrowBook() {
        if (availability) {
            System.out.println("You have successfully borrowed: " + title);
            availability = false;
        } else {
            System.out.println("Sorry, the book '" + title + "' is not available.");
        }
    }

    public void display() {
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Price       : ₹" + price);
        System.out.println("Available   : " + (availability ? "Yes" : "No"));
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        LibraryBook book1 = new LibraryBook("Java Programming", "James Gosling", 499.99, true);
        LibraryBook book2 = new LibraryBook("Python Basics", "Guido van Rossum", 399.99, false);

        System.out.println("Book Details:");
        book1.display();
        book2.display();

        System.out.println("Borrowing Attempt:");
        book1.borrowBook();
        book1.display();

        book2.borrowBook();
        book2.display();
    }
}
