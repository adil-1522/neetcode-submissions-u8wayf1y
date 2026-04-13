class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){
            dfs(i,0,board);
            dfs(i,m-1,board);
        }

        for(int j=0;j<m;j++){
            dfs(0,j,board);
            dfs(n-1,j,board);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }

    private void dfs(int r,int c,char[][] board){
        int n = board.length;
        int m = board[0].length;

        if(r>=0 && c>=0 && r<n && c<m && board[r][c]=='O'){

            board[r][c]='#';

            dfs(r+1,c,board);
            dfs(r-1,c,board);
            dfs(r,c+1,board);
            dfs(r,c-1,board);
        }
    }
}
