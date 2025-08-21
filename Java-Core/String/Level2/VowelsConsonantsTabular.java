import java.util.Scanner;

public class VowelsConsonantsTabular {

    static String charType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch = (char) (ch + 32); // To lower
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                return "Vowel";
            else return "Consonant";
        } else return "Not a Letter";
    }

    static String[][] getTabular(String text) {
        int len = 0;
        try { while (true) { text.charAt(len); len++; } } catch (Exception e) {}
        String[][] arr = new String[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = String.valueOf(text.charAt(i));
            arr[i][1] = charType(text.charAt(i));
        }
        return arr;
    }

    static void displayTable(String[][] arr) {
        System.out.println("Char	Type");
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i][0] + "	" + arr[i][1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.nextLine();
        String[][] table = getTabular(text);
        displayTable(table);
        sc.close();
    }
}
