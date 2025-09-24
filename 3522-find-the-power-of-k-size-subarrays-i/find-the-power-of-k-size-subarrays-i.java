class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = 1;
        // f[i] = length of consecutive increasing run ending at i
        for(int i = 1;i<n;i++){
            if(nums[i] == nums[i-1]+1){
                f[i] = f[i-1]+1;
            }
            else{
                f[i] = 1;
            }
        }
        int[] result = new int[n-k+1];
        for(int i = k-1;i<n;i++){
            if(f[i] >= k){
                result[i-k+1] = nums[i];
            }
            else{
                result[i-k+1] = -1;
            }
        }
        return result;
    }
}