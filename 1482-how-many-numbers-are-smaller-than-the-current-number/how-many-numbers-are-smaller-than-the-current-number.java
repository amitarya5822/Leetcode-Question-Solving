// class Solution {
//     public int[] smallerNumbersThanCurrent(int[] nums) {
//         int[] result = new int[nums.length];

//         for(int i = 0;i< nums.length;i++){
//             int count = 0;
//           for(int j = 0;j<nums.length;j++){
//             if(nums[j] < nums[i]){
//                 count++;
//             }
//           }
//           result[i] = count;
//         }
        
//         return result;
//     }
// }

// using hashmap

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] copy = nums.clone();
        
        Arrays.sort(copy);
        
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(copy[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            copy[i] = map.get(nums[i]);
        }
        
        return copy;
    }
}