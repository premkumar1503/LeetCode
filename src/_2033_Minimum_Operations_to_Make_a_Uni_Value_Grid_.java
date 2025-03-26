import java.util.*;

class MinOperationsUniValueGrid
{
    public int minOperations(int[][] grid, int x)
    {
        List<Integer> values = new ArrayList<>();
        int m = grid.length, n = grid[0].length;

        int remainder = grid[0][0] % x;
        for (int[] row : grid)
        {
            for (int num : row)
            {
                if (num % x != remainder)
                {
                    return -1;
                }
                values.add(num);
            }
        }

        Collections.sort(values);
        int median = values.get(values.size() / 2);

        int operations = 0;
        for (int num : values) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}
public class _2033_Minimum_Operations_to_Make_a_Uni_Value_Grid_
{
    public static void main(String[] args) {
        MinOperationsUniValueGrid solution = new MinOperationsUniValueGrid();
        int[][] grid = {{2, 4}, {6, 8}};
        int x = 2;
        System.out.println(solution.minOperations(grid, x));
    }
}
