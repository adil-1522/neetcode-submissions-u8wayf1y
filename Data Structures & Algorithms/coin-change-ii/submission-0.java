class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount+1];
        return solve(0,amount,coins,dp);
    }
    private int solve(int i,int amount,int[] coins,Integer[][] dp){
        if(amount==0) return 1;
        if(i==coins.length) return 0;

        if(dp[i][amount]!=null) return dp[i][amount];

        int nottake = solve(i+1,amount,coins,dp);

        int take=0;
        if(coins[i]<=amount){
            take = solve(i,amount-coins[i],coins,dp);
        }
        return dp[i][amount]=take+nottake;
    }
}
