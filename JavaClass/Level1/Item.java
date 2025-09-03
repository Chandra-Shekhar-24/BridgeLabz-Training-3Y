
class Item {
    String code;
    String name;
    double price;

    // Constructor
    Item(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println("Item Code: " + code);
        System.out.println("Item Name: " + name);
        System.out.println("Item Price: " + price);
        System.out.println("-----------------");
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item("01AA", "Water Bottle", 500),
            new Item("01BB", "Rice", 700),
            new Item("02AA", "Blackboard", 400)
        };

        for (Item item : items) {
            item.display();
        }
    }
}