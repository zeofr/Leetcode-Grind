 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        helper(root);
    }
    int max = Integer.MIN_VALUE;
        return max;

    public int helper(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        max = Math.max(left +  right + root.val, max);

        return root.val + Math.max(left, right);
    }
}
