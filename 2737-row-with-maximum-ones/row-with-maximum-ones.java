class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxCount = -1;
        int maxRowIndex = 0;

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxRowIndex = i;
            }
        }
// return The index of the row with the maximum number of 1's and the number of 1's in that row
        return new int[]{maxRowIndex, maxCount};
    }
}