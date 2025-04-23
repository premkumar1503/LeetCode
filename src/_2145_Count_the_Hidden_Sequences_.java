class CountHiddenSequences
{
    public int numberOfArrays(int[] differences, int lower, int upper)
    {
        long prefixSum = 0;
        long minPrefix = 0;
        long maxPrefix = 0;

        for (int diff : differences)
        {
            prefixSum += diff;
            minPrefix = Math.min(minPrefix, prefixSum);
            maxPrefix = Math.max(maxPrefix, prefixSum);
        }

        long validStartCount = (long) (upper - lower) - (maxPrefix - minPrefix) + 1;
        return (int) Math.max(0, validStartCount);
    }
}
public class _2145_Count_the_Hidden_Sequences_
{
    public static void main(String[] args)
    {
        int[] differences = {1, -3, 4};
        int lower = 1;
        int upper = 6;

        CountHiddenSequences sol = new CountHiddenSequences();
        int result = sol.numberOfArrays(differences, lower, upper);

        System.out.println("Number of hidden sequences: " + result);
    }
}
