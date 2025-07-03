int[] findOrder(int n, int[][] pre) {
    List<List<Integer>> g = new ArrayList<>();
    int[] indeg = new int[n];
    for (int i = 0; i < n; i++) g.add(new ArrayList<>());
    for (int[] p : pre) { g.get(p[1]).add(p[0]); indeg[p[0]]++; }
    Deque<Integer> dq = new ArrayDeque<>();
    for (int i = 0; i < n; i++) if (indeg[i] == 0) dq.offer(i);
    int[] res = new int[n]; int idx = 0;
    while (!dq.isEmpty()) {
        int u = dq.poll();
        res[idx++] = u;
        for (int v : g.get(u))
            if (--indeg[v] == 0) dq.offer(v);
    }
    return idx == n ? res : new int[0];
}
