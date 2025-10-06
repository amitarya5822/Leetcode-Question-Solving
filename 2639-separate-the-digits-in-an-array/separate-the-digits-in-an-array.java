class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        // Loop through each number in nums
        for (int num : nums) {
            // Convert number to string and extract each digit
            for (char ch : String.valueOf(num).toCharArray()) {
                answer.add(ch - '0'); // convert char to int
            }
        }

        // Convert list to array
        int[]result = new int[answer.size()];
        for(int i = 0;i<answer.size();i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}