class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] p: prerequisites){
            int a = p[0];
            int b = p[1];
            indegree[a]++;
            adj.get(b).add(a);
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int[] result = new int[numCourses];
        int idx=0;

        while(!q.isEmpty()){
            int node = q.poll();
            result[idx++] = node;

            for(int nei: adj.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }
        if(idx!=numCourses) return new int[0];

        return result;


    }
}
