package Level2;

import java.util.Scanner;
public class EmployeeBonus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] salary = new double[10];
        double[] years = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalOld = 0, totalBonus = 0, totalNew = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Employee " + (i + 1));
            System.out.print("Salary: ");
            double sal = sc.nextDouble();
            System.out.print("Years of Service: ");
            double yos = sc.nextDouble();

            if (sal <= 0 || yos < 0) {
                System.out.println("Invalid input! Try again...");
                i--; 
                continue;
            }

            salary[i] = sal;
            years[i] = yos;
        }

        for (int i = 0; i < 10; i++) {
            bonus[i] = (years[i] > 5) ? salary[i] * 0.05 : salary[i] * 0.02;
            newSalary[i] = salary[i] + bonus[i];
            totalOld += salary[i];
            totalBonus += bonus[i];
            totalNew += newSalary[i];
        }

        System.out.println("\n--- Zara Bonus Report ---");
        System.out.println("Total Old Salary = " + totalOld);
        System.out.println("Total Bonus Payout = " + totalBonus);
        System.out.println("Total New Salary = " + totalNew);

    }
}