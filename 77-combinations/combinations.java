class Solution {
    List<List<Integer>> out = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(1, n, k);
        return out;
    }
    private void helper(int start, int n, int k){
        if(temp.size()==k){
            out.add(new ArrayList<>(temp));
            return;
        }
        if((n-start+1)<(k-temp.size()))return;
        for(int i=start;i<=n;i++){
            temp.add(i);
            helper(i+1, n, k);
            temp.removeLast();
        }
    }
}