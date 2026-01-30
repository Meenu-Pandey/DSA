class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, result, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] nums, boolean[] used, List<List<Integer>> result, List<Integer> ans){
        if(nums.length == ans.size()){
            result.add(new ArrayList<>(ans));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if( (i>0 && nums[i]==nums[i-1]) && !used[i-1] || (used[i]) ) continue;
            used[i] = true;
            ans.add(nums[i]);
            backtrack(nums, used, result, ans);
            ans.remove(ans.size() - 1);
            used[i] = false;            
        }
    }
}