void segregateEvenOdd(int[] arr) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
        while (arr[left] % 2 == 0 && left < right) left++;
        while (arr[right] % 2 != 0 && left < right) right--;
        if (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
}
