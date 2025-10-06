class Solution {
    public int differenceOfSum(int[] nums) {
        int n = nums.length;
        int elementSum = 0;
        int digitSum = 0;
        for(int i = 0;i<n;i++){
            elementSum += nums[i];
            int num = nums[i];
            while (num != 0) {         // extract digits
                digitSum += num % 10;  // add last digit
                num /= 10;             // remove last digit
            }
        }
        return Math.abs(elementSum-digitSum);
    }
}