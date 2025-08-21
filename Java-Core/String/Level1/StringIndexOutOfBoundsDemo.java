import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    public static void generateException(String text){
        System.out.println(text.charAt(text.length()+1)); // invalid index
    }

    public static void handleException(String text){
        try {
            System.out.println(text.charAt(text.length()+1));
        } catch(StringIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.next();
        // generateException(text);
        handleException(text);
        sc.close();
    }
}
