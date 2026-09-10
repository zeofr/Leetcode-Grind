 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        if(root == null) return 0 ;
    }
    public int maxDepth(TreeNode root) {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left,right);
}
