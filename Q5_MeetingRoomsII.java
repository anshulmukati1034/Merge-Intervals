import java.util.Arrays;
import java.util.PriorityQueue;

public class Q5_MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start >= minHeap.peek()) {
                minHeap.poll(); 
            }

            minHeap.add(end);
        }

        return minHeap.size();
    }

    public static void main(String[] args) {

        // Example 1
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms(intervals1)); 
        // Output: 2

        // Example 2
        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println(minMeetingRooms(intervals2)); 
        // Output: 1

        // Example 3
        int[][] intervals3 = {{1, 4}, {2, 3}, {3, 5}, {7, 9}};
        System.out.println(minMeetingRooms(intervals3)); 
        // Output: 2
    }
}
