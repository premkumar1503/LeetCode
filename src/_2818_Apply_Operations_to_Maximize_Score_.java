import java.util.*;

class Solution6
{
    final int MOD = 1000000007;

    public int maximumScore(List<Integer> nums, int k)
    {
        int n = nums.size();
        List<Integer> primeScores = new ArrayList<>(Collections.nCopies(n, 0));

        for (int index = 0; index < n; index++)
        {
            int num = nums.get(index);

            for (int factor = 2; factor <= Math.sqrt(num); factor++)
            {
                if (num % factor == 0)
                {
                    primeScores.set(index, primeScores.get(index) + 1);

                    while (num % factor == 0) num /= factor;
                }
            }

            if (num >= 2) primeScores.set(index, primeScores.get(index) + 1);
        }

        int[] nextDominant = new int[n];
        int[] prevDominant = new int[n];
        Arrays.fill(nextDominant, n);
        Arrays.fill(prevDominant, -1);

        Stack<Integer> decreasingPrimeScoreStack = new Stack<>();

        for (int index = 0; index < n; index++)
        {
            while (!decreasingPrimeScoreStack.isEmpty() && primeScores.get(decreasingPrimeScoreStack.peek()) < primeScores.get(index))
            {
                int topIndex = decreasingPrimeScoreStack.pop();
                nextDominant[topIndex] = index;
            }

            if (!decreasingPrimeScoreStack.isEmpty()) prevDominant[index] = decreasingPrimeScoreStack.peek();
            decreasingPrimeScoreStack.push(index);
        }

        long[] numOfSubarrays = new long[n];
        for (int index = 0; index < n; index++)
        {
            numOfSubarrays[index] = ((long) nextDominant[index] - index) * (index - prevDominant[index]);
        }

        PriorityQueue<int[]> processingQueue = new PriorityQueue<>((a, b) ->
        {
            if (b[0] == a[0])
            {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(b[0], a[0]);
        });

        for (int index = 0; index < n; index++)
        {
            processingQueue.offer(new int[]{nums.get(index), index});
        }

        long score = 1;

        while (k > 0)
        {
            int[] top = processingQueue.poll();
            int num = top[0];
            int index = top[1];

            long operations = Math.min((long) k, numOfSubarrays[index]);
            score = (score * power(num, operations)) % MOD;
            k -= operations;
        }

        return (int) score;
    }

    private long power(long base, long exponent)
    {
        long res = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1)
            {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent /= 2;
        }
        return res;
    }
}
public class _2818_Apply_Operations_to_Maximize_Score_
{
    public static void main(String[] args)
    {
        Solution6 sol = new Solution6();

        List<Integer> nums1 = Arrays.asList(8, 3, 9, 6, 2);
        int k1 = 2;
        System.out.println(sol.maximumScore(nums1, k1));

        List<Integer> nums2 = Arrays.asList(5, 10, 20);
        int k2 = 3;
        System.out.println(sol.maximumScore(nums2, k2));

        List<Integer> nums3 = Arrays.asList(1, 2, 3, 4, 5);
        int k3 = 2;
        System.out.println(sol.maximumScore(nums3, k3));
    }
}
