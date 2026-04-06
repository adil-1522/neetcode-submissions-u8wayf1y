class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,target,0,new ArrayList<>(),result);
        return result;
    }

    private void backtrack(int[] nums,int target,int start,List<Integer> current,List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=start;i<nums.length;i++){
            int num = nums[i];
            if(num<=target){
                current.add(num);
                backtrack(nums,target-num,i,current,result);
                current.remove(current.size()-1);
            }
        }
    }
}
