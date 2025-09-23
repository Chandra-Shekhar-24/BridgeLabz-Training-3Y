package OOPS50QUES;

import java.util.ArrayList;
import java.util.List;

interface Transferrable {
    void transferTo(User receiver, double amount);
}

class Transaction {
    private String type;
    private double amount;
    private String details;

    public Transaction(String type, double amount, String details) {
        this.type = type;
        this.amount = amount;
        this.details = details;
    }

    @Override
    public String toString() {
        return type + ": " + amount + " (" + details + ")";
    }
}

abstract class Wallet implements Transferrable {
    private double balance;
    private List<Transaction> history;

    public Wallet(double initialBalance) {
        this.balance = initialBalance;
        this.history = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    protected void addMoney(double amount) {
        balance += amount;
        history.add(new Transaction("CREDIT", amount, "Money loaded"));
    }

    protected void deductMoney(double amount, String details) {
        balance -= amount;
        history.add(new Transaction("DEBIT", amount, details));
    }

    public void showHistory() {
        System.out.println("Transaction History:");
        for (Transaction t : history) {
            System.out.println(t);
        }
    }
}

class PersonalWallet extends Wallet {
    private static final double DAILY_LIMIT = 10000;

    public PersonalWallet(double initialBalance, boolean hasReferral) {
        super(initialBalance + (hasReferral ? 100 : 0)); // referral bonus
    }

    @Override
    public void transferTo(User receiver, double amount) {
        if (amount > DAILY_LIMIT) {
            System.out.println("Transfer failed: exceeds daily limit for Personal Wallet.");
            return;
        }
        if (amount > getBalance()) {
            System.out.println("Transfer failed: insufficient balance.");
            return;
        }
        deductMoney(amount, "Transfer to " + receiver.getName());
        receiver.getWallet().addMoney(amount);
        System.out.println("Transferred " + amount + " to " + receiver.getName());
    }
}

class BusinessWallet extends Wallet {
    private static final double TAX_RATE = 0.02; // 2% tax

    public BusinessWallet(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void transferTo(User receiver, double amount) {
        double totalAmount = amount + (amount * TAX_RATE);
        if (totalAmount > getBalance()) {
            System.out.println("Transfer failed: insufficient balance after tax.");
            return;
        }
        deductMoney(totalAmount, "Transfer (with tax) to " + receiver.getName());
        receiver.getWallet().addMoney(amount);
        System.out.println("Transferred " + amount + " to " + receiver.getName() + " (Tax deducted: " + (amount * TAX_RATE) + ")");
    }
}

class User {
    private String name;
    private Wallet wallet;

    public User(String name, Wallet wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }
}

public class EWalletApp {
    public static void main(String[] args) {
        User alice = new User("Alice", new PersonalWallet(500, true));
        User bob = new User("Bob", new PersonalWallet(1000, false));
        User shop = new User("Shop", new BusinessWallet(2000));

        System.out.println("Initial Balances:");
        System.out.println("Alice: " + alice.getWallet().getBalance());
        System.out.println("Bob: " + bob.getWallet().getBalance());
        System.out.println("Shop: " + shop.getWallet().getBalance());

        System.out.println("\nTransactions:");
        alice.getWallet().transferTo(bob, 200);
        bob.getWallet().transferTo(shop, 500);
        shop.getWallet().transferTo(alice, 300);

        System.out.println("\nFinal Balances:");
        System.out.println("Alice: " + alice.getWallet().getBalance());
        System.out.println("Bob: " + bob.getWallet().getBalance());
        System.out.println("Shop: " + shop.getWallet().getBalance());

        System.out.println("\nAlice's History:");
        alice.getWallet().showHistory();

        System.out.println("\nShop's History:");
        shop.getWallet().showHistory();
    }
}

