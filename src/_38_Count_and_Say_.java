class CountAndSay
{
    public static String countAndSay(int n)
    {
        if (n == 1) return "1";

        String prev = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();

        int count = 1;
        char say = prev.charAt(0);

        for (int i = 1; i < prev.length(); i++)
        {
            if (prev.charAt(i) == say)
            {
                count++;
            }
            else
            {
                result.append(count).append(say);
                count = 1;
                say = prev.charAt(i);
            }
        }
        result.append(count).append(say);
        return result.toString();
    }
}

public class _38_Count_and_Say_
{
    public static void main(String[] args) {
        int n = 6;
        String result = CountAndSay.countAndSay(n);
        System.out.println("Count and Say of " + n + " is: " + result);
    }
}
