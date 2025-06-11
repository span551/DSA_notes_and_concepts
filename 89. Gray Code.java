class Solution {
    public List<Integer> grayCode(int n) {
        int size = 1 << n;  // 2^n
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}
