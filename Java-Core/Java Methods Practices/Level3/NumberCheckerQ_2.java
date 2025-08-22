public class NumberCheckerQ_2 {

    public static int countDigits(int num) {
        return String.valueOf(num).length();
    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static boolean isDuckNumber(int num) {
        String str = String.valueOf(num);
        return str.contains("0") && !str.startsWith("0");
    }

    public static boolean isArmstrong(int num) {
        int original = num;
        int digits = countDigits(num);
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }
        return sum == original;
    }

    public static void findTwoLargest(int[] arr) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num != max1) {
                max2 = num;
            }
        }

        System.out.println("Largest: " + max1);
        System.out.println("Second Largest: " + max2);
    }

    public static void findTwoSmallest(int[] arr) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2 && num != min1) {
                min2 = num;
            }
        }

        System.out.println("Smallest: " + min1);
        System.out.println("Second Smallest: " + min2);
    }

    public static void main(String[] args) {
        int num = 153;
        int[] digitsArray = {5, 3, 9, 1, 4, 3};

        System.out.println("Digit Count: " + countDigits(num));
        System.out.println("Sum of Digits: " + sumOfDigits(num));
        System.out.println("Is Duck Number: " + isDuckNumber(num));
        System.out.println("Is Armstrong Number: " + isArmstrong(num));

        findTwoLargest(digitsArray);
        findTwoSmallest(digitsArray);
    }
}
