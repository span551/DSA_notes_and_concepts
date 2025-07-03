int[] findMissingRepeating(int[] arr) {
    int n = arr.length;
    int[] count = new int[n + 1];
    for (int num : arr) count[num]++;
    int missing = -1, repeating = -1;
    for (int i = 1; i <= n; i++) {
        if (count[i] == 0) missing = i;
        if (count[i] == 2) repeating = i;
    }
    return new int[]{repeating, missing};
}
