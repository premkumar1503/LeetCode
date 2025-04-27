class CountSubarrays
{
    public long countSubarrays(int[] nums, int minK, int maxK)
    {
        long count = 0;
        int n = nums.length;

        int minPosition = -1;
        int maxPosition = -1;
        int leftBound = -1;

        for (int i = 0; i < n; i++)
        {
            if (nums[i] < minK || nums[i] > maxK)
            {
                leftBound = i;
                minPosition = -1;
                maxPosition = -1;
            }
            if (nums[i] == minK)
            {
                minPosition = i;
            }
            if (nums[i] == maxK)
            {
                maxPosition = i;
            }
            if (minPosition != -1 && maxPosition != -1)
            {
                count += Math.max(0, Math.min(minPosition, maxPosition) - leftBound);
            }
        }
        return count;
    }
}

public class _2444_Count_Subarrays_With_Fixed_Bounds_
{
    public static void main(String[] args)
    {
        int[] nums = {1, 3, 5, 2, 7, 5};
        int minK = 1;
        int maxK = 5;

        CountSubarrays sol = new CountSubarrays();

        long result = sol.countSubarrays(nums, minK, maxK);

        System.out.println("Count of fixed bounds subarrays: " + result);
    }
}

