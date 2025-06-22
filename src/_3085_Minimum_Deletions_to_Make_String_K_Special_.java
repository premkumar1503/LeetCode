import java.util.*;

class MinimumDeletions
{
    public int minimumDeletions(String word, int k)
    {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char ch : word.toCharArray())
        {
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
        }
        int res = word.length();
        for (int a : cnt.values())
        {
            int deleted = 0;
            for (int b : cnt.values())
            {
                if (a > b)
                {
                    deleted += b;
                }
                else if (b > a + k)
                {
                    deleted += b - (a + k);
                }
            }
            res = Math.min(res, deleted);
        }
        return res;
    }
}
public class _3085_Minimum_Deletions_to_Make_String_K_Special_
{
    public static void main(String[] args)
    {
        MinimumDeletions sol = new MinimumDeletions();

        String word = "aaabaaa";
        int k = 1;

        int result = sol.minimumDeletions(word, k);
        System.out.println("Minimum deletions: " + result);
    }
}