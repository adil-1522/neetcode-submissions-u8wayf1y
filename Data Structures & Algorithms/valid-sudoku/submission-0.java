class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num = board[i][j];

                if(num=='.') continue;

                String row = num+"inRow"+i;
                String column = num + "inCol"+j;
                String boxSet = num+"inBox"+(i/3)*3+(j/3);

                if(!set.add(row)||!set.add(column)||!set.add(boxSet)){
                    return false;
                }


            }
        }
        return true;
    }
}
