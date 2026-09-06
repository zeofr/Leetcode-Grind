 *     int val;
 *     TreeNode left;
 *     TreeNode right;
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
    }
        return res;

    private static void preorder(TreeNode root, List<Integer> res){
        if(root == null) return;
    }
        preorder(root.left , res);
        res.add(root.val);
        preorder(root, res);
        preorder(root.right, res);
}
 * public class TreeNode {
/**
 * Definition for a binary tree node.
