import java.util.*;

class MaxTaskAssign
{
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength)
    {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int left = 0, right = Math.min(tasks.length, workers.length), answer = 0;

        while (left <= right)
        {
            int mid = (left + right) / 2;
            if (canAssign(mid, tasks, workers, pills, strength))
            {
                answer = mid;
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return answer;
    }
    private boolean canAssign(int k, int[] tasks, int[] workers, int pills, int strength)
    {
        Deque<Integer> taskDeque = new ArrayDeque<>();
        for (int i = k - 1; i >= 0; i--)
        {
            taskDeque.addFirst(tasks[i]);
        }
        TreeMap<Integer, Integer> workerMap = new TreeMap<>();
        for (int i = workers.length - k; i < workers.length; i++)
        {
            workerMap.put(workers[i], workerMap.getOrDefault(workers[i], 0) + 1);
        }
        int pillsLeft = pills;

        while (!taskDeque.isEmpty())
        {
            int task = taskDeque.removeLast();

            Integer worker = workerMap.ceilingKey(task);
            if (worker != null)
            {
                decrement(workerMap, worker);
                continue;
            }
            if (pillsLeft > 0)
            {
                worker = workerMap.ceilingKey(task - strength);
                if (worker != null)
                {
                    decrement(workerMap, worker);
                    pillsLeft--;
                    continue;
                }
            }
            return false;
        }
        return true;
    }
    private void decrement(TreeMap<Integer, Integer> map, int key)
    {
        if (map.get(key) == 1)
        {
            map.remove(key);
        }
        else
        {
            map.put(key, map.get(key) - 1);
        }
    }
}
public class _2071_Maximum_Number_of_Tasks_You_Can_Assign_
{
    public static void main(String[] args)
    {
        MaxTaskAssign solution = new MaxTaskAssign();

        int[] tasks = {3, 6, 9, 12};
        int[] workers = {5, 8, 7, 10};
        int pills = 1;
        int strength = 2;

        int result = solution.maxTaskAssign(tasks, workers, pills, strength);
        System.out.println("Maximum number of tasks that can be assigned: " + result);
    }
}