// package level2;
public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Lynda", "123456789", 700);

        System.out.println("🏦 Welcome to State of Chennai Bank");
        acc.displayBalance();

        if (acc.deposit(200)) System.out.println("Deposited: 200");
        acc.displayBalance();

        if (acc.withdraw(100)) System.out.println("Withdrawn: 100");
        acc.displayBalance();

        if (!acc.withdraw(900)) System.out.println("❌ Insufficient Balance");
    }
}