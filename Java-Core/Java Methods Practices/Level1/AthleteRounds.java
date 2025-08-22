import java.util.Scanner;

public class AthleteRounds {
    public static int calculateRounds(double side1, double side2, double side3, double targetDistance) {
        double perimeter = side1 + side2 + side3;
        return (int) Math.ceil(targetDistance / perimeter);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side 1 (m): ");
        double s1 = sc.nextDouble();
        System.out.print("Enter side 2 (m): ");
        double s2 = sc.nextDouble();
        System.out.print("Enter side 3 (m): ");
        double s3 = sc.nextDouble();

        int rounds = calculateRounds(s1, s2, s3, 5000);
        System.out.println("Number of rounds to complete 5km: " + rounds);
        sc.close();
    }
}
