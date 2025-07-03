int countSubarraysWithXOR(int[] arr, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int count = 0, xor = 0;
    for (int num : arr) {
        xor ^= num;
        count += map.getOrDefault(xor ^ k, 0);
        map.put(xor, map.getOrDefault(xor, 0) + 1);
    }
    return count;
}
