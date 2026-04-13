class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];

        for(int i=0;i<n;i++) dfs(i,0,heights,pac);
        for(int  j=0;j<m;j++) dfs(0,j,heights,pac);

        for(int i=0;i<n;i++) dfs(i,m-1,heights,atl);
        for(int j=0;j<m;j++) dfs(n-1,j,heights,atl);

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pac[i][j] && atl[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int r,int c,int[][] heights,boolean[][] visited){
            visited[r][c] = true;

            int[][] dirs={{-1,0},{0,1},{1,0},{0,-1}};

            for(int[] dir: dirs){
                int nr = r+dir[0];
                int nc = c+dir[1];

                if(nr>=0 && nr<heights.length && nc>=0 && nc<heights[0].length && !visited[nr][nc] && heights[nr][nc]>=heights[r][c]){
                    dfs(nr,nc,heights,visited);
                }    
            }
    }
}
