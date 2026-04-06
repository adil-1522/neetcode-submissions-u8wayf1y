class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);

        int case1 = houserobber(nums,0,n-2);

        int case2 = houserobber(nums,1,n-1);

        return Math.max(case1,case2);
    }

    private int houserobber(int[] nums,int start,int end){
        int len = end-start+1;
        int[] dp =new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start],nums[start+1]);

        for(int i=2;i<len;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[start+i]);
        }
        return dp[len-1];


    }
}
