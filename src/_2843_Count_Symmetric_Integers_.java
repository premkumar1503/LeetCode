class Solution19
{
    public static int countSymmetricIntegers(int low, int high)
    {
        int count = 0;

        for (int i = low; i <= high; i++)
        {
            String num = String.valueOf(i);
            int len = num.length();

            if (len % 2 != 0) continue;

            int half = len / 2;
            int sum1 = 0, sum2 = 0;

            for (int j = 0; j < half; j++)
            {
                sum1 += num.charAt(j) - '0';
                sum2 += num.charAt(j + half) - '0';
            }

            if (sum1 == sum2)
            {
                count++;
            }
        }
        return count;
    }
}

public class _2843_Count_Symmetric_Integers_
{
    public static void main(String[] args)
    {
        Solution19 sol = new Solution19();
        int low = 1;
        int high = 1000;

        int result = sol.countSymmetricIntegers(low, high);
        System.out.println("Number of symmetric integers between " + low + " and " + high + ": " + result);
    }
}
