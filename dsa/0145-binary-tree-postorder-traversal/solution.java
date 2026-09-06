        TreeNode prev = null;

        while (curr != null || !stack.isEmpty()) {

            // Go as far left as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            TreeNode peek = stack.peek();

            // If right subtree exists and hasn't been processed
            if (peek.right != null && peek.right != prev) {
                curr = peek.right;
            } 
            else {
                // Both children processed -> process root
                res.add(peek.val);
                prev = stack.pop();
            }
        }

        return res;
    }
}
