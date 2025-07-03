boolean arraysEqual(int[] arr1, int[] arr2) {
    if (arr1.length != arr2.length) return false;
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    return Arrays.equals(arr1, arr2);
}
