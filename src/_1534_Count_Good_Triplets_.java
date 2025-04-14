class Solution22
{
    public static int countGoodTriplets(int[] arr, int a, int b, int c)
    {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n - 2; i++)
        {
            for (int j = i + 1; j < n - 1; j++)
            {
                if (Math.abs(arr[i] - arr[j]) <= a)
                {
                    for (int k = j + 1; k < n; k++)
                    {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c)
                        {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
public class _1534_Count_Good_Triplets_
{
    public static void main(String[] args)
    {
        int[] arr = {3, 0, 1, 1, 9, 7};
        int a = 7;
        int b = 2;
        int c = 3;

        int result = Solution22.countGoodTriplets(arr, a, b, c);
        System.out.println("Count of good triplets: " + result);
    }
}
