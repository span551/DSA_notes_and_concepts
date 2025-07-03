int rowWithMaxOnes(int[][] matrix) {
    int maxRow = -1, maxCount = -1;
    for (int i = 0; i < matrix.length; i++) {
        int count = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] == 1) count++;
        }
        if (count > maxCount) {
            maxCount = count;
            maxRow = i;
        }
    }
    return maxRow;
}
