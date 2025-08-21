package Level2;

import java.util.Scanner;

public class BMICalculator2D {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[][] personData = new double[n][3]; 
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            double w = sc.nextDouble();
            System.out.print("Enter height (m) of person " + (i + 1) + ": ");
            double h = sc.nextDouble();

            if (w <= 0 || h <= 0) { 
                System.out.println("Invalid input, try again!");
                i--; 
                continue;
            }

            double bmi = w / (h * h);
            personData[i][0] = w;
            personData[i][1] = h;
            personData[i][2] = bmi;

            if (bmi <= 18.4) status[i] = "Underweight";
            else if (bmi <= 24.9) status[i] = "Normal";
            else if (bmi <= 39.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        System.out.println("\nWeight\tHeight\tBMI\t\tStatus");
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s\n", 
                personData[i][0], personData[i][1], personData[i][2], status[i]);
        }
    }
}
