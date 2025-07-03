boolean validPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return isPal(s, left + 1, right) || isPal(s, left, right - 1);
        }
        left++; right--;
    }
    return true;
}
boolean isPal(String s, int i, int j) {
    while (i < j) {
        if (s.charAt(i++) != s.charAt(j--)) return false;
    }
    return true;
}
