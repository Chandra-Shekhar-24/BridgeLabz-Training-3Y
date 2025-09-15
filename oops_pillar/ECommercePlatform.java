import java.util.*;
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Base Price: " + price);
    }
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    private double warrantyYears;

    public Electronics(int productId, String name, double price, double warrantyYears) {
        super(productId, name, price);
        this.warrantyYears = warrantyYears;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; 
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; 
    }

    @Override
    public String getTaxDetails() {
        return "18% GST applied for Electronics";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Category: Electronics");
        System.out.println("Warranty: " + warrantyYears + " years");
    }
}

class Clothing extends Product implements Taxable {
    private String size;

    public Clothing(int productId, String name, double price, String size) {
        super(productId, name, price);
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; 
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; 
    }

    @Override
    public String getTaxDetails() {
        return "5% GST applied for Clothing";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Category: Clothing");
        System.out.println("Size: " + size);
    }
}

class Groceries extends Product {
    private double weightKg;

    public Groceries(int productId, String name, double price, double weightKg) {
        super(productId, name, price);
        this.weightKg = weightKg;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; 
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Category: Groceries");
        System.out.println("Weight: " + weightKg + " kg");
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        Product p1 = new Electronics(201, "Laptop", 60000, 2);
        Product p2 = new Clothing(202, "T-Shirt", 1500, "L");
        Product p3 = new Groceries(203, "Rice Bag", 1200, 10);

        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);

        System.out.println("===== E-Commerce Platform =====\n");
        for (Product p : products) {
            p.displayDetails();
            double discount = p.calculateDiscount();
            double tax = 0;
            String taxDetails = "No tax applicable";

            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
                taxDetails = ((Taxable) p).getTaxDetails();
            }

            double finalPrice = p.getPrice() + tax - discount;
            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax + " (" + taxDetails + ")");
            System.out.println("Final Price: " + finalPrice);
            System.out.println("-----------------------------------");
        }
    }
}
