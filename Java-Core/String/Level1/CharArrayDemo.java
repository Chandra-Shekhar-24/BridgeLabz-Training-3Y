import java.util.Scanner;

public class CharArrayDemo {

    // Method to get characters manually
    public static char[] getCharArray(String str) {
        char[] arr = new char[str.length()];
        for(int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    // Compare two arrays
    public static boolean compareArrays(char[] a1, char[] a2) {
        if(a1.length != a2.length) return false;
        for(int i = 0; i < a1.length; i++) {
            if(a1[i] != a2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.next();

        char[] arr1 = getCharArray(text);
        char[] arr2 = text.toCharArray();

        System.out.println("Both arrays are equal? " + compareArrays(arr1, arr2));
        sc.close();
    }
}
