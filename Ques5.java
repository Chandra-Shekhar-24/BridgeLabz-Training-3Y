package Assignment2.Level2;

import java.util.Scanner;

public class Ques5 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        System.out.print("Enter the unit price of the item (INR): ");
        double unitPrice = sc.nextDouble();

        System.out.print("Enter the quantity to be bought: ");
        int quantity = sc.nextInt();

        double totalPrice = unitPrice * quantity;

        System.out.printf("The total purchase price is INR %.2f if the quantity %d and unit price is INR %.2f%n",
                          totalPrice, quantity, unitPrice);

        sc.close();
    }
}
