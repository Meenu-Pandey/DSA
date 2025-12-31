import java.util.*;

class Solution {

    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int low = 0, high = cells.length - 1;
        int ans = 0;

        // Binary search on days
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (walkPossible(row, col, cells, mid + 1)) {
                ans = mid + 1;       // crossing possible
                low = mid + 1;
            } else {
                high = mid - 1;     // crossing not possible
            }
        }
        return ans;
    }

    boolean walkPossible(int rows, int cols, int[][] cells, int day) {
        int[][] grid = new int[rows][cols];

        // Mark flooded cells
        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;  // convert to 0-index
            int c = cells[i][1] - 1;
            grid[r][c] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();

        // Start BFS from top row
        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 0) {
                queue.offer(new int[]{0, j});
                grid[0][j] = -1; // mark visited
            }
        }

        // BFS traversal
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            if (r == rows - 1) return true;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols &&
                    grid[nr][nc] == 0) {

                    grid[nr][nc] = -1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }
}
