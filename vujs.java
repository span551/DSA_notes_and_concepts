String convertZigzag(String s, int rows) {
    if (rows == 1) return s;
    List<StringBuilder> sb = new ArrayList<>();
    for (int i = 0; i < rows; i++) sb.add(new StringBuilder());
    int cur = 0, dir = -1;
    for (char c : s.toCharArray()) {
        sb.get(cur).append(c);
        if (cur == 0 || cur == rows - 1) dir = -dir;
        cur += dir;
    }
    for (int i = 1; i < rows; i++) sb.get(0).append(sb.get(i));
    return sb.get(0).toString();
}
