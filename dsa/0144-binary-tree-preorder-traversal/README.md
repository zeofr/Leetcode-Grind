# 0144. Binary Tree Preorder Traversal

## 💡 My Approach
The solution does it using recursion but if i had to do it iteratively, since recursion uses a stack itself, we can implement a Stack for iterative traversal.

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            res.add(curr.val);

            if (curr.right != null) {
                stack.push(curr.right);
            }

            if (curr.left != null) {
                stack.push(curr.left);
            }
        }

        return res;
    }
}
```

---

Given the root of a binary tree, return the preorder traversal of its nodes' values.



Example 1:

Input: root = [1,null,2,3]

Output: [1,2,3]

Explanation:

Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [1,2,4,5,6,7,3,8,9]

Explanation:

Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]



Constraints:

The number of nodes in the tree is in the range [0, 100].

-100 <= Node.val <= 100



Follow up: Recursive solution is trivial, could you do it iteratively?