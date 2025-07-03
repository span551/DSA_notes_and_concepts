void countFrequencies(int[] arr) {
    Map<Integer, Integer> freqMap = new HashMap<>();
    for (int num : arr) {
        freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}
