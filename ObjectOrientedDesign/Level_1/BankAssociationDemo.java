import java.util.*;

class Customer {
    private String name;
    private double balance;
    public Customer(String name) { this.name = name; }
    public void deposit(double amount) { balance += amount; }
    public void viewBalance() { System.out.println(name + "'s Balance: " + balance); }
    public String getName() { return name; }
}

class Bank {
    private String bankName;
    private List<Customer> customers = new ArrayList<>();
    public Bank(String bankName) { this.bankName = bankName; }
    public void openAccount(Customer c, double initialDeposit) {
        customers.add(c);
        c.deposit(initialDeposit);
        System.out.println(c.getName() + " opened account in " + bankName + " with " + initialDeposit);
    }
}

public class BankAssociationDemo {
    public static void main(String[] args) {
        Bank bank = new Bank("SBI");
        Customer c1 = new Customer("Ravi");
        Customer c2 = new Customer("Neha");

        bank.openAccount(c1, 5000);
        bank.openAccount(c2, 8000);

        c1.viewBalance();
        c2.viewBalance();
    }
}
