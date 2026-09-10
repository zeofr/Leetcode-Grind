# 0124. Binary Tree Maximum Path Sum

## 💡 My Approach
This problem is very similar to the Diameter of Binary Tree problem.


For diameter:

```

left = helper(root.left);
right = helper(root.right);


answer = Math.max(answer, left + right);

return 1 + Math.max(left, right);

```
For maximum path sum:
```

left = Math.max(0, helper(root.left));
right = Math.max(0, helper(root.right));

answer = Math.max(answer, left + root.val + right);

return root.val + Math.max(left, right);
```

The key difference is:

Diameter: every node contributes 1.

Maximum Path Sum: every node contributes root.val, and negative subtree contributions are discarded.

This is one of the most important "DFS returns something to parent, while simultaneously updating a global answer" patterns for binary-tree interviews.

---

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.



Example 1:

Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

Example 2:

Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.



Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].

-1000 <= Node.val <= 1000