class Solution {
    public int largestSubmatrix(int[][] matrix) {
        if (matrix.length == 0) 
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        int maxArea = 0;

        for (int[] row : matrix) {

            for (int j = 0; j < n; j++)
                heights[j] = row[j] == 1 ? heights[j] + 1 : 0;

            int[] sortedH = heights.clone();
            Arrays.sort(sortedH);

            for (int j = 0; j < n; j++) {
                int h = sortedH[n - 1 - j];
                maxArea = Math.max(maxArea, h * (j + 1));
            }
        }

        return maxArea;
    }
}