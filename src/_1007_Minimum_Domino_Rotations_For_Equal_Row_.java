public class _1007_Minimum_Domino_Rotations_For_Equal_Row_
{
    public static void main(String[] args)
    {
        int[] tops =    {2, 1, 2, 4, 2, 2};
        int[] bottoms = {5, 2, 6, 2, 3, 2};

        int result = minDominoRotations(tops, bottoms);
        System.out.println("Minimum rotations needed: " + result);
    }
    public static int minDominoRotations(int[] tops, int[] bottoms)
    {
        int result = check(tops[0], tops, bottoms);
        if (result != -1 || tops[0] == bottoms[0]) return result;
        return check(bottoms[0], tops, bottoms);
    }
    private static int check(int target, int[] tops, int[] bottoms)
    {
        int rotateTop = 0;
        int rotateBottom = 0;

        for (int i = 0; i < tops.length; i++)
        {
            if (tops[i] != target && bottoms[i] != target)
            {
                return -1; // Not possible
            }
            else if (tops[i] != target)
            {
                rotateTop++;
            }
            else if (bottoms[i] != target)
            {
                rotateBottom++;
            }
        }
        return Math.min(rotateTop, rotateBottom);
    }
}
