boolean isMatch(String s, String p) {
    int m = s.length(), n = p.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for (int j = 1; j <= n; j++) {
        if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];
    }
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1))
                dp[i][j] = dp[i - 1][j - 1];
            else if (p.charAt(j - 1) == '*')
                dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
        }
    }
    return dp[m][n];
}
