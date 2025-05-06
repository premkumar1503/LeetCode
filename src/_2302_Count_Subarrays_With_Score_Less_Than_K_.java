class CountSubArray
{
    public long countSubarrays(int[] nums, long k)
    {
        int n = nums.length;
        long res = 0, total = 0;
        for (int i = 0, j = 0; j < n; j++)
        {
            total += nums[j];
            while (i <= j && total * (j - i + 1) >= k)
            {
                total -= nums[i];
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
}
public class _2302_Count_Subarrays_With_Score_Less_Than_K_
{
    public static void main(String[] args)
    {
        CountSubArray solution = new CountSubArray();

        int[] nums = {1, 3, 2, 4, 5};
        long k = 10;

        long result = solution.countSubarrays(nums, k);
        System.out.println("Count of subarrays with score less than " + k + ": " + result);
    }
}
