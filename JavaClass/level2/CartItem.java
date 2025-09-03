
public class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Add item
    public void addItem(int qty) {
        this.quantity += qty;
        System.out.println("Added " + qty + " of " + itemName);
    }

    // Remove item
    public void removeItem(int qty) {
        if (qty > quantity) {
            System.out.println("❌ Cannot remove " + qty + " (only " + quantity + " left)");
        } else {
            this.quantity -= qty;
            System.out.println("Removed " + qty + " of " + itemName);
        }
    }

    // Total cost
    public double totalCost() {
        return price * quantity;
    }

    // Display item
    public void displayItem() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Qty: " + quantity);
    }

    public static void main(String[] args) {
        CartItem item = new CartItem("Laptop", 999.99, 1);
        item.displayItem();

        item.addItem(2);
        item.removeItem(1);

        System.out.println("Total Cost: $" + item.totalCost());
    }
}