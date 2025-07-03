boolean canFinish(int numCourses, int[][] prereq) {
    List<List<Integer>> g = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) g.add(new ArrayList<>());
    int[] indeg = new int[numCourses];
    for (int[] p : prereq) {
        g.get(p[1]).add(p[0]);
        indeg[p[0]]++;
    }
    Deque<Integer> dq = new ArrayDeque<>();
    for (int i = 0; i < numCourses; i++)
        if (indeg[i] == 0) dq.offer(i);
    int count = 0;
    while (!dq.isEmpty()) {
        int u = dq.poll();
        count++;
        for (int v : g.get(u)) {
            if (--indeg[v] == 0) dq.offer(v);
        }
    }
    return count == numCourses;
}
