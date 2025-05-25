import java.util.*;

class FindWordsContaining
{
    public static List<Integer> findWordsContaining(String[] words, char x)
    {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++)
        {
            if (words[i].indexOf(x) != -1)
            {
                result.add(i);
            }
        }
        return result;
    }
}
public class _2942_Find_Words_Containing_Character_
{
    public static void main(String[] args)
    {
        String[] words = {"apple", "banana", "cherry", "date", "elderberry"};
        char x = 'e';

        List<Integer> indices = FindWordsContaining.findWordsContaining(words, x);

        System.out.println("Indices of words containing '" + x + "': " + indices);

        System.out.print("Words containing '" + x + "': ");
        for (int idx : indices)
        {
            System.out.print(words[idx] + " ");
        }
    }
}
