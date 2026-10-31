package session_11.class_problems;

/** Finds a pair summing to a target in an ascending array. */
public class P09PairSumSortedArray {
    /** Returns the two zero-based indices, or {-1,-1}; O(n) time and O(1) extra space. */
    public static int[] pairSumSorted(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            long sum = (long) nums[left] + nums[right];
            if (sum == target) return new int[] {left, right};
            if (sum < target) left++;
            else right--;
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        printResult(pairSumSorted(new int[] {-4, -1, 0, 3, 5, 9}, 4));
        printResult(pairSumSorted(new int[] {1, 2, 3}, 100));
    }

    private static void printResult(int[] pair) {
        if (pair[0] == -1) System.out.println("Not Found");
        else System.out.printf("(%d, %d)%n", pair[0], pair[1]);
    }
}
