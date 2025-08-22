import java.util.Arrays;
public class OTPGeneratorQ_8 {
    public static int generateOTP() {
        return 100000 + (int)(Math.random() * 900000);
    }
    public static int[] generateOTPs(int count) {
        int[] otps = new int[count];
        for (int i = 0; i < count; i++) {
            otps[i] = generateOTP();
        }
        return otps;
    }
    public static boolean areUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false; 
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] otps = generateOTPs(10);
        System.out.println("Generated OTPs: " + Arrays.toString(otps));
        System.out.println("Are all OTPs unique? " + areUnique(otps));
    }
}