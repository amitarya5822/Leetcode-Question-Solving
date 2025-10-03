class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        // Step 1: push all boundary cells into min-heap
        for(int i =0;i<m;i++){
            pq.offer(new int[]{heightMap[i][0],i,0});
            visited[i][0] = true;
            pq.offer(new int[]{heightMap[i][n-1],i,n-1});
            visited[i][n-1] = true; 
        }
        for(int j = 0;j<n;j++){
            pq.offer(new int[]{heightMap[0][j],0,j});
            visited[0][j] = true;
            pq.offer(new int[]{heightMap[m-1][j],m-1,j});
            visited[m-1][j] = true;
        }
        int water = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
             int height = curr[0], r = curr[1], c = curr[2];
            
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    
                    // If neighbor is lower, water can be trapped
                    water += Math.max(0, height - heightMap[nr][nc]);
                    
                    // Update effective height for future boundary
                    pq.offer(new int[]{Math.max(height, heightMap[nr][nc]), nr, nc});
                }
            }
        }
        return water;
    }
}