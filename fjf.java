int maxProduct(int[] nums) {
    int max = nums[0], min = nums[0], result = nums[0];
    for (int i = 1; i < nums.length; i++) {
        int temp = max;
        max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
        min = Math.min(nums[i], Math.min(temp * nums[i], min * nums[i]));
        result = Math.max(result, max);
    }
    return result;
}
