class Solution{
    public int[] twoSum(int[] nums,int target){
        int n = nums.length;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<n;i++){
            int remain =  target - nums[i];
            if(hm.containsKey(remain)){
                return new int[] {hm.get(remain),i};
            }
            hm.put(nums[i],i);
        }
        return new int[] {-1,-1};
    }
}