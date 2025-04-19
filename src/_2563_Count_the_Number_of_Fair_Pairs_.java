import java.util.Arrays;

class CountFairPairs
{
    public long countFairPairs(int[] nums, int lower, int upper)
    {
        Arrays.sort(nums);
        long count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++)
        {
            int left = lowerBound(nums, i + 1, n - 1, lower - nums[i]);
            int right = upperBound(nums, i + 1, n - 1, upper - nums[i]);
            count += (right - left + 1);
        }
        return count;
    }
    private int lowerBound(int[] nums, int start, int end, int target)
    {
        int res = end + 1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target)
            {
                res = mid;
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return res;
    }
    private int upperBound(int[] nums, int start, int end, int target)
    {
        int res = start - 1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target)
            {
                res = mid;
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return res;
    }
}

public class _2563_Count_the_Number_of_Fair_Pairs_
{
    public static void main(String[] args)
    {
        CountFairPairs solution = new CountFairPairs();

        int[] nums = {1, 2, 3, 4, 5, 6};
        int lower = 4;
        int upper = 8;

        long result = solution.countFairPairs(nums, lower, upper);
        System.out.println("Number of fair pairs: " + result);
    }
}