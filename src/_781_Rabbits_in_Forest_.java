import java.util.*;

class RabbitsInForest
{
    public int numRabbits(int[] answers)
    {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int ans : answers)
        {
            countMap.put(ans, countMap.getOrDefault(ans, 0) + 1);
        }
        int result = 0;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet())
        {
            int k = entry.getKey();
            int count = entry.getValue();
            int groupSize = k + 1;
            int groups = (count + k) / groupSize;
            result += groups * groupSize;
        }
        return result;
    }
}

public class _781_Rabbits_in_Forest_
{
    public static void main(String[] args)
    {
        int[] answers = {1, 3, 2};

        RabbitsInForest sol = new RabbitsInForest();
        int result = sol.numRabbits(answers);

        System.out.println("Minimum number of rabbits: " + result);
    }
}
