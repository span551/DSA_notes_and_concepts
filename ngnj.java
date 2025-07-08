public void dfs(int[][] graph, int start, boolean[] visited) {
    visited[start] = true;
    for (int neighbor : graph[start]) {
        if (!visited[neighbor]) {
            dfs(graph, neighbor, visited);
        }
    }
}
