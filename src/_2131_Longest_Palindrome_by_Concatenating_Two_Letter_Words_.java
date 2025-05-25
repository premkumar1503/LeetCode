import java.util.HashMap;
import java.util.Map;

class LongestPalindrome
{
    public int longestPalindrome(String[] words)
    {
        Map<String, Integer> count = new HashMap<>();
        int result = 0;
        boolean usedCenter = false;

        for (String w : words)
        {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }

        for (String w : count.keySet())
        {
            String rev = new StringBuilder(w).reverse().toString();
            int c = count.get(w);

            if (w.equals(rev))
            {
                result += (c / 2) * 4;
                if (!usedCenter && c % 2 == 1)
                {
                    result += 2;
                    usedCenter = true;
                }
            }
            else if (w.compareTo(rev) < 0 && count.containsKey(rev))
            {
                result += 4 * Math.min(c, count.get(rev));
            }
        }
        return result;
    }
}
public class _2131_Longest_Palindrome_by_Concatenating_Two_Letter_Words_
{
    public static void main(String[] args)
    {
        LongestPalindrome sol = new LongestPalindrome();

        String[] words1 = {"lc", "cl", "gg"};
        System.out.println("Test case 1 output: " + sol.longestPalindrome(words1));

        String[] words2 = {"ab", "ty", "yt", "lc", "cl", "ab"};
        System.out.println("Test case 2 output: " + sol.longestPalindrome(words2));

        String[] words3 = {"cc", "ll", "xx"};
        System.out.println("Test case 3 output: " + sol.longestPalindrome(words3));
    }
}
