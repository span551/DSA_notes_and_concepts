public class Solution {
    public boolean checkRecord(String s) {
        int lateCount = 0;
        int absentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                absentCount++;
                if (absentCount >= 2) return false;
            }
            if (c == 'L') {
                lateCount++;
                if (lateCount == 3) return false;
            } else {
                lateCount = 0;
            }
        }
        return absentCount < 2 && lateCount < 3;
    }
}
