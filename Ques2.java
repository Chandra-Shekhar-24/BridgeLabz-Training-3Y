package Assignment2.Level2;

import java.util.Scanner;

public class Ques2 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the base of the triangle (in cm): ");
        double baseCm = sc.nextDouble();

        System.out.print("Enter the height of the triangle (in cm): ");
        double heightCm = sc.nextDouble();

        double areaCm = 0.5 * baseCm * heightCm;

        double cmPerInch = 2.54;

        double areaInches = areaCm / (cmPerInch * cmPerInch);


        System.out.printf("The Area of the triangle in sq in is %.2f and sq cm is %.2f%n",
                          areaInches, areaCm);

        sc.close();
    }
}
