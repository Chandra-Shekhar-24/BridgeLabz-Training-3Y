import java.util.Scanner;

public class CheckNumberSign {
    public static int checkSign(int number) {
        if(number > 0) return 1;
        else if(number < 0) return -1;
        else return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        int res = checkSign(num);
        if(res == 1) System.out.println("Positive number");
        else if(res == -1) System.out.println("Negative number");
        else System.out.println("Zero");
        sc.close();
    }
}
