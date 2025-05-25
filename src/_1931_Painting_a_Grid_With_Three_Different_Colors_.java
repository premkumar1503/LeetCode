import java.util.*;

class ColorTheGrid
{
    private static final int MOD = 1_000_000_007;

    public static int colorTheGrid(int m, int n)
    {
        List<Integer> states = new ArrayList<>();
        generateStates(m, 0, 0, -1, states);

        Map<Integer, List<Integer>> transitions = new HashMap<>();
        for (int s1 : states)
        {
            transitions.put(s1, new ArrayList<>());
            for (int s2 : states)
            {
                if (isValidTransition(s1, s2, m))
                {
                    transitions.get(s1).add(s2);
                }
            }
        }
        Map<Integer, Integer> dp = new HashMap<>();
        for (int s : states)
        {
            dp.put(s, 1);
        }
        for (int col = 1; col < n; col++)
        {
            Map<Integer, Integer> newDp = new HashMap<>();
            for (int prev : dp.keySet())
            {
                for (int next : transitions.get(prev))
                {
                    int count = (newDp.getOrDefault(next, 0) + dp.get(prev)) % MOD;
                    newDp.put(next, count);
                }
            }
            dp = newDp;
        }
        int result = 0;
        for (int val : dp.values()) {
            result = (result + val) % MOD;
        }
        return result;
    }
    private static void generateStates(int m, int state, int row, int lastColor, List<Integer> states)
    {
        if (row == m)
        {
            states.add(state);
            return;
        }
        for (int color = 0; color < 3; color++)
        {
            if (color != lastColor)
            {
                generateStates(m, state * 3 + color, row + 1, color, states);
            }
        }
    }
    private static boolean isValidTransition(int s1, int s2, int m)
    {
        for (int i = 0; i < m; i++)
        {
            if (s1 % 3 == s2 % 3) return false;
            s1 /= 3;
            s2 /= 3;
        }
        return true;
    }
}
public class _1931_Painting_a_Grid_With_Three_Different_Colors_
{
    public static void main(String[] args)
    {
        ColorTheGrid color = new ColorTheGrid();
        int m = 2;
        int n = 3;
        int result = color.colorTheGrid(m, n);
        System.out.println("Number of ways to paint the grid: " + result);
    }
}