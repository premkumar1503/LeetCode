import java.util.*;

class FindEvenNumbers
{
    public int[] findEvenNumbers(int[] digits)
    {
        Set<Integer> nums = new HashSet<>();
        int n = digits.length;

        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                for (int k = 0; k < n; ++k)
                {
                    if (i == j || j == k || i == k)
                    {
                        continue;
                    }
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num >= 100 && num % 2 == 0)

                    {
                        nums.add(num);
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>(nums);
        Collections.sort(res);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); ++i)
        {
            result[i] = res.get(i);
        }
        return result;
    }
}
public class _2094_Finding_3_Digit_Even_Numbers_
{
    public static void main(String[] args)
    {
        FindEvenNumbers sol = new FindEvenNumbers();

        int[] digits = {2, 1, 3, 0};
        int[] evenNumbers = sol.findEvenNumbers(digits);

        System.out.println("3-digit even numbers:");
        for (int num : evenNumbers) {
            System.out.print(num + " ");
        }
    }
}
