int countDistinct(int[] arr) {
    Set<Integer> set = new HashSet<>();
    for (int num : arr) set.add(num);
    return set.size();
}
