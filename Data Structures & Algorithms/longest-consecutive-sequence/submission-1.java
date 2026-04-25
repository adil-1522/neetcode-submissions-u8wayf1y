class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if(nums.length==0) return 0;

        for(int num: nums){
            set.add(num);
        }

        int maxLen=0;

        for(int num: set){
            if(!set.contains(num-1)){

                int curr=num;
                int length=1;

                while(set.contains(curr+1)){
                    curr++;
                    length++;
                }
            
            maxLen = Math.max(maxLen,length);
            }
        }
        return maxLen;
    }
}
