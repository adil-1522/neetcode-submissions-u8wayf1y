class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int count=0;
        while(i<nums.length-1){
            if(nums[i]!=nums[i+1]){
                i++;
            }else{
                return true;
            }
            
            
        }
        return false;
    }
}