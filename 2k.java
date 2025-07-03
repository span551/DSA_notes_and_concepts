void findLeaders(int[] arr) {
    int maxRight = arr[arr.length - 1];
    System.out.print(maxRight + " ");
    for (int i = arr.length - 2; i >= 0; i--) {
        if (arr[i] > maxRight) {
            maxRight = arr[i];
            System.out.print(maxRight + " ");
        }
    }
}
