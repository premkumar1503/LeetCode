class MaximumDifference
{
    public int maximumDifference(int[] nums)
    {
        int n = nums.length;
        int ans = -1, premin = nums[0];
        for (int i = 1; i < n; ++i)
        {
            if (nums[i] > premin)
            {
                ans = Math.max(ans, nums[i] - premin);
            }
            else
            {
                premin = nums[i];
            }
        }
        return ans;
    }
}
public class _2016_Maximum_Difference_Between_Increasing_Elements_
{
    public static void main(String[] args) {
        MaximumDifference sol = new MaximumDifference();

        int[] nums = {7, 1, 5, 4};
        int result = sol.maximumDifference(nums);

        System.out.println("Maximum Difference: " + result);
    }
}