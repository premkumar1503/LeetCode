import java.util.*;

class GetWordsInLongestSubsequence
{

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups)
    {
        int n = groups.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++)
            {
                if (check(words[i], words[j])
                        && dp[j] + 1 > dp[i]
                        && groups[i] != groups[j])
                {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex])
            {
                maxIndex = i;
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = prev[i])
        {
            ans.add(words[i]);
            if (prev[i] == -1) break;
        }
        Collections.reverse(ans);
        return ans;
    }

    private boolean check(String s1, String s2)
    {
        if (s1.length() != s2.length()) return false;

        int diff = 0;
        for (int i = 0; i < s1.length(); i++)
        {
            if (s1.charAt(i) != s2.charAt(i))
            {
                if (++diff > 1) return false;
            }
        }
        return diff == 1;
    }
}
public class _2901_Longest_Unequal_Adjacent_Groups_Subsequence_II_
{
    public static void main(String[] args)
    {
        GetWordsInLongestSubsequence sol = new GetWordsInLongestSubsequence();

        String[] words = {"aba", "bbb", "bab"};
        int[] groups = {1, 1, 2};

        List<String> result = sol.getWordsInLongestSubsequence(words, groups);
        System.out.println("Longest valid subsequence:");
        for (String word : result)
        {
            System.out.println(word);
        }
    }
}