class Solution {
    // use long b/c the dist are from 1 <= dist <= 1e9
    // prefer pair instead of int[] 
    class pair {
    int node;
    long dist;

    public pair(int node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}
    static final int mod = (int) 1e9 + 7;
    public int countPaths(int n, int[][] roads) {
        List<List<pair>> adj  = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : roads){
            int u = edge[0], v = edge[1], time = edge[2];
            adj.get(u).add(new pair(v,time));
            adj.get(v).add(new pair(u,time));
        }

        long[] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;
        int[] ways = new int[n];
        Arrays.fill(ways,0);
        ways[0] = 1;

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.dist,b.dist));
        pq.offer(new pair(0,0));

        while(!pq.isEmpty()){
           pair curr = pq.poll();
            int u = curr.node;
            long distU = curr.dist;

            if (distU > dist[u]) continue;
            

            for(int i = 0;i<adj.get(u).size();i++){
                pair temp = adj.get(u).get(i);
                int v = temp.node;
                long cost = temp.dist;

                 if(dist[v] > distU + cost){
                   dist[v] = distU+ cost;
                   pq.offer(new pair(v,dist[v]));
                   ways[v] = ways[u];            
                }
                 else if(dist[v] == distU + cost){
                  ways[v] = (ways[v] + ways[u]) % mod;    //the number of ways to reach it is the sum of the ways to reach all its predecessors in the shortest path.
                }
            }
        }
        return ways[n-1];

// time complexity : 0(ElogV); space : 0(V+E)
        
    }
}