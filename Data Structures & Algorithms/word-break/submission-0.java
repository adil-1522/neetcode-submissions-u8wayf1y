class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return solve(0,s,set,dp);
    }

    private boolean solve(int i,String s,Set<String> set,Boolean[] dp){
        if(i==s.length()) return true;

        if(dp[i]!=null) return dp[i];

        for(int j=i;j<s.length();j++){
            if(set.contains(s.substring(i,j+1))&& solve(j+1,s,set,dp)){
                return dp[i] =true;
            }
        }
        return dp[i]=false;
    }
}
