int[][] insertInterval(int[][] intervals, int[] newInt) {
    List<int[]> res = new ArrayList<>();
    for (int[] curr : intervals) {
        if (curr[1] < newInt[0]) res.add(curr);
        else if (curr[0] > newInt[1]) { res.add(newInt); newInt = curr; }
        else { newInt[0] = Math.min(newInt[0], curr[0]); newInt[1] = Math.max(newInt[1], curr[1]); }
    }
    res.add(newInt);
    return res.toArray(new int[res.size()][]);
}
