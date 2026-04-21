class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int right=0;
        int maxLen=0;
        int maxFreq=0;
        int[] freq = new int[26];

        for(char ch: s.toCharArray()){
            freq[ch-'A']++;

            maxFreq = Math.max(maxFreq,freq[ch-'A']);

            while((right-left+1)-maxFreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }

            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}
