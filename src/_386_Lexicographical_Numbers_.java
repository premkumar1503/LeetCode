import java.util.ArrayList;
import java.util.List;

class LexicalOrder
{
    public List<Integer> lexicalOrder(int n)
    {
        List<Integer> lexicographicalNumbers = new ArrayList<>();

        for (int start = 1; start <= 9; ++start)
        {
            generateLexicalNumbers(start, n, lexicographicalNumbers);
        }
        return lexicographicalNumbers;
    }
    private void generateLexicalNumbers(int currentNumber, int limit, List<Integer> result)
    {
        if (currentNumber > limit) return;

        result.add(currentNumber);

        for (int nextDigit = 0; nextDigit <= 9; ++nextDigit)
        {
            int nextNumber = currentNumber * 10 + nextDigit;
            if (nextNumber <= limit)
            {
                generateLexicalNumbers(nextNumber, limit, result);
            }
            else
            {
                break;
            }
        }
    }
}
public class _386_Lexicographical_Numbers_
{
    public static void main(String[] args)
    {
        LexicalOrder solution = new LexicalOrder();
        int n = 50;
        List<Integer> result = solution.lexicalOrder(n);

        System.out.println("Lexicographical order from 1 to " + n + ":");
        for (int number : result)
        {
            System.out.print(number + " ");
        }
    }
}