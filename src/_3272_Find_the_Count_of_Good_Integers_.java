import java.util.*;

class Solution20
{
    public long countGoodIntegers(int n, int k)
    {
        Set<String> dict = new HashSet<>();
        int base = (int) Math.pow(10, (n - 1) / 2);
        int skip = n & 1;

        for (int i = base; i < base * 10; i++)
        {
            String s = Integer.toString(i);
            s += new StringBuilder(s).reverse().substring(skip);
            long palindromicInteger = Long.parseLong(s);

            if (palindromicInteger % k == 0)
            {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                dict.add(new String(chars));
            }
        }

        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++)
        {
            factorial[i] = factorial[i - 1] * i;
        }

        long ans = 0;
        for (String s : dict)
        {
            int[] cnt = new int[10];
            for (char c : s.toCharArray())
            {
                cnt[c - '0']++;
            }

            long tot = (n - cnt[0]) * factorial[n - 1];
            for (int x : cnt)
            {
                tot /= factorial[x];
            }
            ans += tot;
        }

        return ans;
    }
}

public class _3272_Find_the_Count_of_Good_Integers_
{
    public static void main(String[] args)
    {
        Solution20 sol = new Solution20();

        System.out.println("Test Case 1: n = 3, k = 5");
        System.out.println("Output: " + sol.countGoodIntegers(3, 5));

        System.out.println("Test Case 2: n = 1, k = 4");
        System.out.println("Output: " + sol.countGoodIntegers(1, 4));

        System.out.println("Test Case 3: n = 5, k = 6");
        System.out.println("Output: " + sol.countGoodIntegers(5, 6));

        System.out.println("Test Case 4: n = 7, k = 4");
        System.out.println("Output: " + sol.countGoodIntegers(7, 4));
    }
}
