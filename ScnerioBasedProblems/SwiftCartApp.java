package OOPS50QUES;
import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;
    private String category;
    private int quantity;

    public Product(String name, double price, String category, int quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getQuantity() { return quantity; }

    public double getTotalPrice() {
        return price * quantity;
    }

    public double applyDiscount() {
        return getTotalPrice();
    }
}

class PerishableProduct extends Product {
    public PerishableProduct(String name, double price, int quantity) {
        super(name, price, "Perishable", quantity);
    }

    @Override
    public double applyDiscount() {
        return getTotalPrice() * 0.90;
    }
}

class NonPerishableProduct extends Product {
    public NonPerishableProduct(String name, double price, int quantity) {
        super(name, price, "Non-Perishable", quantity);
    }

    @Override
    public double applyDiscount() {
        return getTotalPrice() * 0.95;
    }
}

interface ICheckout {
    void generateBill();
    void applyDiscount(double coupon);
}

class Cart implements ICheckout {
    private List<Product> products;
    private double totalPrice;

    public Cart() {
        this.products = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public Cart(List<Product> products) {
        this.products = products;
        calculateTotal();
    }

    public void addProduct(Product p) {
        products.add(p);
        calculateTotal();
    }

    private void calculateTotal() {
        totalPrice = 0.0;
        for (Product p : products) {
            totalPrice += p.getTotalPrice();
        }
    }

    @Override
    public void generateBill() {
        System.out.println("----- SwiftCart Bill -----");
        for (Product p : products) {
            System.out.println(p.getName() + " (" + p.getCategory() + ") x " + p.getQuantity() +
                    " = ₹" + p.getTotalPrice());
        }
        System.out.println("Total (before discount): ₹" + totalPrice);
    }

    @Override
    public void applyDiscount(double coupon) {
        double discountedTotal = 0.0;
        for (Product p : products) {
            discountedTotal += p.applyDiscount();
        }
        discountedTotal -= coupon;
        if (discountedTotal < 0) discountedTotal = 0;
        System.out.println("Total (after discounts & coupon ₹" + coupon + "): ₹" + discountedTotal);
    }
}

public class SwiftCartApp {
    public static void main(String[] args) {
        Product milk = new PerishableProduct("Milk", 50, 2);
        Product bread = new PerishableProduct("Bread", 30, 3);
        Product soap = new NonPerishableProduct("Soap", 40, 4);

        Cart cart = new Cart();
        cart.addProduct(milk);
        cart.addProduct(bread);
        cart.addProduct(soap);

        cart.generateBill();
        cart.applyDiscount(20);
    }
}
