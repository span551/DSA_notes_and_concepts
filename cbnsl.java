void sort012(int[] arr) {
    int low = 0, mid = 0, high = arr.length - 1;
    while (mid <= high) {
        switch (arr[mid]) {
            case 0: swap(arr, low++, mid++); break;
            case 1: mid++; break;
            case 2: swap(arr, mid, high--); break;
        }
    }
}
