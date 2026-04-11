class Solution {
    int[][] dirs ={{0,1},{1,0},{0,-1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int ans=0;

        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans,dfs(i,j,matrix,dp));
            }
        }
        return ans;
    }
    private int dfs(int i,int j,int[][] matrix,int[][] dp){
        if(dp[i][j]!=0) return dp[i][j];

        int max=1;

        for(int[] dir: dirs){
            int ni = i+dir[0];
            int nj = j+dir[1];

            if(ni>=0 && nj>=0 && ni<matrix.length && nj< matrix[0].length && matrix[ni][nj]>matrix[i][j]){
                max=Math.max(max,1+dfs(ni,nj,matrix,dp));
            }
        }
        return dp[i][j]=max;
    }
}
