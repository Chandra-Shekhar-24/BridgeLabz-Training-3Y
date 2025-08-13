import java.util.Scanner;

public class Ques12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base of triangle in inches: ");
        double baseInches = sc.nextDouble();

        System.out.print("Enter height of triangle in inches: ");
        double heightInches = sc.nextDouble();

        double areaInches = 0.5 * baseInches * heightInches;

        double baseCm = baseInches * 2.54;
        double heightCm = heightInches * 2.54;

        double areaCm = 0.5 * baseCm * heightCm;

        System.out.printf("The area of the triangle is %.2f square inches and %.2f square centimeters.%n",
                          areaInches, areaCm);

        sc.close();
    }    
}
