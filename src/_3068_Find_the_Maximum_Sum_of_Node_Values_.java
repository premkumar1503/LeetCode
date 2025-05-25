import java.util.Arrays;

class MaximumValueSum
{
    public static long maximumValueSum(int[] nums, int k)
    {
        long[][] memo = new long[nums.length][2];
        for (long[] row : memo)
        {
            Arrays.fill(row, -1);
        }
        return maxSumOfNodes(0, 1, nums, k, memo);
    }
    private static long maxSumOfNodes(int index, int isEven, int[] nums, int k, long[][] memo)
    {
        if (index == nums.length)
        {
            return isEven == 1 ? 0 : Integer.MIN_VALUE;
        }
        if (memo[index][isEven] != -1)
        {
            return memo[index][isEven];
        }
        long noXorDone = nums[index] + maxSumOfNodes(index + 1, isEven, nums, k, memo);

        long xorDone = (nums[index] ^ k) + maxSumOfNodes(index + 1, isEven ^ 1, nums, k, memo);

        return memo[index][isEven] = Math.max(noXorDone, xorDone);
    }
}
public class _3068_Find_the_Maximum_Sum_of_Node_Values_
{
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3};
        int k = 2;

        long result = MaximumValueSum.maximumValueSum(nums, k);
        System.out.println("Maximum sum with even XOR operations: " + result);
    }
}
