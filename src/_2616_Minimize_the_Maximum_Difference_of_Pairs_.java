import java.util.Arrays;

class MinimizeMax
{
    private int countValidPairs(int[] nums, int threshold)
    {
        int index = 0, count = 0;
        while (index < nums.length - 1)
        {
            if (nums[index + 1] - nums[index] <= threshold)
            {
                count++;
                index++;
            }
            index++;
        }
        return count;
    }
    public int minimizeMax(int[] nums, int p)
    {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (countValidPairs(nums, mid) >= p)
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        return left;
    }
}
public class _2616_Minimize_the_Maximum_Difference_of_Pairs_
{
    public static void main(String[] args)
    {
        MinimizeMax sol = new MinimizeMax();

        int[] nums1 = {10,1,2,7,1,3};
        int p1 = 2;
        System.out.println("Minimum maximum difference (Test 1): " + sol.minimizeMax(nums1, p1));

        int[] nums2 = {4,2,1,2};
        int p2 = 1;
        System.out.println("Minimum maximum difference (Test 2): " + sol.minimizeMax(nums2, p2));
    }
}