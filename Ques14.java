import java.util.Scanner;

public class Ques14 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = sc.nextDouble();

        double feetPerYard = 3.0;
        double yardsPerMile = 1760.0;

        double distanceInYards = distanceInFeet / feetPerYard;
        double distanceInMiles = distanceInYards / yardsPerMile;

        System.out.printf(
            "The distance in feet is %.2f, in yards is %.2f, and in miles is %.4f%n",
            distanceInFeet, distanceInYards, distanceInMiles
        );

        sc.close();
    }
}
