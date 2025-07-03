int maxDifference(int[] arr) {
    int min = arr[0], maxDiff = Integer.MIN_VALUE;
    for (int i = 1; i < arr.length; i++) {
        maxDiff = Math.max(maxDiff, arr[i] - min);
        min = Math.min(min, arr[i]);
    }
    return maxDiff;
}
