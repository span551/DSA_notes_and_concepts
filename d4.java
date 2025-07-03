List<Integer> maxSlidingWindow(int[] arr, int k) {
    List<Integer> result = new ArrayList<>();
    Deque<Integer> dq = new ArrayDeque<>();
    for (int i = 0; i < arr.length; i++) {
        while (!dq.isEmpty() && dq.peek() < i - k + 1) dq.poll();
        while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) dq.pollLast();
        dq.offer(i);
        if (i >= k - 1) result.add(arr[dq.peek()]);
    }
    return result;
}
