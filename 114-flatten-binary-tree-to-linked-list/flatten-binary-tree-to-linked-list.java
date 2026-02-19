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
    public void flatten(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        insert(root, q);
        q.poll(); // skip the original root since we'll relink from it
        while (!q.isEmpty()) {
            root.right = q.poll(); // connect to next node
            root.left = null;      // left should be null in linked list
            root = root.right;
        }
    }

    // Preorder traversal to collect nodes
    void insert(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) return;
        queue.add(node);
        insert(node.left, queue);
        insert(node.right, queue);
    }
}