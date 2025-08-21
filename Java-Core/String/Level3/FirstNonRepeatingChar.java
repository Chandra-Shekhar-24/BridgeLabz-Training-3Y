import java.util.Scanner;

public class FirstNonRepeatingChar {
    static char firstNonRepeating(String text) {
        int[] freq = new int[256];
        int len = text.length();
        for (int i = 0; i < len; i++) {
            freq[(int) text.charAt(i)]++;
        }
        for (int i = 0; i < len; i++) {
            if(freq[(int) text.charAt(i)] == 1) return text.charAt(i);
        }
        return '#';  // no non-repeating char
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        char result = firstNonRepeating(text);
        if(result == '#')
            System.out.println("No non-repeating character found.");
        else
            System.out.println("First non-repeating character: " + result);
        sc.close();
    }
}
