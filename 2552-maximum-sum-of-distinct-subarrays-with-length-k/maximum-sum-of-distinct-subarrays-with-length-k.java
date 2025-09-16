class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, sum = 0;
        int l = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int r = 0; r < nums.length; r++) {
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                sum -= nums[l++];
            }

            set.add(nums[r]);
            sum += nums[r];

            if (r - l + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                set.remove(nums[l]);
                sum -= nums[l++];
            }
        }

        return maxSum;
    }
}