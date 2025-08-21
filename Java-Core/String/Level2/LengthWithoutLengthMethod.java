import java.util.Scanner;

public class LengthWithoutLengthMethod {
    static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // Index out of bounds
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = sc.next();
        int lenUser = getLength(str);
        int lenBuiltIn = str.length();
        System.out.println("User Length: " + lenUser);
        System.out.println("Built-in Length: " + lenBuiltIn);
        sc.close();
    }
}
