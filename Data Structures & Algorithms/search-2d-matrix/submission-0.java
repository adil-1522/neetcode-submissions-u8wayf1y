class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0;
        int r = n*m-1;

        while(l<=r){
            int mid = l+(r-l)/2;

            int row = mid/m;
            int col = mid%m;

            int val = matrix[row][col];

            if(val==target) return true;

            if(target>val){
                l = mid+1;
            }else{
                r=mid-1;
            }
        }
        return false;
    }
}
