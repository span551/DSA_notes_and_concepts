import java.util.*;

class Solution {
    Set<List<Integer>> set = new HashSet<>();

    public void check(int index, int[] nums, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> current = new ArrayList<>();
            for (int num : nums) current.add(num);
            if (!set.contains(current)) {
                result.add(new ArrayList<>(current));
                set.add(current);
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            check(index + 1, nums, result);
            swap(nums, index, i);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        check(0, nums, result);
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
