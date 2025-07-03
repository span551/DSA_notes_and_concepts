Map<Node, Node> map = new HashMap<>();
Node cloneGraph(Node node) {
    if (node == null) return null;
    if (map.containsKey(node)) return map.get(node);
    Node clone = new Node(node.val);
    map.put(node, clone);
    for (Node nei : node.neighbors) {
        clone.neighbors.add(cloneGraph(nei));
    }
    return clone;
}
