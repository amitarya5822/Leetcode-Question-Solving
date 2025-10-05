class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();

        // visited matrices for both oceans
        boolean[][] pacificVisited = new boolean[rows][cols];
        boolean[][] atlanticVisited = new boolean[rows][cols];

        // 1️⃣ DFS from Pacific ocean borders (top row and left column)
        for(int i = 0;i<rows;i++){
            dfs(i,0,heights,pacificVisited,rows,cols);  // left border (Pacific)
            dfs(i,cols-1,heights,atlanticVisited,rows,cols);  //right border (Atlantic)
        }
          // 2️⃣ DFS from Atlantic ocean borders (bottom row and right column)
        for(int i = 0;i<cols;i++){
            dfs(0,i,heights,pacificVisited,rows,cols);  // top border (Pacific)
            dfs(rows-1,i,heights,atlanticVisited,rows,cols); //bottom border (Atlantic)
        }

        //common cells by both the oceans
        for(int i = 0;i< rows;i++){
            for(int j = 0;j<cols;j++){

                // continue DFS only if:
            // 1️⃣ new cell is inside bounds
            // 2️⃣ new cell not visited before
            // 3️⃣ new cell height is >= current cell (water can flow from higher to lower or equal)
                if(pacificVisited[i][j] && atlanticVisited[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int r,int c, int[][] heights,boolean[][] visited,int rows,int cols){
        visited[r][c] = true;

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] dir : directions){
            int newR = r + dir[0];
            int newC = c + dir[1];

            if(newR >= 0 && newC >= 0 && newR < rows && newC < cols && heights[newR][newC] >= heights[r][c] &&    !visited[newR][newC]){
                dfs(newR, newC, heights, visited, rows, cols);
            }
        }
    }
}