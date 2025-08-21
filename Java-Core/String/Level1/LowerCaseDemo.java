import java.util.Scanner;

public class LowerCaseDemo {

    public static String toLowerCaseCustom(String str){
        String result = "";
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + 32);
            }
            result += ch;
        }
        return result;
    }

    public static boolean compareWithCharAt(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String customLower = toLowerCaseCustom(text);
        String builtInLower = text.toLowerCase();

        System.out.println("Custom Lowercase: " + customLower);
        System.out.println("Built-in Lowercase: " + builtInLower);
        System.out.println("Are they same? " + compareWithCharAt(customLower, builtInLower));
        sc.close();
    }
}
