class Solution {

    // Main function to calculate minimum path sum
    public int minPathSum(int[][] grid) {

        // dp[i][j] will store the minimum path sum from cell (i, j) to the bottom-right cell
        int[][] dp = new int[grid.length][grid[0].length];

        // Initialize dp array with -1 to mark uncomputed states
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start recursion from the top-left cell (0, 0)
        return minPathFind(grid, 0, 0, dp);
    }

    // Recursive function to find minimum path sum from (i, j) to destination
    public int minPathFind(int[][] grid, int i, int j, int[][] dp) {

        // Base case: reached the bottom-right cell
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        // If indices go out of bounds, return a large value
        // so this path is never chosen in minimum comparison
        if (i >= grid.length || j >= grid[0].length) {
            return (int) 1e9;
        }

        // If result for this cell is already computed, reuse it
        if (dp[i][j] != -1) return dp[i][j];

        // Move down and calculate path sum
        int down = grid[i][j] + minPathFind(grid, i + 1, j, dp);

        // Move right and calculate path sum
        int right = grid[i][j] + minPathFind(grid, i, j + 1, dp);

        // Store and return the minimum path sum from this cell
        return dp[i][j] = Math.min(down, right);
    }
}