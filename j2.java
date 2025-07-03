void moveZerosToEnd(int[] arr) {
    int index = 0;
    for (int num : arr) {
        if (num != 0) arr[index++] = num;
    }
    while (index < arr.length) {
        arr[index++] = 0;
    }
}
