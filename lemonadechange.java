class Solution {
    public boolean lemonadeChange(int[] bills) {
        // Let's keep track of how many $5 and $10 bills we have. 💰
        int count_5 = 0;
        int count_10 = 0;

        // Now, let's go through each customer and their bill. 🚶‍♀️🚶‍♂️
        for (int bill : bills) {
            // If the customer gives us a $5 bill...
            if (bill == 5) {
                // Just add it to our $5 pile. Easy peasy! 😄
                count_5 += 1;
            }
            // If the customer gives us a $10 bill...
            else if (bill == 10) {
                // Uh oh, we need to give $5 back. Do we have enough? 🤔
                if (count_5 == 0) return false; // Nope, can't give change!
                // Okay, we have a $5. Let's give it back.
                count_5 -= 1;
                // And add the $10 to our pile.
                count_10 += 1;
            }
            // If the customer gives us a $20 bill... 🤯
            else if (bill == 20) {
                // We need to give $15 back. Let's try to use a $10 and a $5 first.
                if (count_10 >= 1 && count_5 >= 1) {
                    count_10 -= 1;
                    count_5 -= 1;
                }
                // If we don't have a $10, let's try using three $5s.
                else if (count_5 >= 3) {
                    count_5 -= 3;
                }
                // If we can't do either, we're doomed! 😱
                else {
                    return false; // Can't give change!
                }
            }
        }
        // If we made it through all the customers without running out of change, we're golden! 🥳
        return true;
    }
}
