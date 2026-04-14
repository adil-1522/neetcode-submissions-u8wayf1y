class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] t : times){
            int u=t[0],v=t[1],w=t[2];
            adj.get(u).add(new int[]{v,w});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        q.add(new int[]{0,k});

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;

        boolean[] visited = new boolean[n+1];

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int time = curr[0];
            int node = curr[1];

            if(visited[node]) continue;
            visited[node]=true;

            if(time>dist[node]) continue;

            for(int[] nei: adj.get(node)){
                int nextnode = nei[0];
                int wt = nei[1];

                if(dist[nextnode]>time+wt){
                    dist[nextnode]=time+wt;
                    q.add(new int[]{dist[nextnode],nextnode});
                }
            }
        }
        int maxtime=0;

        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            maxtime = Math.max(maxtime,dist[i]);
        }
        return maxtime;
    }
}
