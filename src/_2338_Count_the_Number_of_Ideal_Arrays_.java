import java.util.*;

class CountIdealArraysWithMain
{
    final int MOD = 1_000_000_007;
    static final int MAX_N = 10010;
    static long[][] comb = new long[MAX_N][20];

    public int idealArrays(int n, int maxValue)
    {
        precomputeCombinations();

        int maxLen = 14;
        int res = 0;

        for (int i = 1; i <= maxValue; i++)
        {
            List<Integer> freq = getMultiplesSequenceCounts(i, maxValue, maxLen);

            for (int len = 0; len < freq.size(); len++)
            {
                long ways = (freq.get(len) * comb[n - 1][len]) % MOD;
                res = (int) ((res + ways) % MOD);
            }
        }
        return res;
    }
    private void precomputeCombinations()
    {
        for (int i = 0; i < MAX_N; i++)
        {
            comb[i][0] = 1;
            for (int j = 1; j < 20 && j <= i; j++) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
            }
        }
    }
    private List<Integer> getMultiplesSequenceCounts(int val, int maxValue, int maxLen) {
        List<Integer> res = new ArrayList<>();
        dfs(val, maxValue, 0, res);
        return res;
    }
    private void dfs(int curr, int max, int depth, List<Integer> res)
    {
        if (depth >= res.size())
        {
            res.add(0);
        }
        res.set(depth, res.get(depth) + 1);

        for (int i = 2; i * curr <= max; i++)
        {
            dfs(i * curr, max, depth + 1, res);
        }
    }
}
public class _2338_Count_the_Number_of_Ideal_Arrays_
{
    public static void main(String[] args)
    {
        int n = 5;
        int maxValue = 3;

        CountIdealArraysWithMain sol = new CountIdealArraysWithMain();
        int result = sol.idealArrays(n, maxValue);

        System.out.println("Number of ideal arrays: " + result);
    }
}