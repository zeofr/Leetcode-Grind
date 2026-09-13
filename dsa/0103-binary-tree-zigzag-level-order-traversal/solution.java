        boolean leftToRight = true;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelValues = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelValues.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (!leftToRight) {
                Collections.reverse(levelValues);
            }
            
            result.add(levelValues);
            leftToRight = !leftToRight;
        }
        return result;
    }
}

