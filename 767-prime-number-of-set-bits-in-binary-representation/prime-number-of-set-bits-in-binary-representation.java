class Solution {
    private int countBits(int n){
        int cnt = 0;
        while(n != 0){
            n = n & (n-1);
            cnt++;
        }
        return cnt;
    }

    public int countPrimeSetBits(int left, int right) {
        Set<Integer> prime = new HashSet<>(Arrays.asList(2,3,5,7,11,13,17,19));
        int ans = 0;
        for(int i = left; i <= right; i++){
            if(prime.contains(countBits(i))) ans++;
        }
        return ans;
    }
}