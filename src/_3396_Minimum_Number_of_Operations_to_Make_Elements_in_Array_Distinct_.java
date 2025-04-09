import java.util.HashSet;

class Solution16
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

public class _3396_Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct_
{
    public static void main(String[] args) {
        Solution16 sol = new Solution16();

        int[] nums = {1, 2, 1, 3, 4, 5};
        int result = sol.minimumOperations(nums);

        System.out.println("Minimum operations: " + result);
    }
}
