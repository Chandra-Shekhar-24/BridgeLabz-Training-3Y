public class Book {
    private String title;
    private String author;
    private double price;

    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void display() {
        System.out.println("Book Title : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Price      : ₹" + price);
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {

        Book book1 = new Book();
        book1.display();

        Book book2 = new Book("Java Programming", "James Gosling", 499.99);
        book2.display();
    }
}
