List<Integer> majorityElementNBy3(int[] nums) {
    int n = nums.length;
    Integer candidate1 = null, candidate2 = null;
    int count1 = 0, count2 = 0;
    for (int num : nums) {
        if (Objects.equals(candidate1, num)) count1++;
        else if (Objects.equals(candidate2, num)) count2++;
        else if (count1 == 0) { candidate1 = num; count1 = 1; }
        else if (count2 == 0) { candidate2 = num; count2 = 1; }
        else { count1--; count2--; }
    }
    count1 = count2 = 0;
    for (int num : nums) {
        if (Objects.equals(num, candidate1)) count1++;
        else if (Objects.equals(num, candidate2)) count2++;
    }
    List<Integer> result = new ArrayList<>();
    if (count1 > n / 3) result.add(candidate1);
    if (count2 > n / 3) result.add(candidate2);
    return result;
}
