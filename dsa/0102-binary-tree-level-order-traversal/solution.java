    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
        
            int s = q.size();
            for(int i = 0; i< s; i++){
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            List<Integer> level = new ArrayList<>();

                TreeNode curr = q.poll();

class Solution {
 */
 * }
                level.add(curr.val);
            }

            res.add(level);
        }

        return res;
    }
}
