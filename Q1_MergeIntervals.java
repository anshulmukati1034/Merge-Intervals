import java.util.Arrays;

public class Q1_MergeIntervals{
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        // Step 1: Sort intervals by start
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Step 2: Temp array to store merged intervals
        int[][] temp = new int[intervals.length][2];
        int idx = 0;  // Points to last merged interval

        temp[0] = intervals[0];  // Add first interval

        // Step 3: Merge intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= temp[idx][1]) {
                // Overlap → merge by updating end
                temp[idx][1] = Math.max(temp[idx][1], intervals[i][1]);
            } else {
                // No overlap → move to next index
                idx++;
                temp[idx] = intervals[i];
            }
        }

        // Step 4: Copy merged intervals to result array
        int[][] result = new int[idx + 1][2];
        for (int i = 0; i <= idx; i++) {
            result[i] = temp[i];
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

