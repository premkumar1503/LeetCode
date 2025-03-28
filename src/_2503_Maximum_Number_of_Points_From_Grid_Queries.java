import java.util.*;

class Solution5
{
    public int[] maxPoints(int[][] grid, int[] queries)
    {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));

        int[] result = new int[queries.length];
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        int points = 0;

        for (int[] q : sortedQueries)
        {
            int query = q[0], index = q[1];

            while (!minHeap.isEmpty() && minHeap.peek()[0] < query)
            {
                int[] cell = minHeap.poll();
                int r = cell[1], c = cell[2];
                points++;

                for (int[] d : directions)
                {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc])
                    {
                        minHeap.offer(new int[]{grid[nr][nc], nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }

            result[index] = points;
        }

        return result;
    }
}
public class _2503_Maximum_Number_of_Points_From_Grid_Queries
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows (m): ");
        int m = scanner.nextInt();
        System.out.print("Enter number of columns (n): ");
        int n = scanner.nextInt();

        int[][] grid = new int[m][n];
        System.out.println("Enter grid values:");
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                grid[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter number of queries: ");
        int q = scanner.nextInt();
        int[] queries = new int[q];

        System.out.println("Enter query values:");
        for (int i = 0; i < q; i++)
        {
            queries[i] = scanner.nextInt();
        }

        Solution5 solution = new Solution5();
        int[] result = solution.maxPoints(grid, queries);

        System.out.println("Results:");
        for (int res : result)
        {
            System.out.print(res + " ");
        }
        System.out.println();

        scanner.close();
    }
}
