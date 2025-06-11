import java.util.*;

class ClearStars
{
    public String clearStars(String s)
    {
        Deque<Integer>[] cnt = new Deque[26];
        for (int i = 0; i < 26; i++)
        {
            cnt[i] = new ArrayDeque<>();
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] != '*')
            {
                cnt[arr[i] - 'a'].push(i);
            }
            else
            {
                for (int j = 0; j < 26; j++)
                {
                    if (!cnt[j].isEmpty())
                    {
                        arr[cnt[j].pop()] = '*';
                        break;
                    }
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : arr) {
            if (c != '*') {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
public class _3170_Lexicographically_Minimum_String_After_Removing_Stars_
{
    public static void main(String[] args)
    {
        ClearStars sol = new ClearStars();

        String input1 = "abc*de*";
        System.out.println("Input: " + input1);
        System.out.println("Output: " + sol.clearStars(input1));

        String input2 = "a*b*c*";
        System.out.println("Input: " + input2);
        System.out.println("Output: " + sol.clearStars(input2));

        String input3 = "leet**cod*e";
        System.out.println("Input: " + input3);
        System.out.println("Output: " + sol.clearStars(input3));
    }
}
