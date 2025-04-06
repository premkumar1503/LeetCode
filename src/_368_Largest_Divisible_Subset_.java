import java.util.*;

class LargestDivisibleSubset
{
    public List<Integer> largestDivisibleSubset(int[] nums)
    {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();

        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxIndex = 0;

        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i])
                {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex])
            {
                maxIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        int k = maxIndex;
        while (k >= 0) {
            result.add(nums[k]);
            k = prev[k];
        }

        Collections.reverse(result);
        return result;
    }
}
public class _368_Largest_Divisible_Subset_
{
    public static void main(String[] args)
    {
        LargestDivisibleSubset solver = new LargestDivisibleSubset();
        int[] nums = {65,75,34,24,2,1,5};
        System.out.println(solver.largestDivisibleSubset(nums));
    }
}
