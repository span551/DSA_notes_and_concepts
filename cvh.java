int minSubArrayLen(int s, int[] nums) {
    int left=0, sum=0, minLen=Integer.MAX_VALUE;
    for(int i=0;i<nums.length;i++){
        sum+=nums[i];
        while(sum>=s){
            minLen= Math.min(minLen, i-left+1);
            sum-=nums[left++];
        }
    }
    return minLen==Integer.MAX_VALUE?0:minLen;
}
