class Solution {
    public int swimInWater(int[][] grid) {
        //using priority with BFS

        int n = grid.length;
        // Min-heap (PriorityQueue) to always pick the cell with the smallest elevation first
        // Each element in the heap is an int[] = {height, row, column}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        boolean[][] visited = new boolean[n][n];
        // Push its height, row, and column into the min-heap
        pq.offer(new int[]{grid[0][0],0,0});

        visited[0][0] = true;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        int time = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int height = curr[0];
            int cr = curr[1];
            int cc = curr[2];

            time = Math.max(time,height);

            // If we've reached the bottom-right cell, return the time
            if (cr == n - 1 && cc == n - 1) {
                return time;
            }

            for(int[] d : dirs){
                int newR = cr + d[0];
                int newC = cc + d[1];

                if(newR >= 0 && newC >= 0 && newR < n && newC < n && !visited[newR][newC]  ){
                    visited[newR][newC] = true;
                    pq.offer(new int[]{grid[newR][newC],newR,newC});
                }
            }
        }
        return time;

    }
}