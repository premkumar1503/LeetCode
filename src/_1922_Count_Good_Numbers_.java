class Solution21
{
    private static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n)
    {
        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long evenChoices = modPow(5, evenPositions, MOD);
        long oddChoices = modPow(4, oddPositions, MOD);

        return (int) ((evenChoices * oddChoices) % MOD);
    }
    private long modPow(long base, long exp, int mod)
    {
        long result = 1;
        base = base % mod;

        while (exp > 0)
        {
            if ((exp & 1) == 1)
            {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
public class _1922_Count_Good_Numbers_
{
    public static void main(String[] args)
    {
        Solution21 solution = new Solution21();

        long n = 50;
        int result = solution.countGoodNumbers(n);
        System.out.println("Count of good numbers for n = " + n + " is: " + result);
    }
}

