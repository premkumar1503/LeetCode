class FindNumbers
{
    public int findNumbers(int[] nums)
    {
        int count = 0;
        for (int num : nums)
        {
            if (String.valueOf(num).length() % 2 == 0)
            {
                count++;
            }
        }
        return count;
    }
}
public class _1295_Find_Numbers_with_Even_Number_of_Digits_
{
    public static void main(String[] args)
    {
        FindNumbers solution = new FindNumbers();

        int[] nums = {12, 345, 2, 6, 7896};

        int result = solution.findNumbers(nums);
        System.out.println("Count of numbers with even digits: " + result);
    }
}
