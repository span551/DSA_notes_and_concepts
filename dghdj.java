int countEvenSumSubarrays(int[] arr) {
    int count = 0, sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for (int num : arr) {
        sum += num;
        count += map.getOrDefault(sum % 2 == 0 ? 0 : 1, 0);
        map.put(sum % 2 == 0 ? 0 : 1, map.getOrDefault(sum % 2 == 0 ? 0 : 1, 0) + 1);
    }
    return count;
}
