class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(String w: words){
            hm.put(w, hm.getOrDefault(w , 0)+1);
        }
        int res = 0;

        for(String str: hm.keySet()){
            if(isSubsequence(str, s))
                res += hm.get(str);
        }
        return res;
    }

    public boolean isSubsequence(String target, String src){
        int i = 0, j = 0, m = target.length(), n = src.length();
        while(i<m && j<n){
            if(target.charAt(i) == src.charAt(j))
                i++;
            j++;
        }
        return i==m; 
    }
}
