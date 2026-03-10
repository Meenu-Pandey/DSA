class Solution {
    private int mod = (int) 1e9 + 7;
    private int[] comp(int i, int limit) {
        int[] ways = new int[i + 1];
        int[] prev = new int[i + 1];
        prev[0] = 1;

        for (int k = 1; k <= i; k++) {
            int[] curr = new int[i + 1];
            long pref = 0; 
            for (int j = 1; j <= i; j++) {
                pref = (pref + prev[j - 1]) % mod;
                if (j - limit - 1 >= 0) {
                    pref = (pref - prev[j - limit - 1] + mod) % mod;
                }
                curr[j] = (int) pref;
            }
            ways[k] = curr[i];
            prev = curr;
        }
        return ways;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        int[] Zero = comp(zero, limit);
        int[] One = comp(one, limit);
        long ans = 0;

        for (int a = 1; a <= zero; a++) {
            if (a <= one) {
                ans = (ans + (long) Zero[a] * One[a]) % mod; 
            }
            if (a - 1 >= 1 && a - 1 <= one) {
                ans = (ans + (long) Zero[a] * One[a - 1]) % mod; 
            }
        }

        for (int a = 1; a <= zero; a++) {
            if (a <= one) {
                ans = (ans + (long) Zero[a] * One[a]) % mod; 
            }
            if (a + 1 <= one) {
                ans = (ans + (long) Zero[a] * One[a + 1]) % mod;
            }
        }

        return (int) (ans % mod);
    }
}