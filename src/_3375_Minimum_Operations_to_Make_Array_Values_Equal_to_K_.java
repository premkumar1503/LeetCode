import java.util.*;

class Solution15
{
    public int minOperations(int[] nums, int k)
    {
        Set<Integer> st = new HashSet<>();
        for (int x : nums)
        {
            if (x <= k)
            {
                return -1;
            }
            else if (x > k)
            {
                st.add(x);
            }
        }
        return st.size();
    }
}
public class _3375_Minimum_Operations_to_Make_Array_Values_Equal_to_K_
{
    public static void main(String[] args)
    {
        Solution15 sol = new Solution15();
        int[] nums = {10, 15, 20, 25};
        int k = 12;

        int result = sol.minOperations(nums, k);
        System.out.println("Minimum operations to make all values equal to " + k + ": " + result);
    }
}
