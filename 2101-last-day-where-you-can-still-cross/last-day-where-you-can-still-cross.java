class Solution {

    int[] parent, rank;
    int rows, cols;
    int top, bottom;

    public int latestDayToCross(int row, int col, int[][] cells) {
        rows = row;
        cols = col;

        int n = rows * cols;
        parent = new int[n + 2];
        rank = new int[n + 2];

        top = n;
        bottom = n + 1;

        for (int i = 0; i < parent.length; i++)
            parent[i] = i;

        boolean[][] land = new boolean[rows][cols];

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Process days in reverse
        for (int day = cells.length - 1; day >= 0; day--) {
            int r = cells[day][0] - 1;
            int c = cells[day][1] - 1;
            land[r][c] = true;

            int id = r * cols + c;

            // connect neighbors
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && land[nr][nc]) {
                    union(id, nr * cols + nc);
                }
            }

            // connect to top or bottom virtual nodes
            if (r == 0) union(id, top);
            if (r == rows - 1) union(id, bottom);

            // check connectivity
            if (find(top) == find(bottom)) {
                return day;
            }
        }
        return 0;
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;

        if (rank[px] < rank[py]) parent[px] = py;
        else if (rank[px] > rank[py]) parent[py] = px;
        else {
            parent[py] = px;
            rank[px]++;
        }
    }
}
