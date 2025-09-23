package OOPS50QUES;
class Applicant {
    private String name;
    private int creditScore;
    private double income;
    private double loanAmount;

    public Applicant(String name, int creditScore, double income, double loanAmount) {
        this.name = name;
        this.creditScore = creditScore;
        this.income = income;
        this.loanAmount = loanAmount;
    }

    public String getName() { return name; }
    public double getIncome() { return income; }
    public double getLoanAmount() { return loanAmount; }
    protected int getCreditScore() { return creditScore; }
}

interface IApprovable {
    boolean approveLoan(Applicant applicant);
    double calculateEMI();
}

abstract class LoanApplication implements IApprovable {
    private static int counter = 100;
    private final int applicationId;
    private String loanType;
    private int termMonths;
    private double interestRate;
    private Applicant applicant;
    private boolean approved;
    private double emi;

    public LoanApplication(String loanType, int termMonths, double interestRate, Applicant applicant) {
        this.applicationId = ++counter;
        this.loanType = loanType;
        this.termMonths = termMonths;
        this.interestRate = interestRate;
        this.applicant = applicant;
        this.approved = false;
        this.emi = 0;
    }

    @Override
    public boolean approveLoan(Applicant applicant) {
        if (applicant.getCreditScore() >= 650 && applicant.getIncome() > applicant.getLoanAmount() / termMonths) {
            approved = true;
            emi = calculateEMI();
        }
        return approved;
    }

    protected double calculateBaseEMI() {
        double P = applicant.getLoanAmount();
        double R = (interestRate / 12) / 100;
        int N = termMonths;
        return (P * R * Math.pow(1 + R, N)) / (Math.pow(1 + R, N) - 1);
    }

    @Override
    public double calculateEMI() {
        return calculateBaseEMI();
    }

    public void showApplicationDetails() {
        System.out.println("Application ID: " + applicationId + " | Loan Type: " + loanType);
        System.out.println("Applicant: " + applicant.getName() + " | Amount: ₹" + applicant.getLoanAmount());
        System.out.println("Term: " + termMonths + " months | Interest: " + interestRate + "%");
        if (approved) {
            System.out.println("Status: Approved ✅ | EMI: ₹" + String.format("%.2f", emi));
        } else {
            System.out.println("Status: Rejected ❌");
        }
    }
}

class HomeLoan extends LoanApplication {
    public HomeLoan(int termMonths, double interestRate, Applicant applicant) {
        super("Home Loan", termMonths, interestRate, applicant);
    }

    @Override
    public double calculateEMI() {
        return calculateBaseEMI() * 0.95; // 5% subsidy on EMI
    }
}

class AutoLoan extends LoanApplication {
    public AutoLoan(int termMonths, double interestRate, Applicant applicant) {
        super("Auto Loan", termMonths, interestRate, applicant);
    }

    @Override
    public double calculateEMI() {
        return calculateBaseEMI() * 1.05; // 5% higher EMI due to depreciation risk
    }
}

class PersonalLoan extends LoanApplication {
    public PersonalLoan(int termMonths, double interestRate, Applicant applicant) {
        super("Personal Loan", termMonths, interestRate, applicant);
    }

    @Override
    public double calculateEMI() {
        return calculateBaseEMI();
    }
}

public class LoanBuddyApp {
    public static void main(String[] args) {
        Applicant a1 = new Applicant("Riya Sharma", 720, 50000, 200000);
        Applicant a2 = new Applicant("Arjun Mehta", 600, 30000, 500000);

        LoanApplication homeLoan = new HomeLoan(120, 7.5, a1);
        LoanApplication autoLoan = new AutoLoan(60, 9.0, a2);
        LoanApplication personalLoan = new PersonalLoan(36, 12.0, a1);

        homeLoan.approveLoan(a1);
        autoLoan.approveLoan(a2);
        personalLoan.approveLoan(a1);

        homeLoan.showApplicationDetails();
        System.out.println();
        autoLoan.showApplicationDetails();
        System.out.println();
        personalLoan.showApplicationDetails();
    }
}
