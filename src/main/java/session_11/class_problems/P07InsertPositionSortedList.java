package session_11.class_problems;

/** Finds a value or its insertion index in a sorted array of distinct integers. */
public class P07InsertPositionSortedList {
    /** Lower-bound binary search: O(log n) time and O(1) extra space. */
    public static int searchInsertPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] < target) low = middle + 1;
            else high = middle;
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(searchInsertPosition(new int[] {1, 3, 5, 6}, 5));
        System.out.println(searchInsertPosition(new int[] {1, 3, 5, 6}, 2));
    }
}
