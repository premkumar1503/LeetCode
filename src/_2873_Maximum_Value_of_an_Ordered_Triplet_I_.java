class Solution9
{
    public static int maximumTripletSum(int[] nums)
    {
        int n = nums.length;
        if (n < 3) return 0;

        int[] prefixMax = new int[n];
        prefixMax[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        int[] suffixMax = new int[n];
        suffixMax[n - 1] = nums[n - 1];

        for (int k = n - 2; k >= 0; k--) {
            suffixMax[k] = Math.max(suffixMax[k + 1], nums[k]);
        }

        int maxSum = 0;

        for (int j = 1; j < n - 1; j++)
        {
            int leftMax = prefixMax[j - 1];
            int rightMax = suffixMax[j + 1];

            if (leftMax > 0 && rightMax > 0)
            {
                int tripletSum = leftMax + nums[j] + rightMax;
                maxSum = Math.max(maxSum, tripletSum);
            }
        }
        return maxSum;
    }
}

public class _2873_Maximum_Value_of_an_Ordered_Triplet_I_
{
    public static void main(String[] args)
    {
        int[] nums1 = {1, 5, 3, 8, 2};
        int[] nums2 = {3, 2, 1};
        int[] nums3 = {10, 20, 30, 5, 15};

        System.out.println("Max Triplet Sum (nums1): " + Solution9.maximumTripletSum(nums1));
        System.out.println("Max Triplet Sum (nums2): " + Solution9.maximumTripletSum(nums2));
        System.out.println("Max Triplet Sum (nums3): " + Solution9.maximumTripletSum(nums3));
    }
}
