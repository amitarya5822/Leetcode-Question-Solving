class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums); //  sort an array

        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        // prefix sum
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int[] result = new int[queries.length];

        //  answer each query with binary search
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            int idx = binarySearch(prefix, q); 
            result[i] = idx; // idx = number of elements we can take
        }

        return result;
    }
    //  returns first index where prefix[index] > target
    public int binarySearch(int[] prefix, int target) {
        int l = 0, r = prefix.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (prefix[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l; // number of valid elements
    }
}