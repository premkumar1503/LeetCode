import java.util.*;

class Solution12
{
    public List<Integer> partitionLabels(String s)
    {
        List<Integer> result = new ArrayList<>();
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++)
        {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++)
        {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);

            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}

public class _763_Partition_Labels_
{
    public static void main(String[] args)
    {
        Solution12 sol = new Solution12();
        System.out.println(sol.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
