import java.util.HashMap;

class CountGood
{
    public long countGood(int[] nums, int k)
    {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        long res = 0;
        long pairs = 0;

        for (int right = 0; right < nums.length; right++)
        {
            int num = nums[right];
            int count = freq.getOrDefault(num, 0);
            pairs += count;
            freq.put(num, count + 1);

            while (pairs >= k)
            {
                res += nums.length - right;
                int leftNum = nums[left];
                int leftCount = freq.get(leftNum);
                pairs -= leftCount - 1;
                freq.put(leftNum, leftCount - 1);
                left++;
            }
        }
        return res;
    }
}

public class _2537_Count_the_Number_of_Good_Subarrays_
{
    public static void main(String[] args) {
        CountGood solution = new CountGood();

        int[] nums = {1, 2, 2, 1, 1, 3};
        int k = 2;

        long result = solution.countGood(nums, k);
        System.out.println("Count of good subarrays: " + result);
    }
}
