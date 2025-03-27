import java.util.*;

class solution4
{
    public static int minimumIndex(List<Integer> nums) {
        int n = nums.size();

        int candidate = -1, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        int totalFreq = 0;
        for (int num : nums) {
            if (num == candidate) {
                totalFreq++;
            }
        }
        if (totalFreq * 2 <= n) {
            return -1; 
        }

        // Step 3: Try to split at the minimum valid index
        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == candidate) {
                leftCount++;
            }
            int rightCount = totalFreq - leftCount;

            if (leftCount * 2 > (i + 1) && rightCount * 2 > (n - i - 1)) {
                return i;
            }
        }

        return -1;
    }
}


public class _2780_Minimum_Index_of_a_Valid_Split_
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        List<Integer> nums = new ArrayList<>();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextInt());
        }

        int result = solution4.minimumIndex(nums);
        System.out.println("Minimum Index of a Valid Split: " + result);

        scanner.close();
    }
}
