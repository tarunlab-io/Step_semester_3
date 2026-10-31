package session_11.class_problems;

import java.util.ArrayList;
import java.util.List;

/** Returns all cells of a rectangular grid in clockwise spiral order. */
public class P08SpiralOrderTraversal {
    /** O(m*n) time and O(m*n) output space. */
    public static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        if (grid.length == 0 || grid[0].length == 0) return result;

        int top = 0, bottom = grid.length - 1;
        int left = 0, right = grid[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int column = left; column <= right; column++) result.add(grid[top][column]);
            top++;
            for (int row = top; row <= bottom; row++) result.add(grid[row][right]);
            right--;
            if (top <= bottom) {
                for (int column = right; column >= left; column--) result.add(grid[bottom][column]);
                bottom--;
            }
            if (left <= right) {
                for (int row = bottom; row >= top; row--) result.add(grid[row][left]);
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(grid));
    }
}
