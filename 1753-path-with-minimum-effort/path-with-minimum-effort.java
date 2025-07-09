class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    public int minimumEffortPath(int[][] heights) {
        int low = 0;
        int high = 1000000;
        int ans  = 0;
        
        while(low<=high){                //binary search with ans
            int mid = low+(high-low)/2;
            if(canReach(heights,mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    boolean canReach(int[][] heights,int maxeffort){
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            if( x == n-1 && y == m-1) return true;

            for(int d = 0;d<4;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]){
                    int  effort = Math.abs(heights[x][y]- heights[nx][ny]);
                    if(effort <= maxeffort){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        return false;
    }
}