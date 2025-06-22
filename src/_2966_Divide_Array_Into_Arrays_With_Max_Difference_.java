import java.util.Arrays;

class DivideArray
{
    public static int[][] divideArray(int[] nums, int k)
    {
        Arrays.sort(nums);
        int[][] ans = new int[nums.length / 3][3];
        for (int i = 0; i < nums.length; i += 3)
        {
            if (nums[i + 2] - nums[i] > k)
            {
                return new int[0][0];
            }
            ans[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return ans;
    }
}
public class _2966_Divide_Array_Into_Arrays_With_Max_Difference_
{
    public static void main(String[] args)
    {
        int[] nums = {1, 3, 4, 8, 7, 9};
        int k = 2;

        int[][] result = DivideArray.divideArray(nums, k);

        if (result.length == 0)
        {
            System.out.println("[]");
        }
        else
        {
            for (int[] group : result)
            {
                System.out.println(Arrays.toString(group));
            }
        }
    }
}