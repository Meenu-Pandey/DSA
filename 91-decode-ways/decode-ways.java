class Solution {
    int dp[];
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);
        return back(0, n, s);
    }
    public int back(int ind, int n, String s){
        if(ind == n) return 1;
        if (s.charAt(ind) == '0') return 0;
        if(dp[ind] != -1) return dp[ind];
        int ans = back(ind + 1, n, s);
        if(ind + 1 < n && check(ind, s)){
            ans += back(ind + 2, n, s);
        }
        return dp[ind] = ans;
    }
    public boolean check(int ind, String s){
        if(s.charAt(ind) == '0') return false;
        int t = (s.charAt(ind) - '0') * 10;
        t += s.charAt(ind + 1) - '0';
        if(t>=1 && t<=26) return true;
        return false;
    }
}