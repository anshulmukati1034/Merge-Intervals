import java.util.Arrays;

public class Q10_MergeOverlappingIntervals {
     public static int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by start
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = intervals.length;

        // Temp result array (max = n intervals)
        int[][] temp = new int[n][2];
        int idx = 0;

        // Put first interval in temp
        temp[0] = intervals[0];

        // Step 2: Merge
        for (int i = 1; i < n; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            int lastStart = temp[idx][0];
            int lastEnd   = temp[idx][1];

            if (currStart <= lastEnd) {
                // Overlap → merge
                temp[idx][1] = Math.max(lastEnd, currEnd);
            } else {
                // No overlap → move to next index
                idx++;
                temp[idx] = intervals[i];
            }
        }

        // Step 3: Copy exact result
        int[][] result = new int[idx + 1][2];
        for (int i = 0; i <= idx; i++) {
            result[i][0] = temp[i][0];
            result[i][1] = temp[i][1];
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merged = merge(intervals);

        System.out.println("Merged Intervals:");
        for (int[] interval : merged) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
