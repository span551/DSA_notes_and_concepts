int maxSumRectangle(int[][] matrix) {
    int rows = matrix.length, cols = matrix[0].length;
    int maxSum = Integer.MIN_VALUE;
    for (int left = 0; left < cols; left++) {
        int[] temp = new int[rows];
        for (int right = left; right < cols; right++) {
            for (int i = 0; i < rows; i++)
                temp[i] += matrix[i][right];
            maxSum = Math.max(maxSum, kadane(temp));
        }
    }
    return maxSum;
}
int kadane(int[] arr) {
    int maxEnd = arr[0], maxSoFar = arr[0];
    for (int i = 1; i < arr.length; i++) {
        maxEnd = Math.max(arr[i], maxEnd + arr[i]);
        maxSoFar = Math.max(maxSoFar, maxEnd);
    }
    return maxSoFar;
}
