import java.util.Scanner;

public class Ques12 {
    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        for(int i=0; i<size; i++) {
            arr[i] = 1000 + (int)(Math.random() * 9000);
        }
        return arr;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        for(int num : numbers) {
            sum += num;
            if(num < min) min = num;
            if(num > max) max = num;
        }
        double avg = (double)sum / numbers.length;
        return new double[]{avg, min, max};
    }

    public static void main(String[] args) {
        int[] randomNums = generate4DigitRandomArray(5);
        System.out.print("Random numbers: ");
        for(int n : randomNums) System.out.print(n + " ");
        System.out.println();
        double[] stats = findAverageMinMax(randomNums);
        System.out.printf("Average: %.2f, Min: %.0f, Max: %.0f", stats[0], stats[1], stats[2]);
    }
}
