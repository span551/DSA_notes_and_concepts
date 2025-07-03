int ladderLength(String begin, String end, List<String> wordList) {
    Set<String> dict = new HashSet<>(wordList), visited = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.offer(begin); visited.add(begin);
    int level = 1;
    while (!queue.isEmpty()) {
        int size = queue.size();
        while (size-- > 0) {
            String word = queue.poll();
            if (word.equals(end)) return level;
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char old = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String nxt = new String(arr);
                    if (dict.contains(nxt) && !visited.contains(nxt)) {
                        visited.add(nxt);
                        queue.offer(nxt);
                    }
                }
                arr[i] = old;
            }
        }
        level++;
    }
    return 0;
}
