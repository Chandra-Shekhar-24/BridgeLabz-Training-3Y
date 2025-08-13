package Assignment2.Level2;

import java.util.Scanner;

public class Ques4 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = sc.nextDouble();


        double feetPerYard = 3.0;
        double yardsPerMile = 1760.0;

        double distanceInYards = distanceInFeet / feetPerYard;
        double distanceInMiles = distanceInYards / yardsPerMile;


        System.out.printf("The distance in yards is %.2f while the distance in miles is %.4f%n",
                          distanceInYards, distanceInMiles);

        sc.close();
    }
}
