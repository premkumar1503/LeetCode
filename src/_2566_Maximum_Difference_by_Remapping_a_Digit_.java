class MinMaxDifference
{
    static class Solution
    {
        public int minMaxDifference(int num)
        {
            String s = Integer.toString(num);
            String t = s;

            int pos = 0;
            while (pos < s.length() && s.charAt(pos) == '9')
            {
                pos++;
            }
            if (pos < s.length())
            {
                s = s.replace(s.charAt(pos), '9');
            }
            t = t.replace(t.charAt(0), '0');

            return Integer.parseInt(s) - Integer.parseInt(t);
        }
    }
}
public class _2566_Maximum_Difference_by_Remapping_a_Digit_
{
    public static void main(String[] args)
    {
        MinMaxDifference.Solution sol = new MinMaxDifference.Solution();

        int num = 11891;
        int result = sol.minMaxDifference(num);

        System.out.println("Maximum difference after remapping: " + result);
    }
}