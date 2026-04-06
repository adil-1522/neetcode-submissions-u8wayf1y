class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            int num = n&1;
            n>>>=1;
            if(num==1){
                count++;
            }
        }
        return count;
    }
}
