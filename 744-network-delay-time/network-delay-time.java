class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // using of Dijkstra Algorithm
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : times){
            int u = edge[0], v = edge[1], timeTaken = edge[2];
            adj.get(u).add(new int[]{v,timeTaken});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;
// min heap priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int distU = curr[1];

            if(distU > dist[u]) continue;

            for(int i= 0;i< adj.get(u).size();i++){
                int[] temp = adj.get(u).get(i);
                int v = temp[0];
                int timeTakenV = temp[1];

                if(dist[v] > distU + timeTakenV){
                    dist[v] = distU + timeTakenV;
                    pq.offer(new int[]{v,dist[v]});
                }
            }
        }
// in dist[] ,there store maximum value from source to distination, and the minimum time taken to reach the destination is  max dist,so ... it will give the delay time.
// and if dist[]  is infinity then return -1;
        int minTime = 0;
        for(int i = 1;i <= n;i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            minTime = Math.max(minTime,dist[i]);
        }
        return minTime;
    }
}