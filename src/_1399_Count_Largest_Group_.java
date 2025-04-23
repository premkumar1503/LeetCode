import java.util.*;

class CountLargestGroup
{
    public static int countLargestGroup(int n)
    {
        Map<Integer, Integer> digitSumMap = new HashMap<>();

        for (int i = 1; i <= n; i++)
        {
            int sum = getDigitSum(i);
            digitSumMap.put(sum, digitSumMap.getOrDefault(sum, 0) + 1);
        }

        int maxSize = 0;
        for (int size : digitSumMap.values())
        {
            maxSize = Math.max(maxSize, size);
        }

        int count = 0;
        for (int size : digitSumMap.values())
        {
            if (size == maxSize) {
                count++;
            }
        }
        return count;
    }
    private static int getDigitSum(int num)
    {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

public class _1399_Count_Largest_Group_
{
    public static void main(String[] args)
    {
        int n = 10;
        int result = CountLargestGroup.countLargestGroup(n);
        System.out.println("Number of groups with the largest size: " + result);
    }
}