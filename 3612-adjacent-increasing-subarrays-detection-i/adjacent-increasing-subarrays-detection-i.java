class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();  
        int curr = 1;         // length of curr increasing sequence
        int prev = 0;         // length of prev increasing sequence
        int maxLen = 0;       // maximum possible adjacent increasing subarray length found

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                curr++;  
            } 
            else {
                prev = curr;  // store the finished streak length
                curr = 1;     // reset current streak length
            }

            // Update the maximum possible length of adjacent increasing subarrays
            // Case 1: two subarrays within the same increasing run → curr/2
            // Case 2: use both previous and current streaks → max(curr, prev)
            maxLen = Math.max(maxLen, Math.max(curr / 2, Math.min(prev, curr)));
            if(maxLen >= k) return true;
        }
        return false;
    }
}
