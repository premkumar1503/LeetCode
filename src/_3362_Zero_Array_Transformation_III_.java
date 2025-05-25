import java.util.*;

class MaxRemoval
{
    public int maxRemoval(int[] nums, int[][] queries)
    {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int[] deltaArray = new int[nums.length + 1];
        int operations = 0;

        for (int i = 0, j = 0; i < nums.length; i++)
        {
            operations += deltaArray[i];
            while (j < queries.length && queries[j][0] == i)
            {
                heap.offer(queries[j][1]);
                j++;
            }
            while (operations < nums[i] && !heap.isEmpty() && heap.peek() >= i)
            {
                operations += 1;
                deltaArray[heap.poll() + 1] -= 1;
            }
            if (operations < nums[i])
            {
                return -1;
            }
        }
        return heap.size();
    }
}
public class _3362_Zero_Array_Transformation_III_
{
    public static void main(String[] args)
    {
        MaxRemoval sol = new MaxRemoval();

        int[] nums1 = {1, 2, 3};
        int[][] queries1 = {{0, 2}, {1, 2}, {0, 1}};

        System.out.println("Result 1: " + sol.maxRemoval(nums1, queries1));

        int[] nums2 = {2, 2, 2};
        int[][] queries2 = {{0, 1}, {1, 2}};

        System.out.println("Result 2: " + sol.maxRemoval(nums2, queries2));
    }
}
