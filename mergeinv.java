class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            // Overlap condition: current start <= previous end
            if (intervals[i][0] <= prev[1]) {
                // Merge intervals
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                // No overlap, add previous interval to result
                merged.add(prev);
                prev = intervals[i];
            }
        }

        merged.add(prev); // Add the last interval
        return merged.toArray(new int[merged.size()][]);
    }
}
