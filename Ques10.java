import java.util.Scanner;

public class Ques10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your height in centimeters: ");
        double heightCm = sc.nextDouble();

        double cmPerInch = 2.54;
        int inchesPerFoot = 12;
        double totalInches = heightCm / cmPerInch;

        int feet = (int) (totalInches / inchesPerFoot);
        double inches = totalInches % inchesPerFoot;

        System.out.printf("Your Height in cm is %.2f while in feet is %d and inches is %.2f%n",
                          heightCm, feet, inches);

        sc.close();
    }
}
