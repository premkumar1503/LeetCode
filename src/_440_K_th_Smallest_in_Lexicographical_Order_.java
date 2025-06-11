class FindKthNumber
{
    public int findKthNumber(int n, int k)
    {
        int curr = 1;
        k--;

        while (k > 0)
        {
            int step = countSteps(n, curr, curr + 1);
            if (step <= k)
            {
                curr++;
                k -= step;
            }
            else
            {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }
    private int countSteps(int n, long prefix1, long prefix2)
    {
        int steps = 0;
        while (prefix1 <= n)
        {
            steps += Math.min(n + 1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }
}
public class _440_K_th_Smallest_in_Lexicographical_Order_
{
    public static void main(String[] args)
    {
        FindKthNumber solution = new FindKthNumber();

        int n = 100;
        int k = 10;

        int result = solution.findKthNumber(n, k);
        System.out.println("The " + k + "-th smallest number in lexicographical order from 1 to " + n + " is: " + result);
    }
}