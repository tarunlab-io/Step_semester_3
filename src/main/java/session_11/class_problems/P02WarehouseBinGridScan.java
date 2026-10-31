package session_11.class_problems;

/** Computes the total and the first row-major coordinate of the largest bin. */
public class P02WarehouseBinGridScan {
    /** Returns {totalItems, maxRow, maxColumn}; empty grids yield {0,-1,-1}.
     * O(m*n) time and O(1) extra space.
     */
    public static int[] warehouseSummary(int[][] grid) {
        long total = 0;
        int max = Integer.MIN_VALUE;
        int maxRow = -1;
        int maxColumn = -1;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                int value = grid[row][column];
                total += value;
                if (value > max) {
                    max = value;
                    maxRow = row;
                    maxColumn = column;
                }
            }
        }
        if (maxRow == -1) return new int[] {0, -1, -1};
        return new int[] {(int) total, maxRow, maxColumn};
    }

    public static void main(String[] args) {
        int[][] grid = {{4, 9, 2}, {7, 1, 6}, {3, 12, 5}};
        int[] result = warehouseSummary(grid);
        System.out.printf("total = %d, maxCoordinate = (%d, %d)%n",
            result[0], result[1], result[2]);
    }
}
