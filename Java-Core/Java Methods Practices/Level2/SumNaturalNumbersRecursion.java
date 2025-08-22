import java.util.Scanner;

public class SumNaturalNumbersRecursion {
    public static int sumRecursion(int n) {
        if(n == 1) return 1;
        return n + sumRecursion(n-1);
    }

    public static int sumFormula(int n) {
        return n*(n+1)/2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter natural number: ");
        int n = sc.nextInt();
        int sumRec = sumRecursion(n);
        int sumForm = sumFormula(n);
        System.out.println("Sum by recursion: " + sumRec);
        System.out.println("Sum by formula: " + sumForm);
        System.out.println("Both results are equal? " + (sumRec == sumForm));
        sc.close();
    }
}
