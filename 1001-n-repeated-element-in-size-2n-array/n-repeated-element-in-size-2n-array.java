class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i<n;i++){
            if(!hs.add(nums[i])){
                return nums[i];
            }
        }
        return -1;
    }
}