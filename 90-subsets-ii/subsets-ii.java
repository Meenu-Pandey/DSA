class Solution {
    List<List<Integer>>res=new ArrayList<>();
    public void backtrack(int[]nums,int idx,ArrayList temp){
        if(idx==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        backtrack(nums,idx+1,temp);
        while(idx<nums.length-1&&nums[idx]==nums[idx+1]) idx++;
        temp.remove(temp.size()-1);
        backtrack(nums,idx+1,temp);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> temp=new ArrayList<>();
        backtrack(nums,0,temp);
        return res;
    }
}