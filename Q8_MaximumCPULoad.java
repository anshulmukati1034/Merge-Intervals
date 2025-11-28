import java.util.Arrays;
import java.util.PriorityQueue;

public class Q8_MaximumCPULoad {
      public static int findMaxCpuLoad(int[][] jobs) {

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int currentLoad = 0;
        int maxLoad = 0;

        // Step 2: Process jobs
        for (int[] job : jobs) {
            int start = job[0];
            int end = job[1];
            int load = job[2];

            while (!minHeap.isEmpty() && minHeap.peek()[1] <= start) {
                currentLoad -= minHeap.peek()[2];
                minHeap.poll();
            }

            minHeap.add(job);
            currentLoad += load;

            maxLoad = Math.max(maxLoad, currentLoad);
        }

        return maxLoad;
    }

    public static void main(String[] args) {
        int[][] jobs = {
            {1, 4, 3},
            {2, 5, 4},
            {7, 9, 6}
        };

        System.out.println("Maximum CPU Load: " + findMaxCpuLoad(jobs)); // Expected: 7
    }
}
