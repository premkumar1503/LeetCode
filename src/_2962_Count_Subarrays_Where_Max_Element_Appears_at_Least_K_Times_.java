import java.util.Arrays;

class CountSubArrays
{
    public long countSubarrays(int[] nums, int k)
    {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        long start = 0;
        int maxElementsInWindow = 0;

        for (int end = 0; end < nums.length; end++)
        {
            if (nums[end] == maxElement)
            {
                maxElementsInWindow++;
            }
            while (maxElementsInWindow == k)
            {
                if (nums[(int) start] == maxElement)
                {
                    maxElementsInWindow--;
                }
                start++;
            }
            ans += start;
        }
        return ans;
    }
}
public class _2962_Count_Subarrays_Where_Max_Element_Appears_at_Least_K_Times_
{
    public static void main(String[] args)
    {
        CountSubArrays solution = new CountSubArrays();

        int[] nums = {1, 2, 2, 3, 3, 3};
        int k = 2;

        long result = solution.countSubarrays(nums, k);
        System.out.println("Count of valid subarrays: " + result);
    }
}
