class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r=0;
        for(int p:  piles){
            r = Math.max(r,p);
        }

        int ans = r;

        while(l<=r){
            int mid = l+(r-l)/2;

            if(canEat(piles,mid,h)){
                ans = mid;
                r = mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    private boolean canEat(int[] piles,int k,int h){
        int hours=0;

        for(int p:piles){
            hours+=(p+k-1)/k;
        }
        return hours<=h;
    }
}
