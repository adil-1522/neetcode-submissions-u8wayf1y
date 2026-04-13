class Solution {
    public int numDecodings(String s) {
        Integer[] dp = new Integer[s.length()];
        return solve(0,s,dp);
    }

    private int solve(int i,String s,Integer[] dp){
        if(i==s.length()) return 1;

        if(s.charAt(i)=='0') return 0;

        if(dp[i]!=null) return dp[i];

        int ways = solve(i+1,s,dp);

        if(i+1<s.length()){
            int num = Integer.parseInt(s.substring(i,i+2));
            if(num>=10 && num<=26){
                ways+=solve(i+2,s,dp);
            }
        }
        return dp[i] = ways;
    }
}
