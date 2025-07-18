class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[]indegree = new int[numCourses];
        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        for(int i = 0;i<numCourses;i++){
            for(int adjNode : adj.get(i)){
            indegree[adjNode]++;
        }
    }

   Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
    ArrayList<Integer> result = new ArrayList<>();
    while(!q.isEmpty()){
        int curr = q.poll();
        result.add(curr);
        for(int adjNode : adj.get(curr)){
            indegree[adjNode]--;
            if(indegree[adjNode] == 0){
             q.offer(adjNode);
            }
        }
    }
        return result.size() == numCourses;

    }
}