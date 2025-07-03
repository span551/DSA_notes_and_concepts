List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    Set<Integer> del = new HashSet<>();
    for (int d : to_delete) del.add(d);
    List<TreeNode> res = new ArrayList<>();
    root = helper(root, del, res);
    if (root != null) res.add(root);
    return res;
}
TreeNode helper(TreeNode node, Set<Integer> del, List<TreeNode> res) {
    if (node == null) return null;
    node.left = helper(node.left, del, res);
    node.right = helper(node.right, del, res);
    if (del.contains(node.val)) {
        if (node.left != null) res.add(node.left);
        if (node.right != null) res.add(node.right);
        return null;
    }
    return node;
}
