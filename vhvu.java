void rotateMatrix(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    for (int[] row : matrix) {
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
        }
    }
}
