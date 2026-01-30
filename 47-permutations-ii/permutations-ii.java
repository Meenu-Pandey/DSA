class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Set<List<Integer>> distinct=new HashSet<>();
        Set<Integer> visited=new HashSet<>();
        helper(0, nums, distinct, visited, temp);
        res.addAll(distinct);
        return res;
    }

    public void helper(int i, int[] nums, Set<List<Integer>> distinct, Set<Integer> visited, List<Integer> temp) {
        if(i==nums.length)
        {
            distinct.add(new ArrayList<>(temp));
            return;
        }
        for(int k=0;k<nums.length;k++)
        {
            if(!visited.contains(k))
            {
                visited.add(k);
                temp.add(nums[k]);
                helper(i+1, nums, distinct, visited, temp);
                temp.remove(temp.size()-1);
                visited.remove(k);
            }
        }
    }
}