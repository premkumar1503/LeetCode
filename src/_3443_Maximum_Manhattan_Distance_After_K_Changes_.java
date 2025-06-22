class MaxDistance
{
    public int maxDistance(String s, int k)
    {
        int ans = 0;
        int north = 0, south = 0, east = 0, west = 0;

        for (char it : s.toCharArray())
        {
            switch (it) {
                case 'N':
                    north++;
                    break;
                case 'S':
                    south++;
                    break;
                case 'E':
                    east++;
                    break;
                case 'W':
                    west++;
                    break;
            }
            int times1 = Math.min(Math.min(north, south), k);
            int times2 = Math.min(Math.min(east, west), k - times1);

            ans = Math.max(ans, count(north, south, times1) + count(east, west, times2));
        }
        return ans;
    }
    private int count(int drt1, int drt2, int times)
    {
        return Math.abs(drt1 - drt2) + times * 2;
    }
}
public class _3443_Maximum_Manhattan_Distance_After_K_Changes_
{
    public static void main(String[] args)
    {
        MaxDistance sol = new MaxDistance();

        String s = "NESWNEWN";
        int k = 2;
        int result = sol.maxDistance(s, k);
        System.out.println("Maximum Manhattan Distance after " + k + " changes: " + result);
    }
}