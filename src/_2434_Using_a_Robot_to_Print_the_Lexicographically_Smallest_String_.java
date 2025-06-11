import java.util.Stack;

class RobotWithString
{
    public String robotWithString(String s)
    {
        int[] cnt = new int[26];
        for (char c : s.toCharArray())
        {
            cnt[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        char minCharacter = 'a';
        for (char c : s.toCharArray())
        {
            stack.push(c);
            cnt[c - 'a']--;
            while (minCharacter != 'z' && cnt[minCharacter - 'a'] == 0)
            {
                minCharacter++;
            }
            while (!stack.isEmpty() && stack.peek() <= minCharacter)
            {
                res.append(stack.pop());
            }
        }
        return res.toString();
    }
}
public class _2434_Using_a_Robot_to_Print_the_Lexicographically_Smallest_String_
{
    public static void main(String[] args)
    {
        RobotWithString sol = new RobotWithString();

        String input = "zza";
        String result = sol.robotWithString(input);

        System.out.println("Input: " + input);
        System.out.println("Lexicographically Smallest String: " + result);
    }
}
