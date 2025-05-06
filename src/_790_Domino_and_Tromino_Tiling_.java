public class _790_Domino_and_Tromino_Tiling_
{
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args)
    {
        int n = 5;
        int result = numTilings(n);
        System.out.println("Number of ways to tile 2 x " + n + " board: " + result);
    }
    public static int numTilings(int n)
    {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++)
        {
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * sum(dp, i - 3)) % MOD;
        }
        return (int) dp[n];
    }
    private static long sum(long[] dp, int upTo)
    {
        long total = 0;
        for (int i = 0; i <= upTo; i++)
        {
            total = (total + dp[i]) % MOD;
        }
        return total;
    }
}
