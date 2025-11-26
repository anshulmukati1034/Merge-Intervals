import java.util.Arrays;

public class Q2_InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][] {newInterval};

        // Step 1: Create temp array to store intervals + newInterval
        int[][] temp = new int[intervals.length + 1][2];
        int idx = 0;

        // Copy old intervals
        for (int i = 0; i < intervals.length; i++) {
            temp[idx++] = intervals[i];
        }
        // Add the new interval at the end
        temp[idx++] = newInterval;

        // Step 2: Sort intervals by start
        Arrays.sort(temp, (a, b) -> a[0] - b[0]);

        // Step 3: Merge intervals using Merge Intervals template
        int[][] mergedTemp = new int[temp.length][2];
        int mergedIdx = 0;
        mergedTemp[0] = temp[0];

        for (int i = 1; i < temp.length; i++) {
            if (temp[i][0] <= mergedTemp[mergedIdx][1]) {
                // Overlap → merge
                mergedTemp[mergedIdx][1] = Math.max(mergedTemp[mergedIdx][1], temp[i][1]);
            } else {
                // No overlap → move to next index
                mergedIdx++;
                mergedTemp[mergedIdx] = temp[i];
            }
        }

        // Step 4: Copy merged intervals to result array
        int[][] result = new int[mergedIdx + 1][2];
        for (int i = 0; i <= mergedIdx; i++) {
            result[i] = mergedTemp[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int[][] updatedIntervals = insert(intervals, newInterval);

        System.out.println("Updated Intervals after Insertion:");
        for (int[] interval : updatedIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }   
}

