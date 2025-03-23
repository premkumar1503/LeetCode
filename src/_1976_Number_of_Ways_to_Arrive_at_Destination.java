import java.util.*;

class Solution1
{
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        int[] ways = new int[n];
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long time = cur[0];
            int node = (int) cur[1];
            if (time > dist[node]) continue;
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                long nextTime = time + neighbor[1];

                if (nextTime < dist[nextNode]) {
                    dist[nextNode] = nextTime;
                    pq.offer(new long[]{nextTime, nextNode});
                    ways[nextNode] = ways[node];
                } else if (nextTime == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}
public class _1976_Number_of_Ways_to_Arrive_at_Destination
{
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int n = 7;
        int[][] roads = {
                {0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3},
                {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}
        };
        int result = solution.countPaths(n, roads);
        System.out.println("Number of ways to arrive at destination: " + result);
    }
}

