class MaxDifference
{
    public int subsetXORSum(int[] nums)
    {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int currentXor)
    {
        if (index == nums.length)
        {
            return currentXor;
        }

        int withCurrent = dfs(nums, index + 1, currentXor ^ nums[index]);

        int withoutCurrent = dfs(nums, index + 1, currentXor);

        return withCurrent + withoutCurrent;
    }
}

public class _1863_Sum_of_All_Subset_XOR_Totals_
{
    public static void main(String[] args)
    {
        int[] nums = {1, 3, 6 ,8, 10};
        MaxDifference solution = new MaxDifference();
        int result = solution.subsetXORSum(nums);
        System.out.println("Sum of all subset XOR totals: " + result);
    }
}
