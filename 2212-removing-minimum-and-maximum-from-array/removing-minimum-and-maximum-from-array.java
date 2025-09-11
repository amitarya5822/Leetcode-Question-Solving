class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 1;

        int minIdx = 0, maxIdx = 0;

        // find min and max indices
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }

        // case 1: remove from front
        int front = Math.max(minIdx + 1, maxIdx + 1);

        // case 2: remove from back
        int back = Math.max(n - minIdx, n - maxIdx);

        // case 3: remove one from front, one from back
        int front_back = Math.min(minIdx + 1 + (n - maxIdx), maxIdx + 1 + (n - minIdx));

        return Math.min(front, Math.min(back, front_back));
    }
}
