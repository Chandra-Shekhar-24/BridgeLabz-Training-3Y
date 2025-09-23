package OOPS50QUES;

abstract class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public Account(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    protected void depositAmount(double amount) {
        balance += amount;
    }

    protected boolean withdrawAmount(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    public abstract double calculateInterest();
}

interface ITransaction {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}

class SavingsAccount extends Account implements ITransaction {
    private static final double interestRate = 4.0;

    public SavingsAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public void deposit(double amount) {
        depositAmount(amount);
        System.out.println("Deposited ₹" + amount + " in Savings Account.");
    }

    @Override
    public void withdraw(double amount) {
        if (withdrawAmount(amount)) {
            System.out.println("Withdrawn ₹" + amount + " from Savings Account.");
        } else {
            System.out.println("Insufficient Balance in Savings Account!");
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Savings Account Balance: ₹" + getBalance());
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

class CurrentAccount extends Account implements ITransaction {
    private static final double interestRate = 2.0;

    public CurrentAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public void deposit(double amount) {
        depositAmount(amount);
        System.out.println("Deposited ₹" + amount + " in Current Account.");
    }

    @Override
    public void withdraw(double amount) {
        if (withdrawAmount(amount)) {
            System.out.println("Withdrawn ₹" + amount + " from Current Account.");
        } else {
            System.out.println("Insufficient Balance in Current Account!");
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Current Account Balance: ₹" + getBalance());
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

public class MyBankApp {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SB-101", 5000);
        CurrentAccount ca = new CurrentAccount("CA-201", 20000);

        sa.deposit(2000);
        sa.withdraw(1000);
        sa.checkBalance();
        System.out.println("Savings Interest: ₹" + sa.calculateInterest());

        System.out.println();

        ca.deposit(5000);
        ca.withdraw(25000);
        ca.checkBalance();
        System.out.println("Current Interest: ₹" + ca.calculateInterest());
    }
}
