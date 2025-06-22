import java.util.Arrays;

class PartitionArray
{
    public static int partitionArray(int[] nums, int k)
    {
        Arrays.sort(nums);
        int ans = 1;
        int rec = nums[0];
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] - rec > k)
            {
                ans++;
                rec = nums[i];
            }
        }
        return ans;
    }
}
public class _2294_Partition_Array_Such_That_Maximum_Difference_Is_K_
{
    public static void main(String[] args)
    {
        int[] nums = {3, 6, 1, 2, 5};
        int k = 2;

        int result = PartitionArray.partitionArray(nums, k);
        System.out.println("Minimum number of subarrays: " + result);
    }
}