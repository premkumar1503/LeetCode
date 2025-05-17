class ThreeConsecutiveOdds
{
    public boolean threeConsecutiveOdds(int[] arr)
    {
        for (int i = 0; i < arr.length - 2; i++)
        {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1)
            {
                return true;
            }
        }
        return false;
    }
}
public class _1550_Three_Consecutive_Odds_
{
    public static void main(String[] args)
    {
        ThreeConsecutiveOdds sol = new ThreeConsecutiveOdds();

        int[] test1 = {2, 6, 4, 1};
        int[] test2 = {1, 2, 34, 3, 4, 5, 7, 23, 12};

        System.out.println("Test1 has three consecutive odds? " + sol.threeConsecutiveOdds(test1)); // false
        System.out.println("Test2 has three consecutive odds? " + sol.threeConsecutiveOdds(test2)); // true
    }
}
