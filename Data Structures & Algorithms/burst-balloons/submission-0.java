class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n+2];
        arr[0]=1;
        arr[n+1]=1;

        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }

        Integer[][] dp =new Integer[n+2][n+2];
        return solve(0,n+1,arr,dp); 
    }

    private int solve(int i,int j,int[] arr,Integer[][] dp){
        if(i+1==j) return 0;

        if(dp[i][j]!=null) return dp[i][j];

        int max=0;

        for(int k=i+1;k<j;k++){
            int coins = arr[i]*arr[k]*arr[j]+
                        solve(i,k,arr,dp)+
                        solve(k,j,arr,dp);

            max=Math.max(max,coins);
        }
        return dp[i][j] = max;
        
    }
}
