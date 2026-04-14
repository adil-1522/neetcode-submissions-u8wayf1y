class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(b).add(a);
            adj.get(a).add(b);
        }

        boolean[] visited = new boolean[n];
        dfs(0,adj,visited);

        for(boolean v: visited){
            if(!v) return false;
        }
                return true;
        
    }
    private void dfs(int node,List<List<Integer>> adj,boolean[] visited){
        visited[node]=true;

        for(int nei: adj.get(node)){
            if(!visited[nei]){
                dfs(nei,adj,visited);
            }
        }
    }
}
