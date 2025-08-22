import java.util.Scanner;

public class PositiveNegativeEvenOdd {
    public static boolean isPositive(int n) { return n >= 0; }
    public static boolean isEven(int n) { return n % 2 == 0; }
    public static int compare(int n1, int n2) {
        if(n1 > n2) return 1;
        else if(n1 == n2) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for(int i=0; i<5; i++) {
            System.out.print("Enter number " + (i+1) + ": ");
            arr[i] = sc.nextInt();
        }
        for(int num : arr) {
            if(isPositive(num)) {
                System.out.print(num + " is positive and ");
                if(isEven(num)) System.out.println("even.");
                else System.out.println("odd.");
            } else {
                System.out.println(num + " is negative.");
            }
        }
        int res = compare(arr[0], arr[arr.length-1]);
        String compStr = res == 1 ? "greater than" : res == 0 ? "equal to" : "less than";
        System.out.println("The first element is " + compStr + " the last element.");
        sc.close();
    }
}
