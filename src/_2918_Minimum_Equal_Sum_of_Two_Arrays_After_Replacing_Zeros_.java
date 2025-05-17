class MinSum {

    public long minSum(int[] nums1, int[] nums2)
    {
        long sum1 = 0, sum2 = 0;
        long zero1 = 0, zero2 = 0;

        for (int i : nums1)
        {
            sum1 += i;
            if (i == 0)
            {
                sum1++;
                zero1++;
            }
        }
        for (int i : nums2)
        {
            sum2 += i;
            if (i == 0) {
                sum2++;
                zero2++;
            }
        }
        if ((zero1 == 0 && sum2 > sum1) || (zero2 == 0 && sum1 > sum2))
        {
            return -1;
        }
        return Math.max(sum1, sum2);
    }
}
public class _2918_Minimum_Equal_Sum_of_Two_Arrays_After_Replacing_Zeros_
{
    public static void main(String[] args)
    {
        MinSum sol = new MinSum();

        int[] nums1 = {0, 2, 3};
        int[] nums2 = {1, 0, 4};

        long result = sol.minSum(nums1, nums2);
        System.out.println("Minimum equal sum after replacing zeros: " + result);
    }
}
