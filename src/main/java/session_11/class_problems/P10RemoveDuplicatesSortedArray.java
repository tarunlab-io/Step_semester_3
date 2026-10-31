package session_11.class_problems;

import java.util.Arrays;

/** Removes consecutive duplicates from a sorted array in place. */
public class P10RemoveDuplicatesSortedArray {
    /** Returns the unique-prefix length; O(n) time and O(1) extra space. */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int write = 1;
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[write - 1]) nums[write++] = nums[read];
        }
        return write;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 3, 4};
        int uniqueCount = removeDuplicates(nums);
        System.out.println("unique count = " + uniqueCount);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, uniqueCount)));
    }
}
