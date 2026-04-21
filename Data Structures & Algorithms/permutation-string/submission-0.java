class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n>m) return false;

        int[] freq = new int[26];

        for(char ch: s1.toCharArray()){
            freq[ch-'a']++;
        }
        int count=n;

        int left=0;
        int right=0;

        while(right<s2.length()){
            if(freq[s2.charAt(right)-'a']>0){
                count--;
            }
            freq[s2.charAt(right)-'a']--;
            right++;

            if(count==0) return true;

            if(right-left==n){
                if(freq[s2.charAt(left)-'a']>=0){
                    count++;
                }

                freq[s2.charAt(left)-'a']++;
                left++;
            }
        }
        return false;
        
    }
}
