class GoodTriplets
{
    public long goodTriplets(int[] nums1, int[] nums2)
    {
        int n = nums1.length;
        int[] pos = new int[n];

        for (int i = 0; i < n; i++)
        {
            pos[nums2[i] - 1] = i;
        }

        int[] indexInNums2 = new int[n];

        for (int i = 0; i < n; i++)
        {
            indexInNums2[i] = pos[nums1[i] - 1];
        }

        FenwickTree leftBIT = new FenwickTree(n);
        FenwickTree rightBIT = new FenwickTree(n);

        for (int i = 0; i < n; i++)
        {
            rightBIT.update(indexInNums2[i], 1);
        }

        long count = 0;
        for (int i = 0; i < n; i++)
        {
            int idx = indexInNums2[i];
            rightBIT.update(idx, -1);

            long leftCount = leftBIT.query(idx - 1);
            long rightCount = rightBIT.query(n - 1) - rightBIT.query(idx);

            count += leftCount * rightCount;

            leftBIT.update(idx, 1);
        }
        return count;
    }

    class FenwickTree
    {
        long[] tree;
        int n;

        FenwickTree(int size)
        {
            this.n = size;
            tree = new long[n + 1];
        }

        void update(int index, int delta)
        {
            index++;
            while (index <= n) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        long query(int index)
        {
            index++;
            long sum = 0;
            while (index > 0)
            {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }
}

public class _2179_Count_Good_Triplets_in_an_Array_
{
    public static void main(String[] args)
    {
        GoodTriplets solution = new GoodTriplets();

        int[] nums1 = {3, 1, 2};
        int[] nums2 = {2, 1, 3};
        long result = solution.goodTriplets(nums1, nums2);
        System.out.println("Number of good triplets: " + result);

        int[] nums1_2 = {1, 2, 3};
        int[] nums2_2 = {1, 2, 3};
        long result2 = solution.goodTriplets(nums1_2, nums2_2);
        System.out.println("Number of good triplets: " + result2);

        int[] nums1_3 = {1, 3, 2, 4, 5};
        int[] nums2_3 = {1, 2, 3, 4, 5};
        long result3 = solution.goodTriplets(nums1_3, nums2_3);
        System.out.println("Number of good triplets: " + result3);
    }
}
