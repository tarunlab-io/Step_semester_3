package session_11.assignment_problems;

import java.util.Arrays;

/** Sorts the photo line from shortest to tallest with adjacent swaps. */
public class P01HeightLineUp {
    /**
     * Performs left-to-right bubble-sort sweeps and prints the line after each sweep.
     * Stops after the first sweep that makes no swaps.
     * Time: O(n^2) worst case; extra space: O(1), apart from printing.
     */
    public static void lineUp(int[] heights) {
        for (int pass = 1; pass < heights.length; pass++) {
            boolean swapped = false;
            for (int i = 0; i < heights.length - 1; i++) {
                if (heights[i] > heights[i + 1]) {
                    int temp = heights[i];
                    heights[i] = heights[i + 1];
                    heights[i + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        lineUp(new int[] {4, 2, 5, 1});
        System.out.println();
        lineUp(new int[] {1, 3, 2, 4});
    }
}

