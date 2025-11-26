public class Q4_IntervalListIntersections{
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        int m = A.length, n = B.length;

        // To store answer temporarily, use max possible size
        int[][] temp = new int[m + n][2];
        int idx = 0;

        while (i < m && j < n) {
            // Find intersection boundaries
            int start = Math.max(A[i][0], B[j][0]);
            int end   = Math.min(A[i][1], B[j][1]);

            // If valid intersection
            if (start <= end) {
                temp[idx][0] = start;
                temp[idx][1] = end;
                idx++;
            }

            // Move pointer of interval which ends first
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        // Copy to exact-sized result
        int[][] result = new int[idx][2];
        for (int k = 0; k < idx; k++) {
            result[k][0] = temp[k][0];
            result[k][1] = temp[k][1];
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};

        int[][] intersections = intervalIntersection(A, B);

        System.out.println("Interval Intersections:");
        for (int[] interval : intersections) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
