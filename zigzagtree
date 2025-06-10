class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //Breadth-First-Search -> Simple tweek
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        boolean isForward = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelArr = new LinkedList<>();

            while (levelSize-- > 0) {
                TreeNode node = queue.poll();
                if (isForward) levelArr.addLast(node.val);
                else levelArr.addFirst(node.val);
                
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ans.add(levelArr);
            isForward = !isForward;
        }
        return ans;
    }
}
