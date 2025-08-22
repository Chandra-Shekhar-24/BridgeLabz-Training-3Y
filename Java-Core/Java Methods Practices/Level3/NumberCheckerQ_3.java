public class NumberCheckerQ_3 {

    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static int[] getDigits(int number) {
        String numStr = String.valueOf(number);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static int sumOfSquares(int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, 2);
            number /= 10;
        }
        return sum;
    }

    public static boolean isHarshad(int number) {
        int sum = sumOfDigits(number);
        return number % sum == 0;
    }

    public static int[][] digitFrequency(int number) {
        int[] freq = new int[10];
        while (number > 0) {
            freq[number % 10]++;
            number /= 10;
        }

        int[][] result = new int[10][2];
        for (int i = 0; i < 10; i++) {
            result[i][0] = i;
            result[i][1] = freq[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 1729;

        System.out.println("Number: " + number);
        System.out.println("Digit Count: " + countDigits(number));

        System.out.print("Digits: ");
        for (int digit : getDigits(number)) {
            System.out.print(digit + " ");
        }
        System.out.println();

        System.out.println("Sum of Digits: " + sumOfDigits(number));
        System.out.println("Sum of Squares: " + sumOfSquares(number));
        System.out.println("Is Harshad Number: " + isHarshad(number));

        System.out.println("Digit Frequencies:");
        int[][] freq = digitFrequency(number);
        for (int[] row : freq) {
            if (row[1] > 0) {
                System.out.println("Digit " + row[0] + ": " + row[1]);
            }
        }
    }
}
