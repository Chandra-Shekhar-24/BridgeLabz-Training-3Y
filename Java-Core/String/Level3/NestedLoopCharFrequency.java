import java.util.Scanner;

public class NestedLoopCharFrequency {

    static String[] charFreq(String text) {
        char[] chars = text.toCharArray();
        int len = chars.length;
        int[] freq = new int[len];
        for(int i=0; i<len; i++) freq[i] = 1;
        for(int i=0; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                if(chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = 0; // mark as counted
                }
            }
        }

        int count = 0;
        for(int i=0; i<len; i++) {
            if(chars[i] != 0) count++;
        }

        String[] result = new String[count];
        int idx = 0;
        for(int i=0; i<len; i++) {
            if(chars[i] != 0) {
                result[idx++] = chars[i] + " : " + freq[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.nextLine();
        String[] freqList = charFreq(text);
        System.out.println("Char : Frequency");
        for(String s : freqList) System.out.println(s);
        sc.close();
    }
}
