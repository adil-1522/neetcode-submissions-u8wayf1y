class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;

        for(int num: nums){
            total+=num;
        }

        if ((target + total) % 2 != 0 || Math.abs(target) > total) return 0;

        int sum = (target+total)/2;

        Integer[][] dp = new Integer[nums.length][sum+1];
        return solve(0,sum,nums,dp); 
    }
    private int solve(int i,int amount,int[] nums,Integer[][] dp){
        if(i == nums.length){
        return amount == 0 ? 1 : 0;
    }

        if(dp[i][amount]!=null) return dp[i][amount];

        int nottake = solve(i+1,amount,nums,dp);

        int take=0;
        if(nums[i]<=amount){
            take = solve(i+1,amount-nums[i],nums,dp);
        }
        return dp[i][amount] = take+nottake;
    }
}
