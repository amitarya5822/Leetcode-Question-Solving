class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            adj.get(edge[0]).add(new int[]{edge[1], i}); 
            adj.get(edge[1]).add(new int[]{edge[0], i});
        }

        double[] dist = new double[n+1];
        Arrays.fill(dist,0.0);
        dist[start_node] = 1.0;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[1],a[1]));  //we have to find maximum prob
        pq.offer(new double[]{start_node,0});

        while(!pq.isEmpty()){
            double[] curr = pq.poll();
            int u = (int)curr[0];
            double distU = curr[1];
            if (u == end_node) return distU;

            for(int[] adjNode : adj.get(u)){
                int v = adjNode[0];
                int cost = adjNode[1];

                if(dist[v] < dist[u]*succProb[cost]){
                    dist[v] = dist[u]*succProb[cost];
                    pq.offer(new double[]{v,dist[v]});
                }
            }
        }
        return 0.0;

    }
}