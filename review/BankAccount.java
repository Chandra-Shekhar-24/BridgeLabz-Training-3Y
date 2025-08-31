public class BankAccount {
    private String accountNumber;
    private double balance;
    
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative. Setting to 0.");
        }
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            return true;
        } else {
            System.out.println("Insufficient funds or invalid amount.");
            return false;
        }
    }


    public double checkBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    
    public static void main(String[] args) {
        BankAccount account = new BankAccount("AC12345", 5000);

        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Opening Balance: " + account.checkBalance());

        account.deposit(2000);    
        account.withdraw(1000);    
        account.withdraw(7000);    

        System.out.println("Final Balance: " + account.checkBalance());
    }
}
