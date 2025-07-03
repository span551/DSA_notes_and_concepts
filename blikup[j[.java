List<String> findRepeatedDnaSequences(String s) {
    Set<String> seen = new HashSet<>(), res = new HashSet<>();
    for (int i = 0; i + 10 <= s.length(); i++) {
        String sub = s.substring(i, i + 10);
        if (!seen.add(sub)) res.add(sub);
    }
    return new ArrayList<>(res);
}
