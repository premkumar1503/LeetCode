import java.util.HashMap;
import java.util.Map;

public class _1128_Number_of_Equivalent_Domino_Pairs_
{
    public static void main(String[] args)
    {
        int[][] dominoes = {
                {1, 2}, {2, 1}, {3, 4}, {5, 6}
        };

        int result = numEquivDominoPairs(dominoes);
        System.out.println("Number of equivalent domino pairs: " + result);
    }
    public static int numEquivDominoPairs(int[][] dominoes)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int[] domino : dominoes)
        {
            int a = domino[0];
            int b = domino[1];

            int key = a < b ? a * 10 + b : b * 10 + a;

            count += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return count;
    }
}
