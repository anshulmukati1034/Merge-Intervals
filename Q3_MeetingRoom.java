import java.util.Arrays;

public class Q3_MeetingRoom {
    public static boolean canAttendMeetings(int[][] intervals) {
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Step 2: Check for overlaps
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                // Overlap detected
                return false;
            }
        }

        return true; // No overlaps found
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals2 = {{7, 10}, {2, 4}};

        System.out.println("Can attend meetings in intervals1: " + canAttendMeetings(intervals1)); // Expected: false
        System.out.println("Can attend meetings in intervals2: " + canAttendMeetings(intervals2)); // Expected: true
    }
}
