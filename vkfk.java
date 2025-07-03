boolean exist(char[][] board, String word) {
    int m = board.length, n = board[0].length;
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++)
            if (dfs(board, visited, word, 0, i, j)) return true;
    return false;
}
boolean dfs(char[][] b, boolean[][] v, String w, int idx, int i, int j) {
    if (idx == w.length()) return true;
    if (i<0||j<0||i>=b.length||j>=b[0].length||v[i][j]||b[i][j]!=w.charAt(idx))
        return false;
    v[i][j]=true;
    boolean found = dfs(b,v,w,idx+1,i+1,j)||dfs(b,v,w,idx-1,j,j)||dfs(b,v,w,idx+1,i,j+1)||dfs(b,v,w,idx+1,i,j-1);
    v[i][j]=false;
    return found;
}
