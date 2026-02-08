class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nse[] = new int[n];
        for(int i=n-1;i>=0;i--){
            nse[i] = i+1;
            while(nse[i] != n && heights[nse[i]] >= heights[i])
                nse[i] = nse[nse[i]];
        }
        int pse[] = new int[n];
        for(int i=0;i<n;i++){
            pse[i]=i-1;
            while(pse[i] != -1 && heights[pse[i]] >= heights[i])
                pse[i] = pse[pse[i]];
        }
        int ar = 0;
        for(int i=0;i<n;i++){
            int h = heights[i];
            int wid = nse[i] - pse[i] - 1;
            ar = Math.max(ar, h * wid);
        }
        return ar;
    }
}