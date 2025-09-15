import java.util.*;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

interface Discountable {
    double applyDiscount(double totalPrice);
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice * 0.9;
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount applied on Veg Item";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double serviceCharge = 50;
        return (getPrice() * getQuantity()) + serviceCharge;
    }

    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice * 0.95;
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount applied on Non-Veg Item (after service charge)";
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Butter Masala", 200, 2));
        order.add(new NonVegItem("Chicken Biryani", 300, 1));

        System.out.println("===== Online Food Delivery System =====\n");
        for (FoodItem item : order) {
            item.getItemDetails();
            double totalPrice = item.calculateTotalPrice();

            if (item instanceof Discountable) {
                Discountable discountable = (Discountable) item;
                double finalPrice = discountable.applyDiscount(totalPrice);
                System.out.println("Total Price: " + totalPrice);
                System.out.println(discountable.getDiscountDetails());
                System.out.println("Final Price after Discount: " + finalPrice);
            }
            System.out.println("-----------------------------------");
        }
    }
}
