import java.util.Arrays;


public class Q7_NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
         if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int prevEnd = intervals[0][1]; // take first interval

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start < prevEnd) {
                count++;
            } else {
                prevEnd = end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1,2}, {2,3}, {3,4}, {1,3}};
        System.out.println(eraseOverlapIntervals(intervals1)); // Expected: 1

        int[][] intervals2 = {{1,2}, {1,2}, {1,2}};
        System.out.println(eraseOverlapIntervals(intervals2)); // Expected: 2

        int[][] intervals3 = {{1,2}, {2,3}};
        System.out.println(eraseOverlapIntervals(intervals3)); // Expected: 0
    }
}