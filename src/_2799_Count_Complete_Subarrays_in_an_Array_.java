import java.util.*;

class CountCompleteSubarrays
{
    public static int countCompleteSubarrays(int[] nums)
    {
        int n = nums.length;

        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : nums)
        {
            uniqueSet.add(num);
        }
        int totalDistinct = uniqueSet.size();

        int count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++)
        {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            while (freqMap.size() == totalDistinct)
            {
                count += n - right;
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0)
                {
                    freqMap.remove(nums[left]);
                }
                left++;
            }
        }
        return count;
    }
}
public class _2799_Count_Complete_Subarrays_in_an_Array_
{
    public static void main(String[] args)
    {
        int[] nums = {1, 3, 1, 2, 2};
        int result = CountCompleteSubarrays.countCompleteSubarrays(nums);
        System.out.println("Number of complete subarrays: " + result);
    }
}