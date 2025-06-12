class MaxAdjacentDistance
{
    public int maxAdjacentDistance(int[] nums)
    {
        int n = nums.length;
        int res = Math.abs(nums[0] - nums[n - 1]);
        for (int i = 0; i < n - 1; ++i)
        {
            res = Math.max(res, Math.abs(nums[i] - nums[i + 1]));
        }
        return res;
    }
}
public class _3423_Maximum_Difference_Between_Adjacent_Elements_in_a_Circular_Array_
{
    public static void main(String[] args)
    {
        MaxAdjacentDistance sol = new MaxAdjacentDistance();

        int[] nums = {10, 3, 8, 15, 2};

        int result = sol.maxAdjacentDistance(nums);
        System.out.println("Maximum difference between adjacent elements (circular): " + result);
    }
}