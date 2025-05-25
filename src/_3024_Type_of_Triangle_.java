import java.util.Arrays;

class TriangleType
{
    public String triangleType(int[] nums)
    {
        Arrays.sort(nums);

        if (nums[0] + nums[1] <= nums[2])
        {
            return "none";
        }
        else if (nums[0] == nums[2])
        {
            return "equilateral";
        }
        else if (nums[0] == nums[1] || nums[1] == nums[2])
        {
            return "isosceles";
        }
        else
        {
            return "scalene";
        }
    }
}
public class _3024_Type_of_Triangle_
{
    public static void main(String[] args)
    {
        TriangleType sol = new TriangleType();

        int[][] testCases = {
                {3, 3, 3},
                {3, 3, 5},
                {3, 4, 5},
                {1, 2, 3},
                {5, 10, 25}
        };
        for (int[] triangle : testCases)
        {
            System.out.println("Triangle: " + Arrays.toString(triangle) + " -> " + sol.triangleType(triangle));
        }
    }
}
