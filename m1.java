int firstRepeating(int[] arr) {
    Set<Integer> seen = new HashSet<>();
    for (int i = arr.length - 1; i >= 0; i--) {
        if (seen.contains(arr[i])) return arr[i];
        seen.add(arr[i]);
    }
    return -1; // No repeating element
}
