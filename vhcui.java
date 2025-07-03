boolean isPermutation(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    for (int num : nums) {
        if (num < 1 || num > nums.length || !seen.add(num)) return false;
    }
    return true;
}
