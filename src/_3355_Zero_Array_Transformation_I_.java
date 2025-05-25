class ZeroArrayTransformation {
    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            diff[left] += 1;
            if (right + 1 < n) {
                diff[right + 1] -= 1;
            }
        }
        int current = 0;
        for (int i = 0; i < n; i++) {
            current += diff[i];
            if (nums[i] > current) {
                return false;
            }
        }
        return true;
    }
}
public class _3355_Zero_Array_Transformation_I_
{
    public static void main(String[] args)
    {

        int[] nums = {1, 3, 2, 1};
        int[][] queries = {
                {0, 1},
                {1, 2},
                {2, 3}
        };

        boolean result = ZeroArrayTransformation.isZeroArray(nums, queries);
        System.out.println("Is zero array transformation possible? " + result);
    }
}
