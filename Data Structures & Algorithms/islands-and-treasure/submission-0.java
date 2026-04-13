class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    queue.add(new int[]{i,j});
                }
            }
        }

        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0],c=curr[1];

            for(int[] dir: dirs){
                int nr = r+dir[0];
                int nc = c+dir[1];

                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==Integer.MAX_VALUE){
                    grid[nr][nc]=grid[r][c]+1;
                    queue.offer(new int[]{nr,nc});
                }
            }

        }
    }
}
