import java.util.Scanner;

public class multiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] multiplicationResult = new int[4]; 

        System.out.println("\nMultiplication Table of " + number + ":");
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
            System.out.println(number + " * " + i + " = " + multiplicationResult[i - 6]);
        }
    }
}
