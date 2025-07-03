int[][] mergeIntervals(int[][] intervals) {
    if (intervals.length <= 1) return intervals;
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    List<int[]> res = new ArrayList<>();
    int[] curr = intervals[0];
    for (int[] next : intervals) {
        if (next[0] <= curr[1]) curr[1] = Math.max(curr[1], next[1]);
        else { res.add(curr); curr = next; }
    }
    res.add(curr);
    return res.toArray(new int[res.size()][]);
}
