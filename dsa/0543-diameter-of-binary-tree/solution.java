 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
    }
        return max;

    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        if(right + left > max) max = right + left;
    int max = 0;
 *     }
        return 1 + Math.max(left,right);
    }
}


 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
