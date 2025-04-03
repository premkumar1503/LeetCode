class Solution10
{
    public static long mostPoints(int[][] questions)
    {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--)
        {
            int points = questions[i][0];
            int brainpower = questions[i][1];

            int nextIndex = i + brainpower + 1;
            long solve = points + (nextIndex < n ? dp[nextIndex] : 0);

            long skip = dp[i + 1];

            dp[i] = Math.max(solve, skip);
        }
        return dp[0];
    }
}
public class _2140_Solving_Questions_With_Brainpower_
{
    public static void main(String[] args)
    {
        int[][] questions1 = {{3, 2}, {4, 3}, {4, 4}, {2, 5}};
        int[][] questions2 = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};

        System.out.println("Max Points (questions1): " + Solution10.mostPoints(questions1));
        System.out.println("Max Points (questions2): " + Solution10.mostPoints(questions2));
    }
}
