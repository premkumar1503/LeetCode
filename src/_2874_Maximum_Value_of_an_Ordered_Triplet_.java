class Solution8
{
    public static int maximumTripletValue(int[] nums)
    {
        int n = nums.length;
        if (n < 3) return 0;

        int[] prefixMax = new int[n];
        prefixMax[0] = nums[0];

        for (int i = 1; i < n; i++)
        {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        int[] suffixMax = new int[n];
        suffixMax[n - 1] = nums[n - 1];

        for (int k = n - 2; k >= 0; k--)
        {
            suffixMax[k] = Math.max(suffixMax[k + 1], nums[k]);
        }

        long maxVal = 0;

        for (int j = 1; j < n - 1; j++)
        {
            if (prefixMax[j - 1] > nums[j] && suffixMax[j + 1] > 0)
            {
                long value = (long) (prefixMax[j - 1] - nums[j]) * suffixMax[j + 1];
                maxVal = Math.max(maxVal, value);
            }
        }
        return (int) maxVal;
    }
}
public class _2874_Maximum_Value_of_an_Ordered_Triplet_
{
    public static void main(String[] args)
    {
        int[] nums1 = {3, 5, 2, 8, 7};
        int[] nums2 = {1, 2, 3};
        int[] nums3 = {9, 1, 5, 6, 2};

        System.out.println("Max Triplet Value (nums1): " + Solution8.maximumTripletValue(nums1));
        System.out.println("Max Triplet Value (nums2): " + Solution8.maximumTripletValue(nums2));
        System.out.println("Max Triplet Value (nums3): " + Solution8.maximumTripletValue(nums3));
    }
}
