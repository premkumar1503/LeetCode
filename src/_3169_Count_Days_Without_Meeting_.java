
import java.util.*;

class Solution2
{
    public int countDays(int days, int[][] meetings)
    {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int freeDays = 0;
        int currentDay = 1;

        for (int[] meeting : meetings)
        {
            int start = meeting[0];
            int end = meeting[1];

            if (currentDay < start) {
                freeDays += (start - currentDay);
            }
            currentDay = Math.max(currentDay, end + 1);
        }
        if (currentDay <= days)
        {
            freeDays += (days - currentDay + 1);
        }

        return freeDays;
    }
}

public class _3169_Count_Days_Without_Meeting_
{
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int days = 10;
        int[][] meetings = {{5, 7}, {1, 3}, {9, 10}};
        System.out.println(sol.countDays(days, meetings));
    }
}
