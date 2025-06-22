import java.util.*;

class DivideStringIntoGroups
{
    static class Solution
    {
        public String[] divideString(String s, int k, char fill)
        {
            List<String> res = new ArrayList<>();
            int n = s.length();
            int curr = 0;

            while (curr < n)
            {
                int end = Math.min(curr + k, n);
                res.add(s.substring(curr, end));
                curr += k;
            }
            String last = res.get(res.size() - 1);
            if (last.length() < k)
            {
                last += String.valueOf(fill).repeat(k - last.length());
                res.set(res.size() - 1, last);
            }
            return res.toArray(new String[0]);
        }
    }
}
public class _2138_Divide_a_String_Into_Groups_of_Size_k_
{
    public static void main(String[] args)
    {
        DivideStringIntoGroups.Solution solution = new DivideStringIntoGroups.Solution();
        String s = "abcdefghi";
        int k = 3;
        char fill = 'x';

        String[] result = solution.divideString(s, k, fill);

        System.out.println("Divided Groups:");
        for (String str : result) {
            System.out.println(str);
        }
    }
}
