public class SimpleMatrixQ_15 {
    public static void main(String[] args) {
        int[][] m = {
            {1, 2, 3},
            {0, 1, 4},
            {5, 6, 0}
        };

        System.out.println("Original Matrix:");
        print(m);

        System.out.println("Transpose:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(m[j][i] + " ");
            System.out.println();
        }

        int det = m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1])
                - m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0])
                + m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
        System.out.println("Determinant: " + det);

        if (det == 0) {
            System.out.println("Inverse not possible.");
        } else {
            System.out.println("Inverse:");
            double[][] inv = new double[3][3];
            inv[0][0] =  (m[1][1]*m[2][2] - m[1][2]*m[2][1]);
            inv[0][1] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]);
            inv[0][2] =  (m[0][1]*m[1][2] - m[0][2]*m[1][1]);
            inv[1][0] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]);
            inv[1][1] =  (m[0][0]*m[2][2] - m[0][2]*m[2][0]);
            inv[1][2] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]);
            inv[2][0] =  (m[1][0]*m[2][1] - m[1][1]*m[2][0]);
            inv[2][1] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]);
            inv[2][2] =  (m[0][0]*m[1][1] - m[0][1]*m[1][0]);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++)
                    System.out.printf("%.2f ", inv[i][j] / det);
                System.out.println();
            }
        }
    }

    static void print(int[][] m) {
        for (int[] row : m) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}