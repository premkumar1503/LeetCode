class DistributeCandies
{
    public long distributeCandies(int n, int limit)
    {
        return (
                cal(n + 2) -
                3 * cal(n - limit + 1) +
                3 * cal(n - (limit + 1) * 2 + 2) -
                cal(n - 3 * (limit + 1) + 2)
        );
    }
    public long cal(int x)
    {
        if (x < 0)
        {
            return 0;
        }
        return ((long) x * (x - 1)) / 2;
    }
}
public class _2929_Distribute_Candies_Among_Children_II_
{
    public static void main(String[] args)
    {
        DistributeCandies sol = new DistributeCandies();

        int n1 = 5, limit1 = 2;
        int n2 = 10, limit2 = 3;

        System.out.println("Ways to distribute " + n1 + " candies with limit " + limit1 + ": " + sol.distributeCandies(n1, limit1));
        System.out.println("Ways to distribute " + n2 + " candies with limit " + limit2 + ": " + sol.distributeCandies(n2, limit2));
    }
}