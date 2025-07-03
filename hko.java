int countXORPairs(int[] arr, int x) {
    Set<Integer> set = new HashSet<>();
    int count = 0;
    for (int num : arr) {
        if (set.contains(num ^ x)) count++;
        set.add(num);
    }
    return count;
}
