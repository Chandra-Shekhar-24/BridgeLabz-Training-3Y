class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + balance);
        System.out.println("------------------------");
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void displaySavingsDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + getBalance());
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("------------------------");
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("BA101", "Rahul Sharma", 50000);
        SavingsAccount s1 = new SavingsAccount("SA201", "Priya Verma", 75000, 5.5);

        b1.displayAccountDetails();
        s1.displaySavingsDetails();

        b1.deposit(10000);
        b1.withdraw(2000);
        System.out.println("Updated Balance of Rahul Sharma: ₹" + b1.getBalance());
    }
}
