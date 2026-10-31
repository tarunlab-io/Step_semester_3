package session_11.assignment_problems;

import java.util.Arrays;

/** Sorts marks from highest to lowest using selection sort. */
public class P02PrizeTable {
    /**
     * Mutates marks into descending order and returns the number of actual swaps.
     * A position already holding the round's maximum does not count as a swap.
     * Time: O(n^2); extra space: O(1).
     */
    public static int prizeTable(int[] marks) {
        int swaps = 0;
        for (int position = 0; position < marks.length - 1; position++) {
            int largestIndex = position;
            for (int i = position + 1; i < marks.length; i++) {
                if (marks[i] > marks[largestIndex]) largestIndex = i;
            }
            if (largestIndex != position) {
                int temp = marks[position];
                marks[position] = marks[largestIndex];
                marks[largestIndex] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        int[] first = {45, 90, 60, 75};
        int firstSwaps = prizeTable(first);
        System.out.println(Arrays.toString(first) + "  swaps = " + firstSwaps);

        int[] second = {80, 70, 60};
        int secondSwaps = prizeTable(second);
        System.out.println(Arrays.toString(second) + "  swaps = " + secondSwaps);
    }
}
