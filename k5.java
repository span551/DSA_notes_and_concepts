int equilibriumIndex(int[] arr) {
    int total = 0, leftSum = 0;
    for (int num : arr) total += num;
    for (int i = 0; i < arr.length; i++) {
        total -= arr[i];
        if (leftSum == total) return i;
        leftSum += arr[i];
    }
    return -1;
}
