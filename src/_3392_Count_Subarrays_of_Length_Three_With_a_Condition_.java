class CountSubarray
{
    public int countSubarrays(int[] nums)
    {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i <= n - 3; i++)
        {
            int first = nums[i];
            int middle = nums[i + 1];
            int third = nums[i + 2];

            if (middle % 2 == 0 && (first + third) == (middle / 2))
            {
                count++;
            }
        }
        return count;
    }
}
public class _3392_Count_Subarrays_of_Length_Three_With_a_Condition_
{
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 1, 4, 1};

        CountSubarray sol = new CountSubarray();

        int result = sol.countSubarrays(nums);

        System.out.println("Count of valid subarrays: " + result);
    }
}
