class Solution {
    public String getPermutation(int n, int k) {
        // Calculate (n-1)!
        int fact = 1;
        ArrayList<Integer> ds = new ArrayList<>();
        
        for (int i = 1; i < n; i++) {
            fact *= i;       // Compute factorial
            ds.add(i);       // Add numbers 1 to (n-1) to the list
        }
        ds.add(n);           // Add the last number (n)
        
        // Convert k to 0-based index for easier calculations
        k = k - 1;
        String ans = "";     // Store the k-th permutation
        
        // Construct the permutation
        while (true) {
            // Append the number at index (k / fact) in ds to the answer
            ans = ans + ds.get(k / fact);
            ds.remove(k / fact); // Remove the used number from the list
            
            // If all numbers are used, break
            if (ds.size() == 0) {
                break;
            }
            
            // Update k and fact for the remaining numbers
            k = k % fact;
            fact = fact / ds.size();
        }
        
        return ans;
    }
}

 
