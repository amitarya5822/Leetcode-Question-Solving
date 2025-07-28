class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        // use 4 pointer  for boundaries
        int top = 0;
        int left = 0;
        int bottom = matrix.length-1;
        int right = matrix[0].length-1;

        while(top <= bottom && left <= right){
            // left to right
            for(int i = left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            top++;
            // top to bottom
            for(int i = top;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            right--;
            if(top <= bottom){
             // right to left
              for(int i = right;i>=left;i--){
                  ans.add(matrix[bottom][i]);
                }
            }
            bottom--;
            if(left <= right){
            //  bottom to top
              for(int i = bottom;i>= top;i--){
                 ans.add(matrix[i][left]);
                }
            }
            left++;
        }
        return ans;
    }
}