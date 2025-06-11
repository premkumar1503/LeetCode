class AnswerString
{
    public String answerString(String word, int numFriends)
    {
        if (numFriends == 1)
        {
            return word;
        }
        int n = word.length();
        String res = "";
        for (int i = 0; i < n; i++)
        {
            String s = word.substring(i, Math.min(i + n - numFriends + 1, n));
            if (res.compareTo(s) <= 0)
            {
                res = s;
            }
        }
        return res;
    }
}
public class _3403_Find_the_Lexicographically_Largest_String_From_the_Box_I_
{
    public static void main(String[] args)
    {
        AnswerString solution = new AnswerString();

        String word = "leetcode";
        int numFriends = 3;

        String result = solution.answerString(word, numFriends);
        System.out.println("Lexicographically largest string: " + result);
    }
}