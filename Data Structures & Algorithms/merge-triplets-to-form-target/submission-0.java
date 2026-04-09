class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean aMatch=false;
        boolean bMatch=false;
        boolean cMatch=false;

        for(int[] t: triplets){
            if(t[0]<=target[0] && t[1]<=target[1]&& t[2]<=target[2]){
                if(t[0]==target[0]) aMatch=true;
                if(t[1]==target[1]) bMatch=true;
                if(t[2]==target[2]) cMatch=true;


            }
        }
        return aMatch && bMatch && cMatch;
    }
}
