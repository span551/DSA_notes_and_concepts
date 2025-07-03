int findMissing(int[] arr, int n) {
    int total = n * (n + 1) / 2;
    int sum = 0;
    for (int num : arr) sum += num;
    return total - sum;
}
