import java.util.Scanner;

public class NumberFormatDemo {

    public static void generateException(String text){
        int num = Integer.parseInt(text); // invalid input -> Exception
        System.out.println("Number: " + num);
    }

    public static void handleException(String text){
        try {
            int num = Integer.parseInt(text);
            System.out.println("Number: " + num);
        } catch(NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e);
        } catch(Exception e){
            System.out.println("Caught Exception: " + e);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number as string: ");
        String text = sc.next();
        // generateException(text);
        handleException(text);
        sc.close();
    }
}
