class Solution {
    public int countBinarySubstrings(String s) {
        int prev = 0; // The length of the previous group (zeros or ones).  Initially 0.
        int curr = 1; // The length of the current group (zeros or ones).  Initially, 1, because we start with the first character.
        int result = 0; // Total number of matching substrings.

        for (int i = 1; i < s.length(); i++) { // Passing through the string, starting from the second character.
            if (s.charAt(i) == s.charAt(i - 1)) { // If the current character is the same as the previous one...
curr++; // ...increasing the length of the current group.
            } else { // If the current character differs from the previous one...
result += Math.min(prev, curr); // ...We found a new band!  We add the minimum of the lengths of the previous and current groups to the result.
                prev = curr; // The current group becomes the previous one.
                curr = 1; // Start counting the new current group from 1.
            }
        }

        result += Math.min(prev, curr); // After the end of the cycle, the last pair of groups must be taken into account.
        return result; // Returning the total number of matching substrings.
    }
}
