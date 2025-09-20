class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> total  = new HashMap<>();
        int left = 0,maxLen = 0;
        for(int right = 0;right < fruits.length;right++){
            total.put(fruits[right],total.getOrDefault(fruits[right],0)+1);
        
        while(total.size() > 2){
            total.put(fruits[left],total.get(fruits[left])-1);
            if(total.get(fruits[left]) == 0){
                total.remove(fruits[left]);
            }
            left++;
        }
        
             maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;

    }
}