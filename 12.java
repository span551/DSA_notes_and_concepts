void leftRotateByOne(int[] arr) {
    int first = arr[0];
    for (int i = 0; i < arr.length - 1; i++) {
        arr[i] = arr[i + 1];
    }
    arr[arr.length - 1] = first;
}
