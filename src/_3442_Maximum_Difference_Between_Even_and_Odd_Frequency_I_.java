import java.util.HashMap;
import java.util.Map;

class MaxDifference2
{
    public int maxDifference(String s)
    {
        Map<Character, Integer> c = new HashMap<>();
        for (char ch : s.toCharArray())
        {
            c.put(ch, c.getOrDefault(ch, 0) + 1);
        }
        int maxOdd = 1;
        int minEven = s.length();

        for (int value : c.values())
        {
            if (value % 2 == 1)
            {
                maxOdd = Math.max(maxOdd, value);
            }
            else
            {
                minEven = Math.min(minEven, value);
            }
        }
        return maxOdd - minEven;
    }
}
public class _3442_Maximum_Difference_Between_Even_and_Odd_Frequency_I_
{
    public static void main(String[] args) {
        MaxDifference2 sol = new MaxDifference2();

        String test1 = "aabbccc";
        String test2 = "aaaabbbbcccc";
        String test3 = "aabcc";

        System.out.println("Result for test1: " + sol.maxDifference(test1));
        System.out.println("Result for test2: " + sol.maxDifference(test2));
        System.out.println("Result for test3: " + sol.maxDifference(test3));
    }
}
