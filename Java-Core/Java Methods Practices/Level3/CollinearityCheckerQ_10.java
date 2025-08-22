public class CollinearityCheckerQ_10 {
        public static boolean isCollinearSlope(int[] p1, int[] p2, int[] p3) {
        int dx1 = p2[0] - p1[0], dy1 = p2[1] - p1[1];
        int dx2 = p3[0] - p2[0], dy2 = p3[1] - p2[1];
        return dy1 * dx2 == dy2 * dx1;
    }

    public static boolean isCollinearArea(int[] p1, int[] p2, int[] p3) {
        int area = p1[0]*(p2[1]-p3[1]) + p2[0]*(p3[1]-p1[1]) + p3[0]*(p1[1]-p2[1]);
        return area == 0;
    }

    public static void main(String[] args) {
        int[][] points = {
            {2, 4}, {4, 6}, {6, 8},
            {2, 4}, {4, 6}, {6, 7}
        };

        for (int i = 0; i < points.length; i += 3) {
            int[] p1 = points[i], p2 = points[i+1], p3 = points[i+2];
            boolean slope = isCollinearSlope(p1, p2, p3);
            boolean area = isCollinearArea(p1, p2, p3);
            System.out.printf("Points (%d,%d), (%d,%d), (%d,%d): ", p1[0], p1[1], p2[0], p2[1], p3[0], p3[1]);
            System.out.println(slope && area ? "Collinear" : "Not Collinear");
        }
    }
}
