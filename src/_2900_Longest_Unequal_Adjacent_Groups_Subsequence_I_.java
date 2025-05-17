import java.util.*;

class GetLongestSubsequence {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        int maxLen = 1, endIndex = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
        }
        for (int i = 1; i < n; i++) {
            int bestLen = 1;
            int bestPrev = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (groups[i] != groups[j] && dp[j] + 1 > bestLen) {
                    bestLen = dp[j] + 1;
                    bestPrev = j;
                }
            }
            dp[i] = bestLen;
            prev[i] = bestPrev;
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                endIndex = i;
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = endIndex; i != -1; i = prev[i]) {
            res.add(words[i]);
        }
        Collections.reverse(res);
        return res;
    }
}
public class _2900_Longest_Unequal_Adjacent_Groups_Subsequence_I_
{
    public static void main(String[] args)
    {
        GetLongestSubsequence sol = new GetLongestSubsequence();

        String[] words = {"a", "b", "b", "a", "c", "d"};
        int[] groups = {1, 2, 2, 1, 3, 1};

        List<String> result = sol.getLongestSubsequence(words, groups);

        System.out.println("Longest valid subsequence:");
        for (String word : result)
        {
            System.out.print(word + " ");
        }
    }
}