/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int t) {
        if(root == null) return new ArrayList<>();
        helper(root, t, new ArrayList<Integer>());
        return ans;
    }
    private void helper(TreeNode root, int t, ArrayList<Integer> curr){
        if(root == null) return;
        curr.add(root.val);
        if(t == root.val && root.left == null && root.right == null){
            ans.add(new ArrayList<>(curr));
        }
        helper(root.left, t-root.val, curr);
        helper(root.right, t-root.val, curr);
        curr.remove(curr.size() - 1);
    }
}