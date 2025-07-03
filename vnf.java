int maxConsecutiveOnes(int[] arr) {
    int max = 0, count = 0;
    for (int num : arr) {
        count = (num == 1) ? count + 1 : 0;
        max = Math.max(max, count);
    }
    return max;
}
