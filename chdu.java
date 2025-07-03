int pivotIndex(int[] arr) {
    int total = Arrays.stream(arr).sum();
    int leftSum = 0;
    for (int i = 0; i < arr.length; i++) {
        if (leftSum == total - leftSum - arr[i]) return i;
        leftSum += arr[i];
    }
    return -1;
}
