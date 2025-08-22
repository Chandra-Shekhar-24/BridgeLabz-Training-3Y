import java.util.Random;
public class MatrixOperationsQ_14 {
    public static void main(String[] args) {
        int rows = 2, cols = 2;
        int[][] A = generateMatrix(rows, cols);
        int[][] B = generateMatrix(rows, cols);

        System.out.println("Matrix A:");
        printMatrix(A);
        System.out.println("Matrix B:");
        printMatrix(B);

        System.out.println("A + B:");
        printMatrix(addMatrices(A, B));

        System.out.println("A - B:");
        printMatrix(subtractMatrices(A, B));

        System.out.println("A * B:");
        printMatrix(multiplyMatrices(A, B));
    }

    static int[][] generateMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] mat = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                mat[i][j] = rand.nextInt(10); // random values 0–9
        return mat;
    }

    static int[][] addMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[i][j] = A[i][j] + B[i][j];
        return result;
    }

    static int[][] subtractMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[i][j] = A[i][j] - B[i][j];
        return result;
    }

    static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < B[0].length; j++)
                for (int k = 0; k < B.length; k++)
                    result[i][j] += A[i][k] * B[k][j];
        return result;
    }

    static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }
}
