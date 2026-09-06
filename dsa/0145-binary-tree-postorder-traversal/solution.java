 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        while(!st1.isEmpty()){
    }
        Stack<TreeNode> st1 = new Stack<>();
        List<Integer> res = new ArrayList<>();
        
        st1.push(root);
        if(root == null) return res;
            TreeNode curr = st1.pop();
            st2.push(curr);
        Stack<TreeNode> st2 = new Stack<>();

            
            if(curr.right != null) st1.push(curr.right);
        }

        while(!st2.isEmpty())
            res.add(st2.pop().val);

        return res;
            if(curr.left != null) st1.push(curr.left);
}
