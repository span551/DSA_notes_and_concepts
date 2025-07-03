int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n : nums) set.add(n);
    int maxLen = 0;
    for (int n : set) {
        if (!set.contains(n - 1)) {
            int curr = n, len = 1;
            while (set.contains(curr + 1)) { curr++; len++; }
            maxLen = Math.max(maxLen, len);
        }
    }
    return maxLen;
}
