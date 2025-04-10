import java.util.Arrays;

public class _2999_Count_the_Number_of_Powerful_Integers_
{
    public static void main(String[] args)
    {
        Solution18 sol = new Solution18();

        long start = 1114;
        long finish = 1864854501L;
        int limit = 7;
        String s = "27";

        long result = sol.numberOfPowerfulInt(start, finish, limit, s);
        System.out.println("Number of powerful integers: " + result);
    }
}

class Solution18
{
    public long numberOfPowerfulInt(long start, long finish, int limit, String s)
    {
        String low = Long.toString(start);
        String high = Long.toString(finish);
        int n = high.length();
        low = String.format("%" + n + "s", low).replace(' ', '0');
        int pre_len = n - s.length();
        long[] memo = new long[n];
        Arrays.fill(memo, -1);

        return dfs(0, true, true, low, high, limit, s, pre_len, memo);
    }

    private long dfs(
            int i,
            boolean limit_low,
            boolean limit_high,
            String low,
            String high,
            int limit,
            String s,
            int pre_len,
            long[] memo
    ) {
        if (i == low.length())
        {
            return 1;
        }
        if (!limit_low && !limit_high && memo[i] != -1)
        {
            return memo[i];
        }

        int lo = limit_low ? low.charAt(i) - '0' : 0;
        int hi = limit_high ? high.charAt(i) - '0' : 9;
        long res = 0;

        if (i < pre_len)
        {
            for (int digit = lo; digit <= Math.min(hi, limit); digit++)
            {
                res += dfs(
                        i + 1,
                        limit_low && digit == lo,
                        limit_high && digit == hi,
                        low,
                        high,
                        limit,
                        s,
                        pre_len,
                        memo
                );
            }
        }
        else
        {
            int x = s.charAt(i - pre_len) - '0';
            if (lo <= x && x <= Math.min(hi, limit))
            {
                res = dfs(
                        i + 1,
                        limit_low && x == lo,
                        limit_high && x == hi,
                        low,
                        high,
                        limit,
                        s,
                        pre_len,
                        memo
                );
            }
        }

        if (!limit_low && !limit_high)
        {
            memo[i] = res;
        }

        return res;
    }
}
