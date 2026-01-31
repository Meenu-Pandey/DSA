class Solution {
    int [] queens;
    public int totalNQueens(int n) {
        queens = new int[10];
        Arrays.fill(queens, -1);
        return backTrack(0,n);
    }
    private int backTrack(int row, int n){
        // pruning

        // base case
        if(row == n) return 1;

        int ans =0;
        for(int col =0; col <n; col++){
            if(feasible(row, col)){
                queens[row] = col;

                ans += backTrack(row+1, n);
                // backtracking 
                queens[row] = -1;
            }
        }
        return ans;
    }

    private boolean feasible(int row, int col){

        for(int i=0; i<row; i++){
            int prow = i;
            int pcol = queens[i];

            if(pcol == col || Math.abs(col- pcol) == Math.abs(prow- row)) return false;
        }
        return true;
    }
}