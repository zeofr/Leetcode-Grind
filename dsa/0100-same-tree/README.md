# 0100. Same Tree

## 💡 My Approach
At every pair of nodes, there are only 3 situations:

```
p = null, q = null
        ↓
      SAME ✓
```
```
p = null, q = node
        ↓
    DIFFERENT ✗
```
```
p = node, q = node
        ↓
Check values
        ↓
Check left subtrees
        ↓
Check right subtrees
```

---

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.



Example 1:

Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:

Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:

Input: p = [1,2,1], q = [1,1,2]
Output: false



Constraints:

The number of nodes in both trees is in the range [0, 100].

-104 <= Node.val <= 104