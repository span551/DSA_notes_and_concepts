boolean checkPossibility(int[] arr) {
    int count = 0;
    for (int i = 1; i < arr.length && count <= 1; i++) {
        if (arr[i] < arr[i - 1]) {
            count++;
            if (i - 2 < 0 || arr[i - 2] <= arr[i]) arr[i - 1] = arr[i];
            else arr[i] = arr[i - 1];
        }
    }
    return count <= 1;
}
