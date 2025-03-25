import java.util.Arrays;

class Solution3 {

    public boolean checkValidCuts(int n, int[][] rectangles)
    {
        return checkCuts(rectangles, 0) || checkCuts(rectangles, 1);
    }
    private boolean checkCuts(int[][] rectangles, int dim)
    {
        int gapCount = 0;
        Arrays.sort(rectangles, (a, b) -> Integer.compare(a[dim], b[dim]));
        int furthestEnd = rectangles[0][dim + 2];

        for (int i = 1; i < rectangles.length; i++) {
            int[] rect = rectangles[i];
            if (furthestEnd <= rect[dim]) {
                gapCount++;
            }
            furthestEnd = Math.max(furthestEnd, rect[dim + 2]);
        }
        return gapCount >= 2;
    }
}
public class _3394_Check_if_Grid_can_be_Cut_into_Sections_ {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        // Test case: Example input
        int n = 4;
        int[][] rectangles = {
                {1, 1, 4, 4},
                {2, 2, 5, 5},
                {6, 1, 8, 4},
                {7, 2, 9, 5}
        };

        boolean result = solution.checkValidCuts(n, rectangles);
        System.out.println("Can the rectangles be separated with at least two valid cuts? " + result);
    }
}