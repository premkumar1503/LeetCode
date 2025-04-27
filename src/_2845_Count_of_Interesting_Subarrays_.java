import java.util.*;

class CountInterestingSubarrays
{
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k)
    {
        Map<Integer, Long> freq = new HashMap<>();
        freq.put(0, 1L);

        int count = 0;
        long ans = 0;

        for (int num : nums)
        {
            if (num % modulo == k)
            {
                count++;
            }
            int currentMod = count % modulo;
            int needed = (currentMod - k + modulo) % modulo;

            ans += freq.getOrDefault(needed, 0L);

            freq.put(currentMod, freq.getOrDefault(currentMod, 0L) + 1);
        }
        return ans;
    }
}

public class _2845_Count_of_Interesting_Subarrays_
{
    public static void main(String[] args)
    {
        List<Integer> nums = Arrays.asList(3, 1, 9, 6);
        int modulo = 3;
        int k = 0;

        CountInterestingSubarrays sol = new CountInterestingSubarrays();

        long result = sol.countInterestingSubarrays(nums, modulo, k);

        System.out.println("Count of interesting subarrays: " + result);
    }
}
