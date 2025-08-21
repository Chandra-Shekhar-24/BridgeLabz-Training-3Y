package Level2;

import java.util.Scanner;

public class BMICalculator {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            weight[i] = sc.nextDouble();
            System.out.print("Enter height (m) of person " + (i + 1) + ": ");
            height[i] = sc.nextDouble();

            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] <= 18.4)
                status[i] = "Underweight";
            else if (bmi[i] <= 24.9)
                status[i] = "Normal";
            else if (bmi[i] <= 39.9)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

        System.out.println("\nPerson\tWeight\tHeight\tBMI\t\tStatus");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%s\n", (i + 1), weight[i], height[i], bmi[i], status[i]);
        }
    }
}
