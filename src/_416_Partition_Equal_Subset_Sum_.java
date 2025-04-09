import java.util.HashSet;

class Solution17
{
    public int minimumOperations(int[] nums)
    {
        int ans = 0;
        for (int i = 0; i < nums.length; i += 3, ans++)
        {
            if (checkUnique(nums, i))
            {
                return ans;
            }
        }
        return ans;
    }

    private boolean checkUnique(int[] nums, int start)
    {
        HashSet<Integer> cnt = new HashSet<>();
        for (int i = start; i < nums.length; i++)
        {
            if (cnt.contains(nums[i]))
            {
                return false;
            }
            cnt.add(nums[i]);
        }
        return true;
    }
}

public class _416_Partition_Equal_Subset_Sum_
{
    public static void main(String[] args)
    {
        Solution17 sol = new Solution17();

        int[] nums = {1, 2, 1, 3, 4, 5};
        int result = sol.minimumOperations(nums);

        System.out.println("Minimum operations: " + result);
    }
}
