import java.util.Arrays;

public class Q6_Checkifanytwointervalsintersectinagivenset {

    public static boolean hasIntersection(int[][] intervals) {
        if (intervals.length <= 1) return false;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start <= prevEnd) {
                return true;  
            }

          
            prevEnd = end;
        }

        return false; 
    }


    public static void main(String[] args) {
        // Example 1
        int[][] intervals1 = {{1,3}, {5,7}, {2,4}};
        System.out.println(hasIntersection(intervals1)); // true

        // Example 2
        int[][] intervals2 = {{1,2}, {3,4}, {5,6}};
        System.out.println(hasIntersection(intervals2)); // false

        // Example 3
        int[][] intervals3 = {{5,10}, {12,15}, {8,9}};
        System.out.println(hasIntersection(intervals3)); // true
    }
}
