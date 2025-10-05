class Solution {
    public int alternatingSum(int[] nums) {
        int n = nums.length;
        int sumEven = 0;
        int sumOdd = 0;
        for(int i = 0;i<n;i++){
            if(i%2 == 0){
                sumEven += nums[i];
            }
            else{
                sumOdd += nums[i];
            }
        }
        return sumEven-sumOdd;
    }
}