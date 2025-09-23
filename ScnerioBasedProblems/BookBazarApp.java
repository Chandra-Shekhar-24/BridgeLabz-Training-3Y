package OOPS50QUES;
import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}

interface IDiscountable {
    double applyDiscount();
}

abstract class Book implements IDiscountable {
    private String title;
    private String author;
    private double price;
    private int stock;

    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public boolean updateStock(int quantity) {
        if (stock >= quantity) {
            stock -= quantity;
            return true;
        }
        return false;
    }

    @Override
    public abstract double applyDiscount();
}

class EBook extends Book {
    public EBook(String title, String author, double price) {
        super(title, author, price, Integer.MAX_VALUE);
    }

    @Override
    public double applyDiscount() {
        return getPrice() * 0.85;
    }
}

class PrintedBook extends Book {
    public PrintedBook(String title, String author, double price, int stock) {
        super(title, author, price, stock);
    }

    @Override
    public double applyDiscount() {
        return getPrice() * 0.90;
    }
}

class Order {
    private static int counter = 100;
    private final int orderId;
    private User user;
    private List<Book> books;
    private List<Integer> quantities;
    private boolean completed;

    public Order(User user) {
        this.user = user;
        this.books = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.completed = false;
        this.orderId = ++counter;
    }

    public void addBook(Book book, int quantity) {
        if (book.updateStock(quantity)) {
            books.add(book);
            quantities.add(quantity);
        } else {
            System.out.println("Insufficient stock for " + book.getTitle());
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < books.size(); i++) {
            total += books.get(i).applyDiscount() * quantities.get(i);
        }
        return total;
    }

    public void completeOrder() {
        completed = true;
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId + " | User: " + user.getName());
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).getTitle() + " x " + quantities.get(i) +
                    " = ₹" + (books.get(i).applyDiscount() * quantities.get(i)));
        }
        System.out.println("Total: ₹" + calculateTotal());
        System.out.println("Status: " + (completed ? "Completed ✅" : "Pending ❌"));
    }
}

public class BookBazaarApp {
    public static void main(String[] args) {
        User user1 = new User("Aditi", "aditi@example.com");

        Book ebook1 = new EBook("Learn Java", "Ramesh", 500);
        Book pbook1 = new PrintedBook("Python Programming", "Suresh", 600, 5);

        Order order1 = new Order(user1);
        order1.addBook(ebook1, 1);
        order1.addBook(pbook1, 2);

        order1.showOrderDetails();
        System.out.println();

        order1.completeOrder();
        order1.showOrderDetails();
    }
}
