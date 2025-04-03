import java.util.Arrays;

class Solution11
{
    public static long putMarbles(int[] weights, int k)
    {
        int n = weights.length;
        if (k == 1) return 0;

        int[] pairSums = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            pairSums[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(pairSums);

        long minScore = 0, maxScore = 0;

        for (int i = 0; i < k - 1; i++) {
            minScore += pairSums[i];
        }

        for (int i = n - 2; i >= n - k; i--) {
            maxScore += pairSums[i];
        }

        return maxScore - minScore;
    }
}
public class _2551_Put_Marbles_in_Bags_
{
    public static void main(String[] args)
    {
        int[] weights1 = {1, 3, 5, 1};
        int k1 = 2;
        System.out.println("Result (Example 1): " + Solution11.putMarbles(weights1, k1));

        int[] weights2 = {1, 3};
        int k2 = 2;
        System.out.println("Result (Example 2): " + Solution11.putMarbles(weights2, k2));
    }
}
