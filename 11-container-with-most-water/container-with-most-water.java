class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0,right = n-1;
        int maxArea = 0;
        while(left < right){
            // The container's height is determined by the shorter line
            int mini = Math.min(height[left],height[right]);
            int width = right-left;
            maxArea = Math.max(maxArea,mini*width);

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;

    }
}