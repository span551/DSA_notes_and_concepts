class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
  // sort
  Arrays.sort(nums);
  
  List<List<Integer>> result = new ArrayList<>();
  result.add(new ArrayList<>());  // empty set
  
  int cachedSize = 0, startIdx = 0;
  for (int i = 0; i < nums.length; ++i) {
    List<List<Integer>> newResult = new ArrayList<>();  // used for new lists
    // set startIdx first before we update cachedSize
    startIdx = (i > 0 && nums[i - 1] == nums[i]) ? cachedSize : 0; // if duplicate occurs
    cachedSize = result.size(); // cache the size for startIdx in the next round
    for (int j = startIdx; j < result.size(); ++j) {
      List<Integer> L = result.get(j);
      L = new ArrayList<>(L);  // copy
      L.add(nums[i]);
      newResult.add(L);
    }
    result.addAll(newResult);  // concatenate
  }
  return result;
}
}
