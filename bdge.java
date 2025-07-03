boolean circularArrayLoop(int[] nums) {
    int n = nums.length;
    for(int i=0;i<n;i++){
        int slow = i, fast = i;
        boolean dir = nums[i] > 0;
        do {
            slow = next(nums, dir, slow);
            fast = next(nums, dir, fast);
            if(fast != -1) fast = next(nums, dir, fast);
        } while (slow != -1 && fast != -1 && slow != fast);
        if (slow != -1 && slow == fast) return true;
    }
    return false;
}
int next(int[] nums, boolean dir, int idx) {
    boolean newDir = nums[idx] > 0;
    if (dir != newDir) return -1;
    int next = (idx + nums[idx] + nums.length) % nums.length;
    if (next == idx) return -1;
    return next;
}
