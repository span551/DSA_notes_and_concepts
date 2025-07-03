List<Integer> findDuplicatesEfficient(int[] nums) {
    List<Integer> result = new ArrayList<>();
    for (int num : nums) {
        int index = Math.abs(num) - 1;
        if (nums[index] < 0) result.add(index + 1);
        else nums[index] = -nums[index];
    }
    return result;
}
