class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent  = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i]=i;
        }

        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];

            int pa = find(a,parent);
            int pb = find(b,parent);

            if(pa==pb){
                return edge;
            
            

        }
        parent[pa]=pb;
        }
        return new int[0];
    }
    private int find(int x,int[]parent){
        if(parent[x]!=x){
            parent[x]=find(parent[x],parent);
        }
        return parent[x];
    }
}
