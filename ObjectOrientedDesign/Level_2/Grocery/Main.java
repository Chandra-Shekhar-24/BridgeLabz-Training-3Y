public class Main {
    public static void main(String[] args) {
        // Create customer
        Customer alice = new Customer("Alice");

        // Add purchased products
        alice.addProduct(new Product("Apples", 2, 3));   // 2 kg @ $3
        alice.addProduct(new Product("Milk", 1, 2));     // 1 liter @ $2
        alice.addProduct(new Product("Bread", 1, 2.5));  // 1 loaf @ $2.5

        // Generate and print bill
        BillGenerator billGen = new BillGenerator();
        billGen.printBill(alice);
    }
}
