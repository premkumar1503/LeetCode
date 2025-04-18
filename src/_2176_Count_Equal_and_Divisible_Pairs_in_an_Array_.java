class CountPairs
{
    public int countPairs(int[] nums, int k)
    {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (nums[i] == nums[j] && (i * j) % k == 0)
                {
                    count++;
                }
            }
        }
        return count;
    }
}
public class _2176_Count_Equal_and_Divisible_Pairs_in_an_Array_
{
    public static void main(String[] args)
    {
        CountPairs sol = new CountPairs();
        int[] nums = {3, 1, 2, 2, 2, 1, 3};
        int k = 2;

        int result = sol.countPairs(nums, k);
        System.out.println("Count of pairs: " + result);
    }
}
