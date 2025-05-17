import java.util.*;

class MinTimeToReach2 {

    private static final int INF = 0x3f3f3f3f;

    class State implements Comparable<State>
    {
        int x, y, dis;

        State(int x, int y, int dis)
        {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
        @Override
        public int compareTo(State other)
        {
            return Integer.compare(this.dis, other.dis);
        }
    }
    public int minTimeToReach(int[][] moveTime)
    {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] d = new int[n][m];
        boolean[][] v = new boolean[n][m];
        for (int i = 0; i < n; i++)
        {
            Arrays.fill(d[i], INF);
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        d[0][0] = 0;
        PriorityQueue<State> q = new PriorityQueue<>();
        q.offer(new State(0, 0, 0));

        while (!q.isEmpty())
        {
            State s = q.poll();
            if (v[s.x][s.y]) continue;
            if (s.x == n - 1 && s.y == m - 1) break;
            v[s.x][s.y] = true;

            for (int[] dir : dirs)
            {
                int nx = s.x + dir[0];
                int ny = s.y + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                int dist = Math.max(d[s.x][s.y], moveTime[nx][ny]) + ((s.x + s.y) % 2) + 1;
                if (d[nx][ny] > dist)
                {
                    d[nx][ny] = dist;
                    q.offer(new State(nx, ny, dist));
                }
            }
        }
        return d[n - 1][m - 1];
    }
}
public class _3342_Find_Minimum_Time_to_Reach_Last_Room_II_
{
    public static void main(String[] args)
    {
        MinTimeToReach2 sol = new MinTimeToReach2();

        int[][] moveTime = {
                {0, 1, 2},
                {2, 3, 4},
                {3, 2, 1}
        };
        int result = sol.minTimeToReach(moveTime);
        System.out.println("Minimum time to reach bottom-right cell: " + result);
    }
}
